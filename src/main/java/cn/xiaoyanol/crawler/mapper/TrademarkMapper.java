package cn.xiaoyanol.crawler.mapper;

import cn.xiaoyanol.crawler.dao.domain.Trademark;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @description:
 * @author: mike ling
 * @date: 2020/12/3 17:19
 */
@org.apache.ibatis.annotations.Mapper
@Repository
public interface TrademarkMapper extends Mapper<Trademark>, MySqlMapper<Trademark> {
}
