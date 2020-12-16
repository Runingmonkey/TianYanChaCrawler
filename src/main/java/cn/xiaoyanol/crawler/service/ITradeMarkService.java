package cn.xiaoyanol.crawler.service;

import cn.xiaoyanol.crawler.dao.domain.Trademark;
import cn.xiaoyanol.crawler.domain.trademark.Items;

import java.util.List;

/**
 * @description: 商标接口
 * @author: mike ling
 * @date: 2020/12/2 17:48
 */
public interface ITradeMarkService {

    /**
     * @description 获取公司的商标信息
     * @author mike ling
     * @date 2020/12/2 17:49
     * @param: companyId
     * @return
     */
    List<Items> getTradeMarkList(Long companyId);


    /**
     * @description 获取重点企业的商标数据
     * @author mike ling
     * @date 2020/12/14 16:12
     * @param:
     * @return java.util.List<cn.xiaoyanol.crawler.dao.domain.Trademark>
     */
//    List<Trademark> getKeyEnterprisesTradeMarkList();

}
