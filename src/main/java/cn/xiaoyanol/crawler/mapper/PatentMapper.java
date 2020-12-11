package cn.xiaoyanol.crawler.mapper;

import cn.xiaoyanol.crawler.dao.domain.Patent;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @description:
 * @author: mike ling
 * @date: 2020/12/3 17:17
 */
@org.apache.ibatis.annotations.Mapper
@Repository
public interface PatentMapper extends Mapper<Patent>, MySqlMapper<Patent> {
}
