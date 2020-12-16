package cn.xiaoyanol.crawler.service;


import cn.xiaoyanol.crawler.dao.domain.Trademark;
import cn.xiaoyanol.crawler.dao.domain.TrademarkDetail;

/**
 * @description:
 * @author: mike ling
 * @date: 2020/12/14 15:19
 */
public interface ITradeMarkDetailService {

    /**
     * @description 爬取重点企业的商标数
     * @author mike ling
     * @date 2020/12/14 15:42
     * @param:
     * @return void
     */
    TrademarkDetail getTradeMarkDetail(Trademark trademark);


}
