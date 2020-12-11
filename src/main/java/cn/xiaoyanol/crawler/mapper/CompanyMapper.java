package cn.xiaoyanol.crawler.mapper;

import cn.xiaoyanol.crawler.dao.domain.Company;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

import java.util.List;

/**
 * @description: 公司mapper
 * @author: mike ling
 * @date: 2020/12/3 16:51
 */
@org.apache.ibatis.annotations.Mapper
@Repository
public interface CompanyMapper extends Mapper<Company>, MySqlMapper<Company> {

}
