package dao.entity;

/**
 * Created by HWAY on 2017-08-11.
 * 这个类用来记录信用分数
 */
public class CrdRecord {
    private int usrId;
    private String record;

    public CrdRecord() {
    }

    public CrdRecord(int usrId, String record) {
        this.usrId = usrId;
        this.record = record;
    }

    public int getUsrId() {
        return usrId;
    }

    public void setUsrId(int usrId) {
        this.usrId = usrId;
    }

    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record;
    }
}
