package com.spider.hibernate.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StudentDTO {
	
	@Id
	private int sid;
	private String sname;
	private String semail;
	private int smarks;
	private String saddress;
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
	public String getSemail() {
		return semail;
	}
	public void setSemail(String semail) {
		this.semail = semail;
	}
	public int getSmarks() {
		return smarks;
	}
	public void setSmarks(int smarks) {
		this.smarks = smarks;
	}
	public String getSaddress() {
		return saddress;
	}
	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}
	@Override
	public String toString() {
		return "StudentDTO [sid=" + sid + ", sname=" + sname + ", semail=" + semail + ", smarks=" + smarks
				+ ", saddress=" + saddress + "]";
	}
	
	
	
	

}
