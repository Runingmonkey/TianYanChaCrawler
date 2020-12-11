package cn.xiaoyanol.crawler.domain.trademark;
/**
 * Auto-generated: 2020-12-02 17:37:40
 *
 * @author www.jsons.cn 
 * @website http://www.jsons.cn/json2java/ 
 */
public class JsonsRootBean {

    private String state;
    private String message;
    private String special;
    private String vipMessage;
    private int isLogin;
    private Data data;

    @Override
    public String toString() {
        return "JsonsRootBean{" +
                "state='" + state + '\'' +
                ", message='" + message + '\'' +
                ", special='" + special + '\'' +
                ", vipMessage='" + vipMessage + '\'' +
                ", isLogin=" + isLogin +
                ", data=" + data +
                '}';
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSpecial() {
        return special;
    }

    public void setSpecial(String special) {
        this.special = special;
    }

    public String getVipMessage() {
        return vipMessage;
    }

    public void setVipMessage(String vipMessage) {
        this.vipMessage = vipMessage;
    }

    public int getIsLogin() {
        return isLogin;
    }

    public void setIsLogin(int isLogin) {
        this.isLogin = isLogin;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}