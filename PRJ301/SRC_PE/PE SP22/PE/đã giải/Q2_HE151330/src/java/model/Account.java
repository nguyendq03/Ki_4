/*
 * Copyright(C) 2022, Nguyen The Minh.
 * Code: J1.S.P0071 (150 LOC)
 * Title: Task management program of CCRM project.
 */
package model;

/**
 *
 * @author vietd
 */
public class Account {

    private String username;
    private String displayname;

    public Account() {
    }

    public Account(String username, String displayname) {
        this.username = username;
        this.displayname = displayname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDisplayname() {
        return displayname;
    }

    public void setDisplayname(String displayname) {
        this.displayname = displayname;
    }

}
