package cn.xiaoyanol.crawler.service;

import cn.xiaoyanol.crawler.domain.website.Data;

import java.io.IOException;
import java.util.List;

/**
 * @description:
 * @author: mike ling
 * @date: 2020/12/4 15:17
 */
public interface IWebsiteService {

    List<Data> getWebsiteList(Long companyId) throws IOException;
}
