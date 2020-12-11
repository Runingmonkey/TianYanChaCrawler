package cn.xiaoyanol.crawler.dao.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @description:
 * @author: mike ling
 * @date: 2020/12/3 17:09
 */
public class Trademark {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Long cid;
    private String status;
    @Column(name = "intClsV2")
    private String intClsV2;
    @Column(name = "tmClass")
    private String tmClass;
    @Column(name = "tmName")
    private String tmName;
    @Column(name = "tmFlow")
    private String tmFlow;
    @Column(name = "tmPic")
    private String tmPic;
    @Column(name = "eventTime")
    private String eventTime;
    @Column(name = "regNo")
    private String regNo;
    @Column(name = "applicantCn")
    private String applicantCn;

    @Override
    public String toString() {
        return "Trademark{" +
                "id='" + id + '\'' +
                ", cid='" + cid + '\'' +
                ", status='" + status + '\'' +
                ", intClsV2='" + intClsV2 + '\'' +
                ", tmClass='" + tmClass + '\'' +
                ", tmName='" + tmName + '\'' +
                ", tmFlow='" + tmFlow + '\'' +
                ", tmPic='" + tmPic + '\'' +
                ", eventTime='" + eventTime + '\'' +
                ", regNo='" + regNo + '\'' +
                ", applicantCn='" + applicantCn + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

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

    public String getApplicantCn() {
        return applicantCn;
    }

    public void setApplicantCn(String applicantCn) {
        this.applicantCn = applicantCn;
    }
}
