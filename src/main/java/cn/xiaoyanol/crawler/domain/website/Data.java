package cn.xiaoyanol.crawler.domain.website;
import java.util.List;
import java.util.Date;
/**
 * Auto-generated: 2020-12-04 15:33:32
 *
 * @author www.jsons.cn 
 * @website http://www.jsons.cn/json2java/ 
 */
@lombok.Data
public class Data {

    // 网站列表
    private List<String> webSite;

    // 审核时间
    private Date examineDate;
    // 主办单位性质
    private String companyType;
    // 网站名称
    private String webName;
    // 域名
    private String ym;
    // 公司名称
    private String companyName;
    // 备案号
    private String liscense;

}