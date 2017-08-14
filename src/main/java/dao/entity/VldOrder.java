package dao.entity;

import java.sql.Date;

/**
 * Created by HWAY on 2017-08-11.
 * 有效订单类
 */
public class VldOrder {
    private int ordId;
    private int toPay;
    private int hasPay;
    private int usrId;
    private Date genDate;

    public VldOrder(int ordId, int toPay, int hasPay, int usrId, Date genDate) {
        this.ordId = ordId;
        this.toPay = toPay;
        this.hasPay = hasPay;
        this.usrId = usrId;
        this.genDate = genDate;
    }

    public VldOrder() {
    }

    public int getOrdId() {
        return ordId;
    }

    public void setOrdId(int ordId) {
        this.ordId = ordId;
    }

    public int getToPay() {
        return toPay;
    }

    public void setToPay(int toPay) {
        this.toPay = toPay;
    }

    public int getHasPay() {
        return hasPay;
    }

    public void setHasPay(int hasPay) {
        this.hasPay = hasPay;
    }

    public int getUsrId() {
        return usrId;
    }

    public void setUsrId(int usrId) {
        this.usrId = usrId;
    }

    public Date getGenDate() {
        return genDate;
    }

    public void setGenDate(Date genDate) {
        this.genDate = genDate;
    }
}
