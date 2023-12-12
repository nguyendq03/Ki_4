/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;
/**
 *
 * @author ASUS PC
 */
public class CandidateTBL {
    private int cid;
    private String cname;
    private boolean gender;
    private Date dob;
    private int gid;
    private String created_by;

    public CandidateTBL() {
    }

    public CandidateTBL(int cid, String cname, boolean gender, Date dob, int gid, String created_by) {
        this.cid = cid;
        this.cname = cname;
        this.gender = gender;
        this.dob = dob;
        this.gid = gid;
        this.created_by = created_by;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public boolean getGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }
    
    
}
