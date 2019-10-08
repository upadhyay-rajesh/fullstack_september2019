package com.facebookweb.serviceimpl;

import com.facebookweb.dao.FacebookDAOInterface;
import com.facebookweb.entity.FacebookEmployee;
import com.facebookweb.service.FacebookServiceInterface;

public class FacebookServiceAdmin implements FacebookServiceInterface {

	@Override
	public int createProfile(FacebookEmployee fe) {
		FacebookDAOInterface fd=FacebookDAOInterface.createObject("admin");
		int i=fd.createProfile(fe);
		return i;
	}

}
