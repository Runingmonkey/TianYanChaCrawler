package cn.xiaoyanol.crawler.domain.trademarkdetail;
import lombok.Data;

import java.util.List;
/**
 * Auto-generated: 2020-12-14 16:25:55
 *
 * @author www.jsons.cn 
 * @website http://www.jsons.cn/json2java/ 
 */
@Data
public class Detail {

    private Integer id;
    // 注册号
    private String regNo;
    // 类别
    private Integer intCls;
    // 商标名称
    private String tmName;
    // 申请时间(毫秒)
    private Long appDate;
    // 申请人
    private String applicantCn;
    // 申请人列表
    private List<Applicantcnlist> applicantCnList;
    // 申请地址
    private String addressCn;
    // 其他申请人1
    private String applicantOther1;
    // 其他申请人2
    private String applicantOther2;
    // 申请人名称 (英)
    private String applicantEn;
    // 申请人地址 (英)
    private String addressEn;
    // 初审公告期号
    private Integer announcemenIssue;
    // 初审公告日期(毫秒)
    private Long announcementDate;
    // 注册公告期号
    private Integer regIssue;
    // 注册公告日期
    private Long regDate;
    // 专用权开始时间
    private Long privateDateStart;
    // 专用权结束时间
    private Long privateDateEnd;
    // 代理机构
    private String agent;
    // 代理机构列表
    private List<Agentlist> agentList;
    private Integer category;
    private String hqzdrq;
    private String gjzcrq;
    private String yxqrq;
    private String color;
    private Integer status;
    private Integer statusNew;
    private String source;
    private Long updateTime;
    private Integer deleted;
    // 商标地址
    private String tmPic;
    // 国际分类
    private String clsStr;
    // 状态
    private String statusStr;
    // 类别
    private String categoryStr;
    // 是否共有商标
    private boolean isShared;
    // 类别描述1
    private String clsDesc1;
    // 类别描述2
    private List<String> clsDesc2;

}