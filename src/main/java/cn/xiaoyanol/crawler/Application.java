package cn.xiaoyanol.crawler;

import cn.xiaoyanol.crawler.constant.UrlConstant;
import cn.xiaoyanol.crawler.dao.domain.*;
import cn.xiaoyanol.crawler.domain.baseinfo.BaseInfo;
import cn.xiaoyanol.crawler.domain.patentinfo.Items;
import cn.xiaoyanol.crawler.domain.search.Search;
import cn.xiaoyanol.crawler.domain.website.Data;
import cn.xiaoyanol.crawler.mapper.*;
import cn.xiaoyanol.crawler.service.IBaseInfoService;
import cn.xiaoyanol.crawler.service.ISearchService;
import cn.xiaoyanol.crawler.service.impl.*;
import cn.xiaoyanol.crawler.utils.FileReaderUtils;
import cn.xiaoyanol.crawler.utils.HeaderUtils;
import cn.xiaoyanol.crawler.utils.JsonUtils;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.spring.annotation.MapperScan;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;


/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @Author: chenyanfeng
 * @Date: 2018-11-25
 * @Time: 下午9:39
 */
@Slf4j
@SpringBootApplication
@MapperScan(basePackages = "cn.xiaoyanol.crawler.mapper")
public class Application implements CommandLineRunner {

    @Autowired
    private CompanyMapper companyMapper;

    @Autowired
    private PatentMapper patentMapper;

    @Autowired
    private TrademarkMapper trademarkMapper;

    @Autowired
    private WebsiteMapper websiteMapper;

    @Autowired
    private TradeMarkDetailMapper tradeMarkDetailMapper;

    private boolean exportFlag = true;

    private String authorization;

    private int seconds;

    private int sleepTime;

    private ExecutorService executorService = Executors.newFixedThreadPool(2);

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {

        // 查询前设置
        // token 非常重要， 微信小程序抓包获取
//          0###oo34J0ZRgatN5UBO8UQRwap6Ew_A###1565664617903###24ed6f7b1512aee63869b97552a2bd8f
//          0###oo34J0SZrKScRTJU2u2eEqfuXcgY###1607312275283###17237e17bffd86276115925c58e8bc60
//          0###oo34J0fFDKXx5Z-2PJTtCnw2n-0Y###1607323308193###1946c7a6e21b36be2794687af026ed29  liyun
//          0###oo34J0SZrKScRTJU2u2eEqfuXcgY###1607328435951###17237e17bffd86276115925c58e8bc60  mylogin
        authorization = "0###oo34J0SZrKScRTJU2u2eEqfuXcgY###1607328435951###17237e17bffd86276115925c58e8bc60";
        // 导出数据频率 默认 5 秒每次
        seconds = 5;
        // 查询频率 单位：毫秒
        sleepTime = 300;


        // 查询线程
//        executorService.execute(() ->{
//            search();
//        });


        // 插入商标详情
        executorService.execute(()->{
            tradeMarkDetail();
        });



    }



