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
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.spring.annotation.MapperScan;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.*;
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

    @Autowired
    private Patent2Mapper patent2Mapper;

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

        System.out.println("请输入你要执行的程序: 1, 查询公司数据; 2, 商标详情; 3, 专利信息");
        Scanner scanner = new Scanner(System.in);
        String in = scanner.nextLine();
        int i = Integer.parseInt(in);
        if (i == 1) {
            // 查询线程
            executorService.execute(() ->{
                search();
            });
        } else if (i == 2) {
            // 插入商标详情
            executorService.execute(()->{
                tradeMarkDetail();
            });
        } else if (i == 3) {
            // 插入专利信息
            executorService.execute(()->{
                try {
                    getPatent();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
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
//                    company.setIsImportant(0);

                    String s = JsonUtils.toJSONString(baseInfo);
                    System.out.println(s);
                    companyMapper.insert(company);
                    log.info("查询结果公司名: " + baseInfo.getName());
                    cid = company.getId();
                    if ("注销".equals(company.getRegStatus()) || "吊销，未注销".equals(company.getRegStatus()) || "吊销".equals(company.getRegStatus())) {
                        continue;
                    }
                }

                // 公司专利信息 (所有)
                PatentServiceImpl patentService = new PatentServiceImpl(headers);
                List<Items> patentList = patentService.getPatentList(search.getId());
                insertPatent2(cid, patentList);

                // 公司商标信息 (所有)
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
        // 获取企业名单
//        Example companyExample = new Example(Company.class);
//        companyExample.createCriteria().andEqualTo("isImportant", 0);
//        List<Company> companies = companyMapper.selectByExample(companyExample);

        // 需要获取详情的 商标列表
//        List<Trademark> trademarkArrayList = new ArrayList<>();
//        for (Company company : companies) {
//            Example tradeMarkExample = new Example(Trademark.class);
//            tradeMarkExample.createCriteria().andEqualTo("cid", company.getId());
//            List<Trademark> tList = trademarkMapper.selectByExample(tradeMarkExample);
//            trademarkArrayList.addAll(tList);
//        }

        // 是否已经存在
//        Example example = new Example(TrademarkDetail.class);
//        example.createCriteria().andEqualTo("regNo");
//        tradeMarkDetailMapper.selectByExample(example);


        // 获取所有商标
        Example example = new Example(Trademark.class);
        example.createCriteria().andGreaterThan("id", 116412);
        List<Trademark> trademarkList = trademarkMapper.selectByExample(example);

        for (Trademark trademark : trademarkList) {
            Map<String, String> head = HeaderUtils.getHeaders();
            TradeMarkDetailServiceImpl tradeMarkDetailService = new TradeMarkDetailServiceImpl(head);
            TrademarkDetail tradeMarkDetail = tradeMarkDetailService.getTradeMarkDetail(trademark);
            log.info("查询: {} 的商标信息", "id " + trademark.getCid() + " 名 " + trademark.getApplicantCn());
            log.info("结果: " + tradeMarkDetail);
            tradeMarkDetailMapper.insert(tradeMarkDetail);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @description 获取专利信息
     * @author mike ling
     * @date 2020/12/18 12:24
     * @param:
     * @return void
     */
    private synchronized void getPatent() throws IOException {
        Example example = new Example(Company.class);
//        Example.Criteria criteria = example.createCriteria().orEqualTo("regStatus", "在业").orEqualTo("regStatus", "存续").orEqualTo("regStatus", "正常");
        // 断点续查
        example.createCriteria().andGreaterThan("id", 242892);

        List<Company> companies = companyMapper.selectByExample(example);

        for (Company company : companies) {
            Map<String, String> headers = HeaderUtils.getHeaders();
            PatentServiceImpl patentService = new PatentServiceImpl(headers);
            Long tycId = Long.valueOf(company.getTycId());
            List<Items> patentList = patentService.getPatentList(tycId);
            log.info("查询: {} 的专利信息",company.getId() + ":" + company.getName());
            insertPatent2(company.getId(), patentList);
            System.out.println();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void insertPatent2(Long companyId, List<Items> patentList) {
        if (!patentList.isEmpty()) {
            List<Patent2> inserts = patentList.stream().map(r ->{
                Patent2 patent2 = new Patent2();
                patent2.setCid(companyId);
                patent2.setPatentName(r.getPatentName());
                patent2.setAppNumber(r.getAppnumber());
                patent2.setTitle(r.getTitle());
                patent2.setApplicantName(r.getApplicantName());
                patent2.setPatenttype(r.getPatentType());
                patent2.setAllCatNum(r.getAllCatNum());
                patent2.setPatentNum(r.getPatentNum());
                if (r.getApplicationTime() != null) {
                    Date applicationTime = r.getApplicationTime();
                    Long time = applicationTime.getTime();
                    patent2.setApplicationTime(parseDate(time.toString()));
                }
                if (r.getPubDate() != null) {
                    Long time = r.getPubDate().getTime();
                    patent2.setPubDate(parseDate(time.toString()));

                }
                patent2.setPubNum(r.getPubnumber());
                patent2.setInventor(r.getInventor());
                patent2.setAgent(r.getAgent());
                patent2.setAgency(r.getAgency());
                patent2.setLawStatus(r.getLprs());
                if (r.getLawStatus() != null) {
                    patent2.setLawStatusFlow(JSON.toJSONString(r.getLawStatus()));
                }
                patent2.setAddress(r.getAddress());
                patent2.setImgurl(r.getImgUrl());
                patent2.setAbstracts(r.getAbstracts());
                return patent2;
            }).collect(Collectors.toList());
            patent2Mapper.insertList(inserts);
        }
    }


    /**
     * @description 时间戳转换Date
     * @author mike ling
     * @date 2020/12/15 14:31
     * @param:
     * @return void
     */
    public LocalDate parseDate(String timeStr) {
        long milliseconds = Long.parseLong(timeStr);
        /// 毫秒级时间戳 -> LocalDateTime
//                LocalDateTime localDateTime = LocalDateTime.ofEpochSecond(milliseconds / 1000, 0, ZoneOffset.ofHours(8));
        // 毫秒级时间戳 -> LocalDate
        LocalDate localDate = Instant.ofEpochMilli(milliseconds).atZone(ZoneOffset.ofHours(8)).toLocalDate();

        return localDate;
    }

}
