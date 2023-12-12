/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ezse.net
 */
public class Author {
    private int auid;
    private String auname;
    private boolean isCorresponding;

    public Author() {
    }

    public Author(int auid, String auname, boolean isCorresponding) {
        this.auid = auid;
        this.auname = auname;
        this.isCorresponding = isCorresponding;
    }

    public int getAuid() {
        return auid;
    }

    public void setAuid(int auid) {
        this.auid = auid;
    }

    public String getAuname() {
        return auname;
    }

    public void setAuname(String auname) {
        this.auname = auname;
    }

    public boolean isIsCorresponding() {
        return isCorresponding;
    }

    public void setIsCorresponding(boolean isCorresponding) {
        this.isCorresponding = isCorresponding;
    }
    
    
}
