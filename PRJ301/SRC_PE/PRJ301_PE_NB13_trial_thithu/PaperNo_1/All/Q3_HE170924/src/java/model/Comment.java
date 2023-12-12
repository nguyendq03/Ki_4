/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author admin
 */
public class Comment {
    private int cid;
    private String ctitle, userid;
    private int tid;
    private String displayName;

    public Comment() {
    }

    public Comment(int cid, String ctitle, String userid, int tid) {
        this.cid = cid;
        this.ctitle = ctitle;
        this.userid = userid;
        this.tid = tid;
    }

    public Comment(int cid, String ctitle, String userid, int tid, String displayName) {
        this.cid = cid;
        this.ctitle = ctitle;
        this.userid = userid;
        this.tid = tid;
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayname(String displayName) {
        this.displayName = displayName;
    }


    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCtitle() {
        return ctitle;
    }

    public void setCtitle(String ctitle) {
        this.ctitle = ctitle;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

   
     
}
