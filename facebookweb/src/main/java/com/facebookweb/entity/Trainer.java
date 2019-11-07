package com.facebookweb.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Trainer {
@Id
@Column(name="t_id1")
private long t_id;
private String t_name;

@OneToMany(fetch = FetchType.LAZY,mappedBy="tt")
private List<Trainees> tlist=new ArrayList<Trainees>();

public long getT_id() {
	return t_id;
}

public void setT_id(long t_id) {
	this.t_id = t_id;
}

public String getT_name() {
	return t_name;
}

public void setT_name(String t_name) {
	this.t_name = t_name;
}


public List<Trainees> getTlist() {
	return tlist;
}

public void setTlist(List<Trainees> tlist) {
	this.tlist = tlist;
}


}
