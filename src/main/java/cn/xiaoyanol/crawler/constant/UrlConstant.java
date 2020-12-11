package cn.xiaoyanol.crawler.constant;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @Author: chenyanfeng
 * @Date: 2018-11-23
 * @Time: 下午4:49
 */
public class UrlConstant {


    /**
     * 公司搜索URL
     */
    public static final String SEARCH_RUL = "https://api9.tianyancha.com/services/v3/search/sNorV4/";


    /**
     * 企业基本信息
     */
    public static final String BASE_INFO_URL = "https://api9.tianyancha.com/services/v3/t/common/baseinfoV5/";

    /**
     * 专利信息
     *  GET
     *  /services/v3/expanse/patent?id=1208288762&pageSize=10&pageNum=1
     */
    public static final String PATENT_INFO_URL = "https://api9.tianyancha.com/services/v3/expanse/patent/";

    /**
     * 著作权
     *  GET
     *  /cloud-intellectual-property/intellectualProperty/softwareCopyrightList?id=1208288762&pageSize=10&pageNum=1 HTTP/1.1
     */
    public static final String COPYRIGHT_INFO_URL = "https://capi.tianyancha.com/cloud-intellectual-property/intellectualProperty/softwareCopyrightList?id=";

    /**
     *  商标信息
     *  POST
     *  RAW :{"id":"23402373","ps":20,"pn":3,"int_cls":-100,"status":-100,"category":-100,"app_year":-100}
     */
    public static final String TRADEMARK_LIST_URL = "https://api9.tianyancha.com/services/v3/trademark/tms.json";

    /**
     * 网站备案信息
     *  GET  /services/v3/ar/icp/24416401.json
     */
    public static final String WEBSITE_LIST = "https://api9.tianyancha.com/services/v3/ar/icp/";

}
