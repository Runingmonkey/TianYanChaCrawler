package cn.xiaoyanol.crawler.dao.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@Table(name = "trademark_detail")
public class TrademarkDetail {
    @Id
    private Integer id;

    /**
     * 公司id
     */
    private Long cid;

    /**
     * 商标名称
     */
    @Column(name = "tm_name")
    private String tmName;

    /**
     * 天眼查公司id
     */
    @Column(name = "tyc_id")
    private Long tycId;

    /**
     * 注册号
     */
    @Column(name = "reg_no")
    private String regNo;

    /**
     * 申请时间
     */
    @Column(name = "app_date")
    private LocalDate appDate;

    /**
     * 商标类别
     */
    @Column(name = "int_cls")
    private Integer intCls;

    /**
     * 申请人
     */
    @Column(name = "applicant_cn")
    private String applicantCn;

    /**
     * 申请人列表
     */
    @Column(name = "applicant_cn_list")
    private String applicantCnList;

    /**
     * 申请地址
     */
    @Column(name = "address_cn")
    private String addressCn;

    /**
     * 其他申请人1
     */
    @Column(name = "applicant_other1")
    private String applicantOther1;

    /**
     * 其他申请人2
     */
    @Column(name = "applicant_other2")
    private String applicantOther2;

    /**
     * 申请人名称 (英)
     */
    @Column(name = "applicant_en")
    private String applicantEn;

    /**
     * 申请人地址 (英)
     */
    @Column(name = "address_en")
    private String addressEn;

    /**
     * 初审公告期号
     */
    @Column(name = "announcement_issue")
    private Integer announcementIssue;

    /**
     * 初审公告日期(毫秒)
     */
    @Column(name = "announcement_date")
    private LocalDate announcementDate;

    /**
     * 注册公告期号
     */
    @Column(name = "reg_issue")
    private Integer regIssue;

    /**
     * 注册公告日期
     */
    @Column(name = "reg_date")
    private LocalDate regDate;

    /**
     * 专用权开始时间
     */
    @Column(name = "private_date_start")
    private String privateDateStart;

    /**
     * 专用权结束时间
     */
    @Column(name = "private_date_end")
    private String privateDateEnd;

    /**
     * 代理机构
     */
    private String agent;

    /**
     * 代理机构列表
     */
    @Column(name = "agent_list")
    private String agentList;

    /**
     * 商标地址
     */
    @Column(name = "tm_pic")
    private String tmPic;

    /**
     * 国际分类
     */
    @Column(name = "cls_str")
    private String clsStr;

    /**
     * 状态
     */
    @Column(name = "status_str")
    private String statusStr;

    /**
     * 类别
     */
    @Column(name = "category_str")
    private String categoryStr;

    /**
     * 类别描述1
     */
    @Column(name = "cls_desc1")
    private String clsDesc1;

    /**
     * 类别描述2
     */
    @Column(name = "cls_desc2")
    private String clsDesc2;

    /**
     * 商品/服务
     */
    @Column(name = "good_server")
    private String goodServer;

    /**
     * 申请流程
     */
    private String flow;
}