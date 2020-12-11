package cn.xiaoyanol.crawler.domain.patentinfo;

import java.util.Date;
import java.util.List;

/**
 *   专利信息
 * @author www.jsons.cn 
 * @website http://www.jsons.cn/json2java/ 
 */
public class Items {

    private String mainCatNum;
    private String createTime;
    private String cat;
    // 公开(公告) 号
    private String pubnumber;
    // 申请号
    private String appnumber;
    private String id;
    // 标题
    private String title;
    // 专利名称
    private String patentName;
    // 申请日
    private Date applicationTime;
    private String businessId;
    // 申请(专利权)人
    private String applicantname;
    // 专利类型
    private String patentType;
    // 公开(公告)日
    private Date pubDate;

    private String applicationPublishNum;
    private String lprs;
    // 代理机构
    private String agency;
    // TODO 法律状态
    private List<cn.xiaoyanol.crawler.domain.patentinfo.Lawstatus> lawStatus;
    // 发明人
    private String inventor;
    // 代理人
    private String agent;
    private Date applicationPublishTime;
    // 申请号
    private String patentNum;
    // 附图
    private String imgUrl;
    // 分类号
    private String allCatNum;
    // 专利描述
    private String abstracts;
    // 地址
    private String address;
    private String eventTime;
    // 雪花id
    private String uuid;
    // 申请(专利权)人
    private String applicantName;

    public String getMainCatNum() {
        return mainCatNum;
    }

    public void setMainCatNum(String mainCatNum) {
        this.mainCatNum = mainCatNum;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public String getPubnumber() {
        return pubnumber;
    }

    public void setPubnumber(String pubnumber) {
        this.pubnumber = pubnumber;
    }

    public String getAppnumber() {
        return appnumber;
    }

    public void setAppnumber(String appnumber) {
        this.appnumber = appnumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPatentName() {
        return patentName;
    }

    public void setPatentName(String patentName) {
        this.patentName = patentName;
    }

    public Date getApplicationTime() {
        return applicationTime;
    }

    public void setApplicationTime(Date applicationTime) {
        this.applicationTime = applicationTime;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public String getApplicantname() {
        return applicantname;
    }

    public void setApplicantname(String applicantname) {
        this.applicantname = applicantname;
    }

    public String getPatentType() {
        return patentType;
    }

    public void setPatentType(String patentType) {
        this.patentType = patentType;
    }

    public Date getPubDate() {
        return pubDate;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }

    public String getApplicationPublishNum() {
        return applicationPublishNum;
    }

    public void setApplicationPublishNum(String applicationPublishNum) {
        this.applicationPublishNum = applicationPublishNum;
    }

    public String getLprs() {
        return lprs;
    }

    public void setLprs(String lprs) {
        this.lprs = lprs;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public List<cn.xiaoyanol.crawler.domain.patentinfo.Lawstatus> getLawStatus() {
        return lawStatus;
    }

    public void setLawStatus(List<cn.xiaoyanol.crawler.domain.patentinfo.Lawstatus> lawStatus) {
        this.lawStatus = lawStatus;
    }

    public String getInventor() {
        return inventor;
    }

    public void setInventor(String inventor) {
        this.inventor = inventor;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public Date getApplicationPublishTime() {
        return applicationPublishTime;
    }

    public void setApplicationPublishTime(Date applicationPublishTime) {
        this.applicationPublishTime = applicationPublishTime;
    }

    public String getPatentNum() {
        return patentNum;
    }

    public void setPatentNum(String patentNum) {
        this.patentNum = patentNum;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getAllCatNum() {
        return allCatNum;
    }

    public void setAllCatNum(String allCatNum) {
        this.allCatNum = allCatNum;
    }

    public String getAbstracts() {
        return abstracts;
    }

    public void setAbstracts(String abstracts) {
        this.abstracts = abstracts;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEventTime() {
        return eventTime;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    @Override
    public String toString() {
        return "Items{" +
                "mainCatNum='" + mainCatNum + '\'' +
                ", createTime='" + createTime + '\'' +
                ", cat='" + cat + '\'' +
                ", pubnumber='" + pubnumber + '\'' +
                ", appnumber='" + appnumber + '\'' +
                ", id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", patentName='" + patentName + '\'' +
                ", applicationTime=" + applicationTime +
                ", businessId='" + businessId + '\'' +
                ", applicantname='" + applicantname + '\'' +
                ", patentType='" + patentType + '\'' +
                ", pubDate=" + pubDate +
                ", applicationPublishNum='" + applicationPublishNum + '\'' +
                ", lprs='" + lprs + '\'' +
                ", agency='" + agency + '\'' +
                ", lawStatus=" + lawStatus +
                ", inventor='" + inventor + '\'' +
                ", agent='" + agent + '\'' +
                ", applicationPublishTime=" + applicationPublishTime +
                ", patentNum='" + patentNum + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", allCatNum='" + allCatNum + '\'' +
                ", abstracts='" + abstracts + '\'' +
                ", address='" + address + '\'' +
                ", eventTime='" + eventTime + '\'' +
                ", uuid='" + uuid + '\'' +
                ", applicantName='" + applicantName + '\'' +
                '}';
    }
}