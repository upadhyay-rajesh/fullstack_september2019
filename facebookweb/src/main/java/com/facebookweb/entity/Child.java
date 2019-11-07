package com.facebookweb.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Child extends Parent{
	
	private String c_name;
	
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	
	
}
