package net.ash.shoppingBackend.DAO;

import java.util.List;

import net.ash.shoppingBackend.Model.Product;

public interface ProductDao {
	
	Product get(long id);
	
	List<Product> listAll();

	boolean add(Product pt);
	
	boolean update(Product pt);
	
	boolean delete(Product pt);
	
	// Buisness logic purpose filter
	
	List<Product> getActiveProducts();
	List<Product> getActiveProductsByCategory(long categoryId);
	List<Product> getLatestActiveProducts(int count);
}
