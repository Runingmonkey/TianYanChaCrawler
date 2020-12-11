package cn.xiaoyanol.crawler.dao.domain;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: mike ling
 * @date: 2020/12/4 16:07
 */
@Data
public class Website {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // 公司id
    private Long cid;

    // 网站列表
    @Column(name = "webSite")
    private String webSite;
    // 审核时间
    @Column(name = "examineDate")
    private Date examineDate;
    // 主办单位性质
    @Column(name = "companyType")
    private String companyType;
    // 网站名称
    @Column(name = "webName")
    private String webName;
    // 域名
    private String ym;
    // 公司名称
    @Column(name = "companyName")
    private String companyName;
    // 备案号
    private String liscense;


}
