/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.Date;

/**
 *
 * @author trinh
 */
public class Employee {
    private int id;
    private String name;
    private int gender;
    private Date dob;

    public Employee() {
    }

    public Employee(int id, String name, int gender, Date dob) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.dob = dob;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGender() {
        return gender;
    }
    public String getGender1(){
        if(gender == 1){
            return "Male";
        }else{
            return "Female";
        }
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", name=" + name + ", gender=" + gender + ", dob=" + dob + '}';
    }
    
}
