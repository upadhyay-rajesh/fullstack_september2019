package com.facebookweb.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.facebookweb.dao.FacebookDAOInterface;
import com.facebookweb.entity.FacebookEmployee;
import com.facebookweb.helper.DatabaseHelper;
import com.facebookweb.service.FacebookServiceInterface;

public class FacebookDAOAdmin implements FacebookDAOInterface {

	@Override
	public int createProfile(FacebookEmployee fe) {
		int i=0;
		try {
		Connection con=DatabaseHelper.createConnection("oracle");
		PreparedStatement ps=con.prepareStatement("insert into facebookemp values(?,?,?,?)");
		ps.setString(1, fe.getName());
		ps.setString(2, fe.getPass());
		ps.setString(3, fe.getEmail());
		ps.setString(4, fe.getAddress());
		i=ps.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	}

}
