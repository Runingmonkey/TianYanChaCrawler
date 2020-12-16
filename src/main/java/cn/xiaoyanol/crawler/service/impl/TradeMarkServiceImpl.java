package cn.xiaoyanol.crawler.service.impl;

import cn.xiaoyanol.crawler.constant.UrlConstant;
import cn.xiaoyanol.crawler.dao.domain.Company;
import cn.xiaoyanol.crawler.dao.domain.Trademark;
import cn.xiaoyanol.crawler.domain.trademark.Items;
import cn.xiaoyanol.crawler.domain.trademark.JsonsRootBean;
import cn.xiaoyanol.crawler.mapper.CompanyMapper;
import cn.xiaoyanol.crawler.mapper.TrademarkMapper;
import cn.xiaoyanol.crawler.service.ITradeMarkService;
import cn.xiaoyanol.crawler.utils.HttpClientUtils;
import cn.xiaoyanol.crawler.utils.JsonUtils;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.client.HttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @description:
 * @author: mike ling
 * @date: 2020/12/2 17:50
 */
public class TradeMarkServiceImpl implements ITradeMarkService {

    @Autowired
    private TrademarkMapper trademarkMapper;

    @Autowired
    private CompanyMapper companyMapper;

    private static String url = UrlConstant.TRADEMARK_LIST_URL;
    private Map<String, String> headers;
    private static Integer SIZE = 500;

    public TradeMarkServiceImpl(Map<String, String> _headers) {
        this.headers = _headers;
    }

    /**
     * @description 获取公司的商标信息
     * @author mike ling
     * @date 2020/12/2 17:49
     * @param: companyId
     */
    @Override
    public List<Items> getTradeMarkList(Long companyId) {
        int requestPage = 1;
        String jsonPost = getPostJson(companyId, 1);
        List<Items> items = doPostGetRes(jsonPost);

        if (items.isEmpty()) {
            return new ArrayList<>();
        }
        while (items.size() == SIZE * requestPage) {
            // 请求页数
            requestPage = requestPage + 1;
            List<Items> list = doPostGetRes(getPostJson(companyId, requestPage));
            items.addAll(list);
            if (list.size() < SIZE) {
                break;
            }
        }
        return Optional.ofNullable(items).orElse(new ArrayList<>());
    }


    private List<Items> doPostGetRes(String jsonPost) {
        // post
        String res = HttpClientUtils.doPost(url, this.headers, jsonPost);
        JsonsRootBean jsonsRootBean = JsonUtils.convertValue(res, JsonsRootBean.class);
        return jsonsRootBean.getData().getItems();
    }

    private String getPostJson(Long companyId, int i) {
        // "ps":20 每页条数    "pn":3 页码
        // {"id":"23402373","ps":20,"pn":3,"int_cls":-100,"status":-100,"category":-100,"app_year":-100}
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", companyId.toString());
        jsonObject.put("ps", 500);
        jsonObject.put("pn", i);
        jsonObject.put("int_cls", -100);
        jsonObject.put("status", -100);
        jsonObject.put("category", -100);
        jsonObject.put("app_year", -100);
        return jsonObject.toString();
    }



//    @Override
//    public List<Trademark> getKeyEnterprisesTradeMarkList() {
//        // 获取重点企业名单
//        Example companyExample = new Example(Company.class);
//        companyExample.createCriteria().andEqualTo("isImportant", 1);
//        List<Company> companies = companyMapper.selectByExample(companyExample);
//
//        // 需要获取详情的 商标列表
//        List<Trademark> trademarkArrayList = new ArrayList<>();
//        for (Company company : companies) {
//            Example tradeMarkExample = new Example(Trademark.class);
//            tradeMarkExample.createCriteria().andEqualTo("cid", company.getId());
//            List<Trademark> tList = trademarkMapper.selectByExample(tradeMarkExample);
//            trademarkArrayList.addAll(tList);
//        }
//
//        return trademarkArrayList;
//    }

}
