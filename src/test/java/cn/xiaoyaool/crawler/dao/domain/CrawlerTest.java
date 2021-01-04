package cn.xiaoyaool.crawler.dao.domain;

import cn.xiaoyanol.crawler.Application;
import cn.xiaoyanol.crawler.dao.domain.Company;
import cn.xiaoyanol.crawler.dao.domain.Trademark;
import cn.xiaoyanol.crawler.mapper.CompanyMapper;
import cn.xiaoyanol.crawler.mapper.PatentMapper;
import cn.xiaoyanol.crawler.mapper.TrademarkMapper;
import cn.xiaoyanol.crawler.service.ITradeMarkService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: mike ling
 * @date: 2020/12/4 13:39
 */

public class CrawlerTest extends Application {

    @Autowired
    private PatentMapper patentMapper;
    @Autowired
    private CompanyMapper companyMapper;
    @Autowired
    private TrademarkMapper trademarkMapper;
    @Autowired
    private ITradeMarkService tradeMarkService;


    @Test
    public void test01() {
        Trademark trademark = new Trademark();
        trademark.setStatus("23");
        trademark.setIntClsV2("23");
        trademark.setTmClass("23");
        trademark.setTmName("34");
        trademark.setTmFlow("24");
        trademark.setTmPic("24");
        trademark.setEventTime("24");
        trademark.setRegNo("24");
        trademark.setApplicantCn("24");
        trademark.setApplicantCn("3434");
        trademarkMapper.insert(trademark);
    }


    @Test
    public void test03() {
        Example example = new Example(Company.class);
    }


    @Test
    public void test04() {
        tradeMarkService.getTradeMarkList(1143230669L);
    }


    @Test
    public void test05() {
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            integers.add(i);
        }

        List<Integer> list = integers.subList(1, integers.size());
        System.out.println(integers);
        System.out.println(list);
    }
}
