package cn.xiaoyanol.crawler.dao.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * @description:
 * @author: mike ling
 * @date: 2020/12/3 16:52
 */
@Data
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tycId")
    private String tycId;

    private String name;

    /**
     *  组织机构代码
     */
    private String orgNumber;

    /**
     *  统一社会信用代码
     */
    private String creditCode;

    /**
     * 企业状态
     */
    private String regStatus;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 企业联系方式
     */
    private String phoneNumber;

    /**
     *  经营开始时间
     */
    private String fromTime;

    /**
     *  法人类型，1 人 2 公司
     */
    private String type;

    /**
     * 股票名
     */
    private String bondName;

    /**
     * 注册号
     */
    private String regNumber;

    /**
     *  注册资本
     */
    private String regCapital;

    /**
     * 登记机关
     */
    private String regInstitute;

    /**
     * 注册地址
     */
    private String regLocation;

    /**
     * 行业
     */
    private String industry;

    /**
     * 核准时间
     */
    private String approvedTime;

    /**
     * 经营范围
     */
    private String businessScope;

    /**
     * 简称
     */
    private String alias;

    /**
     * 法人名称
     */
    private String legalPersonName;

    /**
     * 是否为重点企业
     */
    private Integer isImportant;

    /**
     *  企业类型
     */
    private String companyOrgType;

}
