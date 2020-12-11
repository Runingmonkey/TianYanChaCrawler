package cn.xiaoyanol.crawler.service.impl;

import cn.xiaoyanol.crawler.constant.UrlConstant;
import cn.xiaoyanol.crawler.domain.website.Data;
import cn.xiaoyanol.crawler.domain.website.JsonsRootBean;
import cn.xiaoyanol.crawler.service.IWebsiteService;
import cn.xiaoyanol.crawler.utils.HttpClientUtils;
import cn.xiaoyanol.crawler.utils.JsonUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @description:
 * @author: mike ling
 * @date: 2020/12/4 15:18
 */
public class WebsiteServiceImpl implements IWebsiteService {

    private static final String STATE = "warn";
    public static String url = UrlConstant.WEBSITE_LIST;

    private Map<String, String> headers;

    public WebsiteServiceImpl(Map<String, String> _headers) {
        this.headers = _headers;
    }


    @Override
    public List<Data> getWebsiteList(Long companyId) throws IOException {

        CloseableHttpResponse response = HttpClientUtils.doGet(url + companyId.toString() + ".json", this.headers, null);
        String s = EntityUtils.toString(response.getEntity());
        JsonsRootBean jsonsRootBean = JsonUtils.convertValue(s, JsonsRootBean.class);

        if (STATE.equalsIgnoreCase(jsonsRootBean.getState())) {
            return new ArrayList<>();
        }

        List<Data> data = jsonsRootBean.getData();
        return Optional.ofNullable(data).orElse(new ArrayList<>());
    }
}
