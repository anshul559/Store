package net.ash.shoppingBackend.DAOImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.ash.shoppingBackend.DAO.ProductDao;
import net.ash.shoppingBackend.Model.Product;

@Repository("productDao")
@Transactional
public class ProductDaoImpl implements ProductDao{
	
	private static SessionFactory ssnFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	private static Session ssn;
	
	@Override
	public Product get(long id) {
		ssn = ssnFactory.openSession();
		Product p = ssn.get(Product.class, Long.valueOf(id));
		return p;
	}

	@Override
	public List<Product> listAll() {
		ssn = ssnFactory.openSession();
		return ssn.createQuery("SELECT p FROM Product p", Product.class)
		 .getResultList();
	}

	@Override
	public boolean add(Product pt) {
		ssn = ssnFactory.openSession();
		try {
			ssn.persist(pt);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			ssn.close();
		}
	}

	@Override
	public boolean update(Product pt) {
		ssn = ssnFactory.openSession();
		try {
			ssn.update(pt);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			ssn.close();
		}
		
	}

	@Override
	public boolean delete(Product pt) {
		ssn = ssnFactory.openSession();
		try {
			pt.setActive(false);
			ssn.update(pt);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			ssn.close();
		}
	}

	@Override
	public List<Product> getActiveProducts() {
		String getActiveProduct = "SELECT p FROM Product p WHERE p.active = :active";	
		return ssnFactory.openSession()
							.createQuery(getActiveProduct, Product.class)
								.setParameter("active", true).getResultList();
	}

	@Override
	public List<Product> getActiveProductsByCategory(long categoryId) {
		String getActiveProductsByCategory = "SELECT p FROM Product p WHERE p.active = :active AND p.categoryId=:categoryId";	
		return ssnFactory.openSession()
							.createQuery(getActiveProductsByCategory, Product.class)
								.setParameter("active", true)
									.setParameter("categoryId", categoryId).getResultList();
	}

	@Override
	public List<Product> getLatestActiveProducts(int count) {
		String getLatestActiveProducts = "SELECT p FROM Product p WHERE p.active = :active ORDER BY id";	
		return ssnFactory.openSession()
							.createQuery(getLatestActiveProducts, Product.class)
								.setParameter("active", true)
									.setFirstResult(0)
										.setMaxResults(count).getResultList();
	}

}
