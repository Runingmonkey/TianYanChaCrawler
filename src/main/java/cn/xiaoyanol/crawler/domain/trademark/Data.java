package cn.xiaoyanol.crawler.domain.trademark;
import java.util.List;
/**
 * Auto-generated: 2020-12-02 17:37:40
 *
 * @author www.jsons.cn 
 * @website http://www.jsons.cn/json2java/ 
 */
public class Data {

    private int total;
    private List<AppYearLmbx> app_year_lmbx;
    private String viewtotal;
    private int num;
    private int realTotal;
    private List<IntClsLmbx> int_cls_lmbx;
    private int historyCount;
    private List<Items> items;
    private List<StatusLmbx> status_lmbx;
    private List<CategoryLmbx> category_lmbx;
    private int pageNum;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<AppYearLmbx> getApp_year_lmbx() {
        return app_year_lmbx;
    }

    public void setApp_year_lmbx(List<AppYearLmbx> app_year_lmbx) {
        this.app_year_lmbx = app_year_lmbx;
    }

    public String getViewtotal() {
        return viewtotal;
    }

    public void setViewtotal(String viewtotal) {
        this.viewtotal = viewtotal;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getRealTotal() {
        return realTotal;
    }

    public void setRealTotal(int realTotal) {
        this.realTotal = realTotal;
    }

    public List<IntClsLmbx> getInt_cls_lmbx() {
        return int_cls_lmbx;
    }

    public void setInt_cls_lmbx(List<IntClsLmbx> int_cls_lmbx) {
        this.int_cls_lmbx = int_cls_lmbx;
    }

    public int getHistoryCount() {
        return historyCount;
    }

    public void setHistoryCount(int historyCount) {
        this.historyCount = historyCount;
    }

    public List<Items> getItems() {
        return items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }

    public List<StatusLmbx> getStatus_lmbx() {
        return status_lmbx;
    }

    public void setStatus_lmbx(List<StatusLmbx> status_lmbx) {
        this.status_lmbx = status_lmbx;
    }

    public List<CategoryLmbx> getCategory_lmbx() {
        return category_lmbx;
    }

    public void setCategory_lmbx(List<CategoryLmbx> category_lmbx) {
        this.category_lmbx = category_lmbx;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    @Override
    public String toString() {
        return "Data{" +
                "total=" + total +
                ", app_year_lmbx=" + app_year_lmbx +
                ", viewtotal='" + viewtotal + '\'' +
                ", num=" + num +
                ", realTotal=" + realTotal +
                ", int_cls_lmbx=" + int_cls_lmbx +
                ", historyCount=" + historyCount +
                ", items=" + items +
                ", status_lmbx=" + status_lmbx +
                ", category_lmbx=" + category_lmbx +
                ", pageNum=" + pageNum +
                '}';
    }
}