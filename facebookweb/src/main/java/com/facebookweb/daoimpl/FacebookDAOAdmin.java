package com.facebookweb.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.hibernate.Query;
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
		
		//SessionFactory is singelton and thread safe
		//configure method will load hibernate.cfg.xml file by default if file name is different as zensar.cfg.xml then this value have to pass inside configure method
		//hiberrnate.cfg.xml all information under <session-factory> tag will be loaded by buildSessionFactory() and create database connection,connection pool,
		//check for driver class, check for table
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		//since SessionFactory is singleton so to do separate task we have to create separate session, here session means buffer
		Session ss=sf.openSession();
		
		//using session we can do following task
		//save object using save method means insert query, save executed based on callback method onSave()  means onSave() is responsible to run insert querry
		//update object using update method means update query, update executed based on callback method onUpdate()  means onUpdate() is responsible to run update querry
		//delete object using delete method means delete query, delete executed based on callback method onDelete()  means onDelete() is responsible to run delete querry
		//load object using load method means select query, load executed based on callback method onLoad()  means onLoad() is responsible to run select querry
		//createQuery object using createQuery method means delete,update and select query
		//transaction object 
		
		ss.save(fe);
		
		//transaction is a set of rule which must follow ACID(Atomicity,consistency,integrity and durability) properties. without transaction we can not update database permanently.
		Transaction t=ss.beginTransaction();
		t.commit();
		
		i=1;
		
		return i;
	}

	@Override
	public boolean loginProfile(FacebookEmployee fe) {
		boolean b=false;
		/*try {
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
			}*/
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session ss=sf.openSession();
		
		Query q=ss.createQuery("from com.facebookweb.entity.FacebookEmployee f where f.name='"+fe.getName()+"' and f.pass='"+fe.getPass()+"'");//select * from facebookemp where name=? and pass=?
		List<FacebookEmployee> fl=q.getResultList();
		if(fl.size()>0) {
			b=true;
		}
		
		return b;
	}
	
	public List<FacebookEmployee> friendList(FacebookEmployee fe) {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session ss=sf.openSession();
		
		Query q=ss.createQuery("from com.facebookweb.entity.FacebookEmployee f where f.name='"+fe.getName()+"' ");//select * from facebookemp where name=? 
		List<FacebookEmployee> fl=q.getResultList();
		
		return fl;
	}

}























