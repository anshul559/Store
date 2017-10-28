package net.ash.shoppingBackend.DAOImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.ash.shoppingBackend.DAO.CategoryDao;
import net.ash.shoppingBackend.Model.Category;
@Repository("categoryDao")
@Transactional
public class CategoryDaoImpl implements CategoryDao {
	
	private static SessionFactory ssnFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	private static Session ssn;


	@Override
	public Category get(long id) {
		ssn = ssnFactory.openSession();
		Category ct = (Category)ssn.get(Category.class, Long.valueOf(id));
		
		return ct;
	}

	

	@Override
	public boolean add(Category ct) {
		ssn = ssnFactory.openSession();	
		
		 try {
			ssn.persist(ct);
			System.out.println("Object save success");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			ssn.close();
		}

	}

	@Override
	public boolean update(Category ct) {
		ssn = ssnFactory.openSession();
		
		try {
			ssn.update(ct);
			
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			ssn.close();
		}
		
	}

	@Override
	public boolean delete(Category ct) {
		ssn = ssnFactory.openSession();
		
		try {
				ct.setCtgryActv(false);
				ssn.update(ct);
				
				return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			ssn.close();
		}
		
	}


	@Override
	public List<Category> listAll() {
		ssn = ssnFactory.openSession();
		String hql = "SELECT c FROM Category c WHERE c.ctgryActv=:active";
		Query q = ssn.createQuery(hql);
		q.setParameter("active", true);
		return q.getResultList();
	}

}