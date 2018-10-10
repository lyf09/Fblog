package com.f.pojo;

import java.util.Arrays;

public class Blog {
    private int id;
    private String name;
    private String contactus;
    private byte[] bimg;
    public Blog() {
        super();
    }
    public Blog(int id, String name, String contactus, byte[] bimg) {
        super();
        this.id = id;
        this.name = name;
        this.contactus = contactus;
        this.bimg = bimg;
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
	public String getContactus() {
        return contactus;
    }
    public void setContactus(String contactus) {
        this.contactus = contactus;
    }
    public byte[] getBimg() {
        return bimg;
    }
    public void setBimg(byte[] bimg) {
        this.bimg = bimg;
    }
	@Override
	public String toString() {
		return "Blog [id=" + id + ", name=" + name + ", contactus=" + contactus + ", bimg=" + Arrays.toString(bimg)
				+ "]";
	}
  
    
}
