/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author admin
 */
public class Student {
    private String StudentID, StudentName, Birthday;
    private int Gender;
    private int ClassID;

    public Student() {
    }

    public Student(String StudentID, String StudentName, String Birthday, int Gender, int ClassID) {
        this.StudentID = StudentID;
        this.StudentName = StudentName;
        this.Birthday = Birthday;
        this.Gender = Gender;
        this.ClassID = ClassID;
    }

    public String getStudentID() {
        return StudentID;
    }

    public void setStudentID(String StudentID) {
        this.StudentID = StudentID;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String StudentName) {
        this.StudentName = StudentName;
    }

    public String getBirthday() {
        return Birthday;
    }

    public void setBirthday(String Birthday) {
        this.Birthday = Birthday;
    }

    public String getGender() {
        return Gender == 1 ? "Male" : "Female";
    }
    
    public int getGenderInt() {
        return Gender;
    }

    public void setGender(int Gender) {
        this.Gender = Gender;
    }

    public int getClassID() {
        return ClassID;
    }

    public void setClassID(int ClassID) {
        this.ClassID = ClassID;
    }
    
    
}
