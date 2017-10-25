package net.ash.shoppingBackend.DAOImpl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.ash.shoppingBackend.DAO.CategoryDao;
import net.ash.shoppingBackend.Model.Category;
import net.ash.shoppingBackend.SessionUtil.SessionUtil;

@Repository("ctgryDao")
public class CategoryDaoImpl implements CategoryDao {

	@Autowired
	private static SessionUtil ssnUtil;
	
	private static List<Category> categories = new ArrayList<>();

	static {
		Category ctgry = new Category();
		ctgry.setCtgryId(1);
		ctgry.setCtgryActv(true);
		ctgry.setCtgryName("Telivision");
		ctgry.setCtgryImg("CT_1.png");
		ctgry.setCtgryDesc("LG-SmartTV");

		categories.add(ctgry);

		ctgry = new Category();

		ctgry.setCtgryId(2);
		ctgry.setCtgryActv(true);
		ctgry.setCtgryName("Laptop");
		ctgry.setCtgryImg("CT_2.png");
		ctgry.setCtgryDesc("LG-E530");

		categories.add(ctgry);

		ctgry = new Category();

		ctgry.setCtgryId(3);
		ctgry.setCtgryActv(true);
		ctgry.setCtgryName("Mobile");
		ctgry.setCtgryImg("CT_3.png");
		ctgry.setCtgryDesc("OPPO-F1S");

		categories.add(ctgry);
	}

	@Override
	public List<Category> list() {
		return categories;
	}

	@Override
	public Category get(int id) {
		for(Category ct : categories) {
			if(ct.getCtgryId() == id)
				return ct;
		}
		return null;
	}

	@Override
	@Transactional
	public boolean add(Category ct) {
		Session ssn = ssnUtil.getAnnotatedSession();
		try {
		ssn.persist(ct);
		return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			ssn.close();
		}
		
	}

}
