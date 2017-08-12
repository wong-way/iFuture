package dao.entity;

import java.sql.Date;

/**
 * Created by HWAY on 2017-08-11.
 * 这个类用于申请赔付
 */
public class AppClaims {
    private int id;
    int ordId;
    private Date genDate;
    private int progress;
    private String dataUrl;
    private int usrId;
    public AppClaims() {
    }

    public AppClaims(int id, int ordId, Date genDate, int progress, String dataUrl, int usrId) {
        this.id = id;
        this.ordId = ordId;
        this.genDate = genDate;
        this.progress = progress;
        this.dataUrl = dataUrl;
        this.usrId = usrId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getGenDate() {
        return genDate;
    }

    public void setGenDate(Date genDate) {
        this.genDate = genDate;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public String getDataUrl() {
        return dataUrl;
    }

    public void setDataUrl(String dataUrl) {
        this.dataUrl = dataUrl;
    }

    public int getOrdId() {
        return ordId;
    }

    public void setOrdId(int ordId) {
        this.ordId = ordId;
    }

    public int getUsrId() {
        return usrId;
    }

    public void setUsrId(int usrId) {
        this.usrId = usrId;
    }
}
