package com.facebookweb.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.facebookweb.dao.FacebookDAOInterface;
import com.facebookweb.entity.FacebookEmployee;
import com.facebookweb.helper.DatabaseHelper;
import com.facebookweb.service.FacebookServiceInterface;

public class FacebookDAOAdmin implements FacebookDAOInterface {

	@Override
	public int createProfile(FacebookEmployee fe) {
		int i=0;
		/*try {
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
		}*/
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session ss=sf.openSession();
		
		ss.save(fe);
		Transaction t=ss.beginTransaction();
		t.commit();
		
		return i;
	}

	@Override
	public boolean loginProfile(FacebookEmployee fe) {
		boolean b=false;
		try {
			Connection con=DatabaseHelper.createConnection("oracle");
			PreparedStatement ps=con.prepareStatement("select * from facebookemp where name=? and pass=?");
			ps.setString(1, fe.getName());
			ps.setString(2, fe.getPass());
			
			ResultSet i=ps.executeQuery();
			if(i.next()) {
				b=true;
			}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		return b;
	}

}
