package com.facebookweb.service;

import com.facebookweb.entity.FacebookEmployee;
import com.facebookweb.serviceimpl.FacebookServiceAdmin;
import com.facebookweb.serviceimpl.FacebookServiceUser;

public interface FacebookServiceInterface {
	static FacebookServiceInterface createObject(String a){
		FacebookServiceInterface fs=null;
		if(a.equals("admin")) {
			fs=new FacebookServiceAdmin();
		}
		else {
			fs=new FacebookServiceUser();
		}
		return fs;
	}

	int createProfile(FacebookEmployee fe);
	
}
