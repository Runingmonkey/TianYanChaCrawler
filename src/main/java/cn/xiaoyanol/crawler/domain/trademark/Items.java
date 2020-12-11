package cn.xiaoyanol.crawler.domain.trademark;
/**
 *  商标信息
 * @author www.jsons.cn
 * @website http://www.jsons.cn/json2java/ 
 */
public class Items {

    // 状态
    private String status;
    // 商标类型
    private String intClsV2;
    // 类型编号
    private String tmClass;
    // 商标名称
    private String tmName;
    private String id;
    private String intCls;
    // 申请时间
    private String tmFlow;
    // 商标图片地址
    private String tmPic;
    private String category;
    // 申请时间戳
    private String eventTime;
    // 注册号
    private String regNo;
    private String appDate;
    // 商标申请者
    private String applicantCn;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIntClsV2() {
        return intClsV2;
    }

    public void setIntClsV2(String intClsV2) {
        this.intClsV2 = intClsV2;
    }

    public String getTmClass() {
        return tmClass;
    }

    public void setTmClass(String tmClass) {
        this.tmClass = tmClass;
    }

    public String getTmName() {
        return tmName;
    }

    public void setTmName(String tmName) {
        this.tmName = tmName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIntCls() {
        return intCls;
    }

    public void setIntCls(String intCls) {
        this.intCls = intCls;
    }

    public String getTmFlow() {
        return tmFlow;
    }

    public void setTmFlow(String tmFlow) {
        this.tmFlow = tmFlow;
    }

    public String getTmPic() {
        return tmPic;
    }

    public void setTmPic(String tmPic) {
        this.tmPic = tmPic;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getEventTime() {
        return eventTime;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getAppDate() {
        return appDate;
    }

    public void setAppDate(String appDate) {
        this.appDate = appDate;
    }

    public String getApplicantCn() {
        return applicantCn;
    }

    public void setApplicantCn(String applicantCn) {
        this.applicantCn = applicantCn;
    }

    @Override
    public String toString() {
        return "Items{" +
                "status='" + status + '\'' +
                ", intClsV2='" + intClsV2 + '\'' +
                ", tmClass='" + tmClass + '\'' +
                ", tmName='" + tmName + '\'' +
                ", id='" + id + '\'' +
                ", intCls='" + intCls + '\'' +
                ", tmFlow='" + tmFlow + '\'' +
                ", tmPic='" + tmPic + '\'' +
                ", category='" + category + '\'' +
                ", eventTime='" + eventTime + '\'' +
                ", regNo='" + regNo + '\'' +
                ", appDate='" + appDate + '\'' +
                ", applicantCn='" + applicantCn + '\'' +
                '}';
    }
}