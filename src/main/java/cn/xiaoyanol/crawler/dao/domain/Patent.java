package cn.xiaoyanol.crawler.dao.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @description:
 * @author: mike ling
 * @date: 2020/12/3 17:03
 */
@Data
public class Patent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Long cid;
    @Column(name = "patent_name")
    private String patent_name;
    @Column(name = "app_Number")
    private String app_Number;
    private String title;
    @Column(name = "applicant_name")
    private String applicant_name;
    @Column(name = "patentType")
    private String patentType;
    @Column(name = "application_time")
    private Date application_time;
    @Column(name = "pub_date")
    private Date pub_date;
    private String agency;
    private String inventor;
    private String agent;
    @Column(name = "patent_num")
    private String patent_num;
    @Column(name = "imgurl")
    private String imgurl;
    @Column(name = "all_cat_num")
    private String all_cat_num;
    private String abstracts;
    private String address;


}
