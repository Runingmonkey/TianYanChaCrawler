package cn.xiaoyanol.crawler.mapper;

import cn.xiaoyanol.crawler.dao.domain.Patent2;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

@org.apache.ibatis.annotations.Mapper
@Repository
public interface Patent2Mapper extends Mapper<Patent2>, MySqlMapper<Patent2> {
}