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
public class Certificate {

    private int certId;
    private String certname;

    public Certificate() {
    }

    public Certificate(int certId, String certname) {
        this.certId = certId;
        this.certname = certname;
    }

    public int getCertId() {
        return certId;
    }

    public void setCertId(int certId) {
        this.certId = certId;
    }

    public String getCertname() {
        return certname;
    }

    public void setCertname(String certname) {
        this.certname = certname;
    }

}
