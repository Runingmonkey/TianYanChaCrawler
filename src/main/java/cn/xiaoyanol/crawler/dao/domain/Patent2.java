package cn.xiaoyanol.crawler.dao.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Id;
import java.time.LocalDate;

@Getter
@Setter
@ToString
public class Patent2 {
    @Id
    private Integer id;

    /**
     * 公司id
     */
    private Long cid;

    /**
     * 专利名称
     */
    @Column(name = "patent_name")
    private String patentName;

    /**
     * 申请号
     */
    @Column(name = "app_number")
    private String appNumber;

    /**
     * 标题
     */
    private String title;

    /**
     * 申请(专利权)人
     */
    @Column(name = "applicant_name")
    private String applicantName;

    /**
     * 专利类型
     */
    @Column(name = "patentType")
    private String patenttype;

    /**
     * 分类号
     */
    @Column(name = "all_cat_num")
    private String allCatNum;

    /**
     * 专利申请号
     */
    @Column(name = "patent_num")
    private String patentNum;

    /**
     * 专利申请日
     */
    @Column(name = "application_time")
    private LocalDate applicationTime;

    /**
     * 公开(公告)日
     */
    @Column(name = "pub_date")
    private LocalDate pubDate;

    /**
     * 公开(公告)号
     */
    @Column(name = "pub_num")
    private String pubNum;

    /**
     * 发明人
     */
    private String inventor;

    /**
     * 代理人
     */
    private String agent;

    /**
     * 代理机构
     */
    private String agency;

    /**
     * 法律状态
     */
    @Column(name = "law_status")
    private String lawStatus;

    /**
     * 法律状态-时间流程
     */
    @Column(name = "law_status_flow")
    private String lawStatusFlow;

    /**
     * 地址
     */
    private String address;

    /**
     * 附图地址
     */
    private String imgurl;

    /**
     * 专利描述
     */
    private String abstracts;
}