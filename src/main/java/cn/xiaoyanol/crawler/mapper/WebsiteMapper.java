package cn.xiaoyanol.crawler.mapper;

import cn.xiaoyanol.crawler.dao.domain.Website;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @description:
 * @author: mike ling
 * @date: 2020/12/4 17:05
 */
@org.apache.ibatis.annotations.Mapper
@Repository
public interface WebsiteMapper extends Mapper<Website>, MySqlMapper<Website> {
}
