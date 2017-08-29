package dao.entity;

import java.sql.Date;

/**
 * Created by HWAY on 2017-08-11.
 * 临时订单类
 */
public class TmpOrder {
    private int id;
    private int usrId;
    private int proId;
    private int progress;
    private Date genDate;
    private String dataUrl;
    private boolean isPayed;

    public TmpOrder(int id, int usrId, int proId, int progress, Date genDate, String dataUrl, boolean isPayed) {
        this.id = id;
        this.usrId = usrId;
        this.proId = proId;
        this.progress = progress;
        this.genDate = genDate;
        this.dataUrl = dataUrl;
        this.isPayed = isPayed;
    }

    public TmpOrder() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsrId() {
        return usrId;
    }

    public void setUsrId(int usrId) {
        this.usrId = usrId;
    }

    public int getProId() {
        return proId;
    }

    public void setProId(int proId) {
        this.proId = proId;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public Date getGenDate() {
        return genDate;
    }

    public void setGenDate(Date genDate) {
        this.genDate = genDate;
    }

    public String getDataUrl() {
        return dataUrl;
    }

    public void setDataUrl(String dataUrl) {
        this.dataUrl = dataUrl;
    }

    public boolean isPayed() {
        return isPayed;
    }

    public void setPayed(boolean payed) {
        isPayed = payed;
    }
}
