package com.example.cgpacalculator;

public class SubjectDetails  {
    private String course_code;
    private int attendence;
    private int credit;
    private double CA;
    private double MTE;
    private double ETE;
    private double Total;
    private String Grade;
    private int GPA;

    public SubjectDetails() {
    }

    public SubjectDetails(String course_code, int attendence, int credit, double CA, double MTE, double ETE, double total, String grade, int GPA) {
        this.course_code = course_code;
        this.attendence = attendence;
        this.credit = credit;
        this.CA = CA;
        this.MTE = MTE;
        this.ETE = ETE;
        Total = total;
        Grade = grade;
        this.GPA = GPA;
    }

    public String getCourse_code() {
        return course_code;
    }

    public void setCourse_code(String course_code) {
        this.course_code = course_code;
    }

    public int getAttendence() {
        return attendence;
    }

    public void setAttendence(int attendence) {
        this.attendence = attendence;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public double getCA() {
        return CA;
    }

    public void setCA(double CA) {
        this.CA = CA;
    }

    public double getMTE() {
        return MTE;
    }

    public void setMTE(double MTE) {
        this.MTE = MTE;
    }

    public double getETE() {
        return ETE;
    }

    public void setETE(double ETE) {
        this.ETE = ETE;
    }

    public double getTotal() {
        return Total;
    }

    public void setTotal(double total) {
        Total = total;
    }

    public String getGrade() {
        return Grade;
    }

    public void setGrade(String grade) {
        Grade = grade;
    }

    public int getGPA() {
        return GPA;
    }

    public void setGPA(int GPA) {
        this.GPA = GPA;
    }




  }
