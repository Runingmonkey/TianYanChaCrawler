package cn.xiaoyanol.crawler.mapper;

import cn.xiaoyanol.crawler.dao.domain.TrademarkDetail;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @description:
 * @author: mike ling
 * @date: 2020/12/15 10:46
 */
@org.apache.ibatis.annotations.Mapper
@Repository
public interface TradeMarkDetailMapper extends Mapper<TrademarkDetail>, MySqlMapper<TrademarkDetail> {
}
