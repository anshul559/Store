package net.ash.shoppingBackend.DAO;

import java.util.List;

import net.ash.shoppingBackend.Model.Category;

public interface CategoryDao {
	
	 public List<Category> list();
	 public Category get(int ctgryId);
}