    /**
     * 查询
     */
    private synchronized void search() {
        // 读取要查询的公司
        List<String> companyList = FileReaderUtils.getCompanyList();
        if (companyList.size() == 0) {
            log.info("没有需要查询的门店");
            return;
        }

        // 设置token  通过小程序抓包获取

        // 先搜索

        for (String companyName : companyList) {
            Map<String, String> headers = HeaderUtils.getHeaders();
            ISearchService searchService = new SearchServiceImpl(headers);
            try {
                log.info("正在查询：{}", companyName);

                if (sleepTime < 0) {
                    sleepTime = 1;
                }
                Thread.sleep(sleepTime);

                // 默认搜索10个
                List<Search> searchResult = searchService.getSearchResult(companyName);
                // 只取第一个
                Search search = searchResult.get(0);

                // 公司基本信息
                Long cid = null;
                IBaseInfoService baseInfoService = new BaseInfoServiceImpl(headers);
                BaseInfo baseInfo = baseInfoService.getBaseInfoResult(search.getId());
                if (baseInfo != null) {
                    Company company = new Company();
                    company.setTycId(baseInfo.getId());
                    company.setLegalPersonName(baseInfo.getLegalPersonName());
                    company.setName(baseInfo.getName());
                    company.setOrgNumber(baseInfo.getOrgNumber());
                    company.setCreditCode(baseInfo.getCreditCode());
                    company.setRegStatus(baseInfo.getRegStatus());
                    company.setEmail(baseInfo.getEmail());
                    company.setPhoneNumber(baseInfo.getPhoneNumber());
                    company.setFromTime(baseInfo.getFromTime());
                    company.setType(baseInfo.getType());
                    company.setBondName(baseInfo.getBondName());
                    company.setRegNumber(baseInfo.getRegNumber());
                    company.setRegCapital(baseInfo.getRegCapital());
                    company.setRegInstitute(baseInfo.getRegInstitute());
                    company.setRegLocation(baseInfo.getRegLocation());
                    company.setIndustry(baseInfo.getIndustry());
                    company.setApprovedTime(baseInfo.getApprovedTime());
                    company.setBusinessScope(baseInfo.getBusinessScope());
                    company.setAlias(baseInfo.getAlias());
                    company.setCompanyOrgType(baseInfo.getCompanyOrgType());
                    company.setIsImportant(1);

                    String s = JsonUtils.toJSONString(baseInfo);
                    System.out.println(s);
                    companyMapper.insert(company);
                    log.info("查询结果公司名: " + baseInfo.getName());
                    cid = company.getId();
                    if ("注销".equals(company.getRegStatus()) || "吊销，未注销".equals(company.getRegStatus()) || "吊销".equals(company.getRegStatus())) {
                        continue;
                    }
                }


                // 公司专利信息
                PatentServiceImpl patentService = new PatentServiceImpl(headers);
                List<Items> patentList = patentService.getPatentList(search.getId());
                if (!patentList.isEmpty()) {
                    Long finalCid = cid;
                    List<Patent> inserts = patentList.stream().map(r ->{
                        Patent patent = new Patent();
                        patent.setCid(finalCid);
                        patent.setPatent_name(r.getPatentName());
                        patent.setApp_Number(r.getAppnumber());
                        patent.setTitle(r.getTitle());
                        patent.setApplicant_name(r.getApplicantname());
                        patent.setPatentType(r.getPatentType());
                        patent.setApplication_time(r.getApplicationTime());
                        patent.setPub_date(r.getPubDate());
                        patent.setAgency(r.getAgency());
                        patent.setInventor(r.getInventor());
                        patent.setAgent(r.getAgent());
                        patent.setPatent_num(r.getPatentNum());
                        patent.setImgurl(r.getImgUrl());
                        patent.setAll_cat_num(r.getAllCatNum());
                        patent.setAbstracts(r.getAbstracts());
                        patent.setAddress(r.getAddress());
                        return patent;
                    }).collect(Collectors.toList());
                    patentMapper.insertList(inserts);
                }

                // 公司商标信息
                TradeMarkServiceImpl tradeMarkService = new TradeMarkServiceImpl(headers);
                List<cn.xiaoyanol.crawler.domain.trademark.Items> list = tradeMarkService.getTradeMarkList(search.getId());

                if (!list.isEmpty()) {
                    Long finalCid1 = cid;
                    List<Trademark> trademarkList = list.stream().map(r ->{
                        Trademark trademark = new Trademark();
                        trademark.setCid(finalCid1);
                        trademark.setStatus(r.getStatus());
                        trademark.setIntClsV2(r.getIntClsV2());
                        trademark.setTmClass(r.getTmClass());
                        trademark.setTmName(r.getTmName());
                        trademark.setTmFlow(r.getTmFlow());
                        trademark.setTmPic(r.getTmPic());
                        trademark.setEventTime(r.getEventTime());
                        trademark.setRegNo(r.getRegNo());
                        trademark.setApplicantCn(r.getApplicantCn());
                        return trademark;
                    }).collect(Collectors.toList());
                    trademarkMapper.insertList(trademarkList);
                }

                // 公司网站备案
                WebsiteServiceImpl websiteService = new WebsiteServiceImpl(headers);
                List<Data> websiteList = websiteService.getWebsiteList(search.getId());

                if (!websiteList.isEmpty()) {
                    Long finalCid2 = cid;
                    List<Website> webs = websiteList.stream().map(r ->{
                        Website site = new Website();
                        site.setCid(finalCid2);
                        site.setWebSite(JSONObject.toJSON(r.getWebSite()).toString());
                        site.setExamineDate(r.getExamineDate());
                        site.setCompanyType(r.getCompanyType());
                        site.setWebName(r.getWebName());
                        site.setYm(r.getYm());
                        site.setCompanyName(r.getCompanyName());
                        site.setLiscense(r.getLiscense());
                        return site;
                    }).collect(Collectors.toList());
                    websiteMapper.insertList(webs);
                }

            }catch (Exception e) {
                log.error("查询错误, 公司名：{}, 错误信息：{}", companyName, e.getMessage());
                e.printStackTrace();
            }

        }
//        exportFlag = false;
//        export(false, 0);
        log.info("查询完成，退出程序");
        executorService.shutdown();

    }


    /**
     * @description 商标详情
     * @author mike ling
     * @date 2020/12/14 15:36
     * @return void
     */
    private synchronized void tradeMarkDetail() {
        // 获取重点企业名单
        Example companyExample = new Example(Company.class);
        companyExample.createCriteria().andEqualTo("isImportant", 1);
        List<Company> companies = companyMapper.selectByExample(companyExample);

        // 需要获取详情的 商标列表
        List<Trademark> trademarkArrayList = new ArrayList<>();
        for (Company company : companies) {
            Example tradeMarkExample = new Example(Trademark.class);
            tradeMarkExample.createCriteria().andEqualTo("cid", company.getId());
            List<Trademark> tList = trademarkMapper.selectByExample(tradeMarkExample);
            trademarkArrayList.addAll(tList);
        }

        for (Trademark trademark : trademarkArrayList) {
            Map<String, String> head = HeaderUtils.getHeaders();
            TradeMarkDetailServiceImpl tradeMarkDetailService = new TradeMarkDetailServiceImpl(head);
            TrademarkDetail tradeMarkDetail = tradeMarkDetailService.getTradeMarkDetail(trademark);
            System.out.println();
            System.out.println(tradeMarkDetail);
            tradeMarkDetailMapper.insert(tradeMarkDetail);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
