package cn.xiaoyanol.crawler.service.impl;

import cn.xiaoyanol.crawler.constant.UrlConstant;
import cn.xiaoyanol.crawler.dao.domain.Trademark;
import cn.xiaoyanol.crawler.dao.domain.TrademarkDetail;
import cn.xiaoyanol.crawler.domain.trademarkdetail.*;
import cn.xiaoyanol.crawler.service.ITradeMarkDetailService;
import cn.xiaoyanol.crawler.utils.HttpClientUtils;
import com.alibaba.fastjson.JSON;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: mike ling
 * @date: 2020/12/14 15:20
 */
public class TradeMarkDetailServiceImpl implements ITradeMarkDetailService {

    private static final String url = UrlConstant.TRADEMARK_DETAIL;

    private Map<String, String> headers;

    public TradeMarkDetailServiceImpl(Map<String, String> _headers) {
        this.headers = _headers;
    }

    /**
     * @description 获取商标详情
     * @author mike ling
     * @date 2020/12/14 15:42
     * @param:
     */
    @Override
    public TrademarkDetail getTradeMarkDetail(Trademark trademark) {
        try {
            Map<String, String> params = new HashMap<>(16);
            String regNo = trademark.getRegNo();
            String tmClass = trademark.getTmClass();
            params.put("regNo", regNo);
            params.put("tmClass", tmClass + "-");
            CloseableHttpResponse response = HttpClientUtils.doGet(url, headers, params);
            String s = EntityUtils.toString(response.getEntity());
            JsonsRootBean jsonsRootBean = JSON.parseObject(s, JsonsRootBean.class);

            Data data = jsonsRootBean.getData();
            // 详情
            Detail detail = data.getDetail();

            // 商品 / 服务
            List<Goodslist> goodsList = data.getGoodsList();
            String goodsListString = JSON.toJSONString(goodsList);

            // 申请流程
            List<Flowlist> flowList = data.getFlowList();
            String flowListString = JSON.toJSONString(flowList);

            TrademarkDetail trademarkDetail = new TrademarkDetail();
            if (data.getCompanyId() != null) {
                trademarkDetail.setTycId(Long.valueOf(data.getCompanyId()));
            }
            trademarkDetail.setCid(trademark.getCid());
            trademarkDetail.setTmName(trademark.getTmName());
            trademarkDetail.setRegNo(detail.getRegNo());
            if (detail.getAppDate() != null) {
                trademarkDetail.setAppDate(parseDate(detail.getAppDate().toString()));
            }
            trademarkDetail.setIntCls(detail.getIntCls());
            trademarkDetail.setApplicantCn(detail.getApplicantCn());
            if (detail.getApplicantCnList() != null) {
                trademarkDetail.setApplicantCnList(JSON.toJSONString(detail.getApplicantCnList()));
            }
            trademarkDetail.setAddressCn(detail.getAddressCn());
            trademarkDetail.setApplicantOther1(detail.getApplicantOther1());
            trademarkDetail.setApplicantOther2(detail.getApplicantOther2());
            trademarkDetail.setApplicantEn(detail.getApplicantEn());
            trademarkDetail.setAddressEn(detail.getAddressEn());
            trademarkDetail.setAnnouncementIssue(detail.getAnnouncemenIssue());
            if (detail.getAnnouncementDate() != null) {
                trademarkDetail.setAnnouncementDate(parseDate(detail.getAnnouncementDate().toString()));
            }
            trademarkDetail.setRegIssue(detail.getRegIssue());
            if (detail.getRegDate() != null) {
                trademarkDetail.setRegDate(parseDate(detail.getRegDate().toString()));
            }
            if (detail.getPrivateDateStart() != null) {
                trademarkDetail.setPrivateDateStart(detail.getPrivateDateStart().toString());
            }
            if (detail.getPrivateDateEnd() != null) {
                trademarkDetail.setPrivateDateEnd(detail.getPrivateDateEnd().toString());
            }
            trademarkDetail.setAgent(detail.getAgent());
            if (detail.getAgentList() != null) {
                trademarkDetail.setAgentList(JSON.toJSONString(detail.getAgentList()));
            }
            trademarkDetail.setTmPic(detail.getTmPic());
            trademarkDetail.setClsStr(detail.getClsStr());
            trademarkDetail.setStatusStr(detail.getStatusStr());
            trademarkDetail.setCategoryStr(detail.getCategoryStr());
            if (detail.getClsDesc1() != null) {
                trademarkDetail.setClsDesc1(JSON.toJSONString(detail.getClsDesc1()));
            }
            if (detail.getClsDesc2() != null) {
                trademarkDetail.setClsDesc2(JSON.toJSONString(detail.getClsDesc2()));
            }
            trademarkDetail.setGoodServer(goodsListString);
            trademarkDetail.setFlow(flowListString);

            return trademarkDetail;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
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
