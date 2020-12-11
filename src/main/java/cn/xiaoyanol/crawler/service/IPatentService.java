package cn.xiaoyanol.crawler.service;

import cn.xiaoyanol.crawler.domain.patentinfo.Items;

import java.io.IOException;
import java.util.List;

/**
 * @description: 专利接口
 * @author: mike ling
 * @date: 2020/12/2 15:33
 */
public interface IPatentService {

    /**
     * @description 获取公司的专利信息
     * @author mike ling
     * @date 2020/12/2 15:39
     * @param: company
     * @return java.util.List<cn.xiaoyanol.crawler.domain.patentinfo.Items>
     */
    List<Items> getPatentList(Long company) throws IOException;

}
