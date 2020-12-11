package cn.xiaoyanol.crawler.domain.patentinfo;


import java.util.List;
/**
 * Auto-generated: 2020-12-02 14:44:10
 *
 * @author www.jsons.cn 
 * @website http://www.jsons.cn/json2java/ 
 */
public class Data {

    private String viewtotal;
    private String realTotal;
    private List<Items> items;
    private String pageSize;

    public String getViewtotal() {
        return viewtotal;
    }

    public void setViewtotal(String viewtotal) {
        this.viewtotal = viewtotal;
    }

    public String getRealTotal() {
        return realTotal;
    }

    public void setRealTotal(String realTotal) {
        this.realTotal = realTotal;
    }

    public List<Items> getItems() {
        return items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "Data{" +
                "viewtotal='" + viewtotal + '\'' +
                ", realTotal='" + realTotal + '\'' +
                ", items=" + items +
                ", pageSize='" + pageSize + '\'' +
                '}';
    }
}