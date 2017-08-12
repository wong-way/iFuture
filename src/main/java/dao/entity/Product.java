package dao.entity;

/**
 * Created by HWAY on 2017-08-11.
 * 产品类
 */
public class Product {
    private int id;
    private String name;
    private int payMthd;
    private int payAmnt;
    private int offAmnt;
    private int type;
    private int risk;
    private String caption;

    public Product() {
    }

    public Product(int id, String name, int payMthd, int payAmnt, int offAmnt, int type, int risk, String caption) {
        this.id = id;
        this.name = name;
        this.payMthd = payMthd;
        this.payAmnt = payAmnt;
        this.offAmnt = offAmnt;
        this.type = type;
        this.risk = risk;
        this.caption = caption;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPayMthd() {
        return payMthd;
    }

    public void setPayMthd(int payMthd) {
        this.payMthd = payMthd;
    }

    public int getPayAmnt() {
        return payAmnt;
    }

    public void setPayAmnt(int payAmnt) {
        this.payAmnt = payAmnt;
    }

    public int getOffAmnt() {
        return offAmnt;
    }

    public void setOffAmnt(int offAmnt) {
        this.offAmnt = offAmnt;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getRisk() {
        return risk;
    }

    public void setRisk(int risk) {
        this.risk = risk;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }
}
