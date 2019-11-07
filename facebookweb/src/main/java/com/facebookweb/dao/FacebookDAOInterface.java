package com.facebookweb.dao;

import com.facebookweb.daoimpl.FacebookDAOAdmin;
import com.facebookweb.daoimpl.FacebookDAOUser;
import com.facebookweb.entity.FacebookEmployee;
import com.facebookweb.service.FacebookServiceInterface;
import com.facebookweb.serviceimpl.FacebookServiceAdmin;
import com.facebookweb.serviceimpl.FacebookServiceUser;

public interface FacebookDAOInterface {

	static FacebookDAOInterface createObject(String a) {
		FacebookDAOInterface fd=null;
		if(a.equals("admin")) {
			if(fd==null) {
				fd=new FacebookDAOAdmin();
			}
		}
		else {
			fd=new FacebookDAOUser();
		}
		return fd;
	}

	int createProfile(FacebookEmployee fe);
	int createProfile1(FacebookEmployee fe);

	boolean loginProfile(FacebookEmployee fe);

}
