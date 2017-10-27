package net.ash.shoppingBackend.DAO;

import java.util.List;


import net.ash.shoppingBackend.Model.Category;

public interface CategoryDao {
	
	public Category get(long ctgryId);

//	public int list();
	
	public List<Category> listAll();

	public boolean add(Category ct);
	
	public boolean update(Category ct);
	
	public boolean delete(Category ct);
}
