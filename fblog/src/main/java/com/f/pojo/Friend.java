package com.f.pojo;

public class Friend {
    private int id;
    private String fname;
    private String fimg;
    public Friend() {
        super();
    }
    public Friend(int id, String fname, String fimg) {
        super();
        this.id = id;
        this.fname = fname;
        this.fimg = fimg;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getFname() {
        return fname;
    }
    public void setFname(String fname) {
        this.fname = fname;
    }
    public String getFimg() {
        return fimg;
    }
    public void setFimg(String fimg) {
        this.fimg = fimg;
    }
    @Override
    public String toString() {
        return "Friend [id=" + id + ", fname=" + fname + ", fimg=" + fimg + "]";
    }
   
    
}
