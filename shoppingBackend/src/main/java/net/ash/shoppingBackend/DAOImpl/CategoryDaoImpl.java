package net.ash.shoppingBackend.DAOImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import net.ash.shoppingBackend.DAO.CategoryDao;
import net.ash.shoppingBackend.Model.Category;
@Repository("categoryDao")
public class CategoryDaoImpl implements CategoryDao {
	


	@Override
	public Category get(long id) {
		Session ssn = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory().openSession();
		Category ct = (Category)ssn.get(Category.class, Long.valueOf(id));
		
		return ct;
	}

	

	@Override
	public boolean add(Category ct) {
		 Session ssn = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory().openSession();	
		 Transaction t = ssn.beginTransaction();
		 try {
			ssn.persist(ct);
			t.commit();
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
		Session ssn = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory().openSession();
		Transaction t = ssn.beginTransaction();
		try {
			ssn.update(ct);
			t.commit();
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
		Session ssn = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory().openSession();
		Transaction t = ssn.beginTransaction();
		try {
				ct.setCtgryActv(false);
				ssn.update(ct);
				t.commit();
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
		Session ssn = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory().openSession();
		String hql = "SELECT c FROM Category c WHERE c.ctgryActv=:active";
		Query q = ssn.createQuery(hql);
		q.setParameter("active", true);
		return q.getResultList();
	}

}