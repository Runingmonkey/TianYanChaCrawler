package cn.xiaoyanol.crawler.dao.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * @description:
 * @author: mike ling
 * @date: 2020/12/3 17:09
 */
@Data
public class Trademark {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long cid;

    @Transient
    private String company;

    private String status;

    /**
     * 商标类型
     */
    @Column(name = "int_cls_v2")
    private String intClsV2;

    /**
     * 类型编号
     */
    @Column(name = "tm_class")
    private String tmClass;

    /**
     * 商标名称
     */
    @Column(name = "tm_name")
    private String tmName;

    /**
     * 申请时间
     */
    @Column(name = "tm_flow")
    private String tmFlow;

    /**
     * 商标图片地址
     */
    @Column(name = "tm_pic")
    private String tmPic;

    /**
     * 申请时间戳
     */
    @Column(name = "event_time")
    private String eventTime;

    /**
     * 申请时间
     */
    @Column(name = "event_date")
    private LocalDate eventDate;

    /**
     * 注册号
     */
    @Column(name = "reg_no")
    private String regNo;

    /**
     * 商标申请者
     */
    @Column(name = "applicant_cn")
    private String applicantCn;
}
