package cn.xiaoyanol.crawler.domain.patentinfo;

import java.util.Date;

/**
 * Auto-generated: 2020-12-02 14:44:10
 *
 * @author www.jsons.cn 
 * @website http://www.jsons.cn/json2java/ 
 */
public class Lawstatus {

    private String status;
    private Date date;
    public void setStatus(String status) {
         this.status = status;
     }
     public String getStatus() {
         return status;
     }

    public void setDate(Date date) {
         this.date = date;
     }
     public Date getDate() {
         return date;
     }

    @Override
    public String toString() {
        return "Lawstatus{" +
                "status='" + status + '\'' +
                ", date=" + date +
                '}';
    }
}