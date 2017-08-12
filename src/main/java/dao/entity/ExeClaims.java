package dao.entity;

import java.sql.Date;

/**
 * Created by HWAY on 2017-08-11.
 * 这个类用于执行赔付
 */
public class ExeClaims {
    private int clmId;
    private Date genDate;
    private int progress;
    private int toOff;
    private int hasOff;
    private int usrId;
    public ExeClaims() {
    }

    public ExeClaims(int clmId, Date genDate, int progress, int toOff, int hasOff, int usrId) {
        this.clmId = clmId;
        this.genDate = genDate;
        this.progress = progress;
        this.toOff = toOff;
        this.hasOff = hasOff;
        this.usrId = usrId;
    }

    public int getClmId() {
        return clmId;
    }

    public void setClmId(int clmId) {
        this.clmId = clmId;
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

    public int getToOff() {
        return toOff;
    }

    public void setToOff(int toOff) {
        this.toOff = toOff;
    }

    public int getHasOff() {
        return hasOff;
    }

    public void setHasOff(int hasOff) {
        this.hasOff = hasOff;
    }

    public int getUsrId() {
        return usrId;
    }

    public void setUsrId(int usrId) {
        this.usrId = usrId;
    }
}
