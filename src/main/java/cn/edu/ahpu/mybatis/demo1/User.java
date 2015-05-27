package cn.edu.ahpu.mybatis.demo1;

import java.util.Date;

public final class User {
	private int sid;
	private String sname;
	private int age;
	private Date birth;

	public User() {
		super();
	}

	public User(int sid, String sname, int age, Date birth) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.age = age;
		this.birth = birth;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String toString(){
		return "User[sid:"+this.sid+",sname:"+this.sname+",age:"+this.age+",birth:"+this.birth+"]";
	}
}
