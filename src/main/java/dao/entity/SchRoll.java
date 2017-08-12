package dao.entity;

/**
 * Created by HWAY on 2017-08-11.
 * 学籍表，即用户的详细信息
 */
public class SchRoll {
    private int usrId;
    private String school;
    private String college;
    private String major;
    private String aim;
    private String mail;
    private String stuNo;
    private String idNo;

    public SchRoll() {
    }

    public SchRoll(int usrId, String school, String college, String major, String aim, String mail, String stuNo, String idNo) {
        this.usrId = usrId;
        this.school = school;
        this.college = college;
        this.major = major;
        this.aim = aim;
        this.mail = mail;
        this.stuNo = stuNo;
        this.idNo = idNo;
    }

    public int getUsrId() {
        return usrId;
    }

    public void setUsrId(int usrId) {
        this.usrId = usrId;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getAim() {
        return aim;
    }

    public void setAim(String aim) {
        this.aim = aim;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getStuNo() {
        return stuNo;
    }

    public void setStuNo(String stuNo) {
        this.stuNo = stuNo;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }
}
