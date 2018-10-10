package com.f.pojo;

import java.util.Arrays;
import java.util.List;


public class User {
    private int id;
    private String username;
    private String password;
    private String tel;
    private String sex;
    private String city;
    private String name;
    private String brithday;
    private String imgurl;
    private byte[] uimg;
    private int[] num; 
    
    private List<Friend> friends;
    private List<Blog> blogs;
    private List<Object[]> names;
    public User() {
        super();
    }

    public User(int id, String username, String password, String tel, String sex, String city, String name,
			String brithday, String imgurl, byte[] uimg, int[] num, List<Friend> friends, List<Blog> blogs,List<Object[]> names) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.tel = tel;
		this.sex = sex;
		this.city = city;
		this.name = name;
		this.brithday = brithday;
		this.imgurl = imgurl;
		this.uimg = uimg;
		this.num = num;
		this.friends = friends;
		this.blogs = blogs;
		this.names = names;
	}

	public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getTel() {
        return tel;
    }
    public void setTel(String tel) {
        this.tel = tel;
    }
    public List<Friend> getFriends() {
        return friends;
    }
    public void setFriends(List<Friend> friends) {
        this.friends = friends;
    }
    public List<Blog> getBlogs() {
        return blogs;
    }
    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrithday() {
		return brithday;
	}

	public void setBrithday(String brithday) {
		this.brithday = brithday;
	}

	public List<Object[]> getNames() {
		return names;
	}

	public void setNames(List<Object[]> names) {
		this.names = names;
	}

	public int[] getNum() {
		return num;
	}

	public void setNum(int[] num) {
		this.num = num;
	}

	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}

	public byte[] getUimg() {
		return uimg;
	}

	public void setUimg(byte[] uimg) {
		this.uimg = uimg;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", tel=" + tel + ", sex=" + sex
				+ ", city=" + city + ", name=" + name + ", brithday=" + brithday + ", imgurl=" + imgurl + ", uimg="
				+ Arrays.toString(uimg) + ", num=" + Arrays.toString(num) + ", friends=" + friends + ", blogs=" + blogs
				+ ", names=" + names + "]";
	}

    
}
