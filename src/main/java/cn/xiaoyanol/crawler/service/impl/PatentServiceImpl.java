package cn.xiaoyanol.crawler.service.impl;

import cn.xiaoyanol.crawler.constant.UrlConstant;
import cn.xiaoyanol.crawler.domain.patentinfo.Items;
import cn.xiaoyanol.crawler.domain.patentinfo.JsonsRootBean;
import cn.xiaoyanol.crawler.domain.patentinfo.Data;
import cn.xiaoyanol.crawler.service.IPatentService;
import cn.xiaoyanol.crawler.utils.HttpClientUtils;
import cn.xiaoyanol.crawler.utils.JsonUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.*;

/**
 * @description: 公司专利
 * @author: mike ling
 * @date: 2020/12/2 15:36
 */
public class PatentServiceImpl implements IPatentService {

    private static String url = UrlConstant.PATENT_INFO_URL;
    private static String STATE = "warn";
    private static Integer SIZE = 500;
    private Map<String, String> headers;

    public PatentServiceImpl(Map<String, String> _headers) {
        this.headers = _headers;
    }

    @Override
    public List<Items> getPatentList(Long companyId) throws IOException {
        // 首次查询
        Integer i = 1;
        Map<String, String> params = getParams(companyId, i);
        CloseableHttpResponse response = HttpClientUtils.doGet(url, this.headers, params);
        String s = EntityUtils.toString(response.getEntity());
        JsonsRootBean jsonsRootBean = JsonUtils.convertValue(s, JsonsRootBean.class);
        if (STATE.equalsIgnoreCase(jsonsRootBean.getState())) {
            return new ArrayList<>();
        }
        Data data =  jsonsRootBean.getData();
        Integer viewTotal = Integer.valueOf(data.getViewtotal());
        Integer totalPage = viewTotal / SIZE;
        List<Items> itemsList = data.getItems();

        if (totalPage > 1) {
            for (Integer j = 2; j <= totalPage + 1; j++) {
                // 请求参数
                Map<String, String> map = getParams(companyId, j);
                // 发送请求
                List<Items> items = doGetRequestAndGetRes(map, companyId, itemsList);
                itemsList.addAll(items);
            }
        }

        return Optional.ofNullable(itemsList).orElse(new ArrayList<>());
    }

    private Map<String, String> getParams(Long companyId, Integer j) {
        Map<String, String> params1 = new HashMap<>();
        params1.put("id",companyId.toString());
        params1.put("pageNum",j.toString());
        params1.put("pageSize","500");
        return params1;
    }

    private List<Items> doGetRequestAndGetRes(Map<String, String> param, Long companyId, List<Items> itemsList) throws IOException {
        CloseableHttpResponse response = HttpClientUtils.doGet(url, this.headers, param);
        String s = EntityUtils.toString(response.getEntity());
        JsonsRootBean jsonsRootBean = JsonUtils.convertValue(s, JsonsRootBean.class);
        if (STATE.equalsIgnoreCase(jsonsRootBean.getState())) {
            return new ArrayList<>();
        }
        Data data =  jsonsRootBean.getData();
        List<Items> resItems = data.getItems();
        return resItems;
    }
}
