/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;



/**
 *
 * @author LENOVO
 */
public class MemberTBL {
    private int mid;
    private String mname;
    private boolean gender;
    private Date dob;
    private int gid;
    private String created_by;

    public MemberTBL() {
    }

    public MemberTBL(int mid, String mname, boolean gender, Date dob, int gid, String created_by) {
        this.mid = mid;
        this.mname = mname;
        this.gender = gender;
        this.dob = dob;
        this.gid = gid;
        this.created_by = created_by;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public boolean isGender() {
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
