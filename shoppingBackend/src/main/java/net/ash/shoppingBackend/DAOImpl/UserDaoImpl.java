package net.ash.shoppingBackend.DAOImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import net.ash.shoppingBackend.DAO.UserDao;
import net.ash.shoppingBackend.Model.Address;
import net.ash.shoppingBackend.Model.Cart;
import net.ash.shoppingBackend.Model.UserDetail;

@Repository("userDao")
public class UserDaoImpl implements UserDao{
	
	private static SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	private static Session ssn;

	@Override
	public boolean addUser(UserDetail ud) {
			ssn = sessionFactory.openSession();
		try {
			ssn.persist(ud);
			ssn.beginTransaction().commit();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean addAddress(Address addrs) {
		ssn = sessionFactory.openSession();
		try {
			ssn.persist(addrs);
			ssn.beginTransaction().commit();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean addCart(Cart crt) {
		ssn = sessionFactory.openSession();
		try {
			ssn.persist(crt);
			ssn.beginTransaction().commit();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
