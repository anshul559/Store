package net.ash.shoppingBackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.ash.shoppingBackend.DAO.ProductDao;
import net.ash.shoppingBackend.Model.Product;

public class ProductTestCase {
	
	private static AnnotationConfigApplicationContext context;

	public static ProductDao productDao;

	public Product product;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("net.ash.shoppingBackend");
		context.refresh();
		productDao = (ProductDao) context.getBean("productDao");
	}


	@Test
	public void TestCrudProduct() {
//			ADD Record Test
		product = new Product();

		product.setName("OPPO-F1S");
		product.setBrand("OPPO");
		product.setDescription("This is Selfie expert mobile");
		product.setUnitPrice(20000);
		product.setActive(true);
		product.setCategoryId(3);
		product.setSupplierId(3);

		assertEquals("hi ----This Case is fail", true, productDao.add(product));
		
//		Get Single Record Test
		
		product = productDao.get(4);
		assertEquals("hi ----This Case is fail", "apple", product.getBrand());
		
//		Update Record Test
		
		product = productDao.get(2);
		product.setUnitPrice(25000);
		assertEquals("hi", true, productDao.update(product));
		
//		Delete Record Test
		
		product = productDao.get(5);
		assertEquals("hi", true, productDao.delete(product));
		
//		Select All Active Record Test
		
		assertEquals("hi", 6, productDao.listAll().size());

		
	}
	
	@Test
	public void TestAtgetActiveProducts() {
		
		 assertEquals("Hi---Test Case Fail on TestAtgetActiveProducts", 5, productDao.getActiveProducts().size());
	}
	
	@Test
	public void TestAtgetActiveProductsByCategory() {
		
		 assertEquals("Hi---Test Case Fail on TestAtgetActiveProductsByCategory", 3, productDao.getActiveProductsByCategory(3).size());
		 assertEquals("Hi---Test Case Fail on TestAtgetActiveProductsByCategory", 2, productDao.getActiveProductsByCategory(1).size());
	}
	
	@Test
	public void TestAtgetLatestActiveProducts() {
		
		 assertEquals("Hi---Test Case Fail on TestAtgetLatestActiveProducts", 3, productDao.getLatestActiveProducts(3).size());
	}
}
