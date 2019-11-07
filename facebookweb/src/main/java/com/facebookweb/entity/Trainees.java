package com.facebookweb.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Trainees {
	@Id
	private long tr_id;
	private String tr_name;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="t_id1") 
	private Trainer tt;

	public long getTr_id() {
		return tr_id;
	}

	public void setTr_id(long tr_id) {
		this.tr_id = tr_id;
	}

	public String getTr_name() {
		return tr_name;
	}

	public void setTr_name(String tr_name) {
		this.tr_name = tr_name;
	}

	
	public Trainer getTt() {
		return this.tt;
	}

	public void setTt(Trainer tt) {
		this.tt = tt;
	}
	
	
}
