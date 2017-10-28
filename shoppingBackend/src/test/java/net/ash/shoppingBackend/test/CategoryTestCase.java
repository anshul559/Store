package net.ash.shoppingBackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.ash.shoppingBackend.DAO.CategoryDao;
import net.ash.shoppingBackend.Model.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;

	public static CategoryDao categoryDao;

	public Category category;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("net.ash.shoppingBackend");
		context.refresh();
		categoryDao = (CategoryDao) context.getBean("categoryDao");
	}


	@Test
	public void TestCrudCategory() {
//			ADD Record Test
		category = new Category();

		category.setCtgryActv(true);
		category.setCtgryName("Laptop");
		category.setCtgryImg("CT_20.jpg");
		category.setCtgryDesc("Fuzitsu");

		assertEquals("Hi----Your Test Case is Fail", true, categoryDao.add(category));
		
//		Get Single Record Test
		
		category = categoryDao.get(3);
		assertEquals("Hi----Your Test Case is Fail", "Mobile", category.getCtgryName());
//		
////		Update Record Test
//		
		category = categoryDao.get(1);
		category.setCtgryName("Refrigrator");
		assertEquals("Hi----Your Test Case is Fail", true, categoryDao.update(category));
//		
////		Delete Record Test
//		
		category = categoryDao.get(3);
		assertEquals("Hi----Your Test Case is Fail", true, categoryDao.delete(category));
//		
////		Select All Active Record Test
//		
		assertEquals("Hi----Your Test Case is Fail", 3, categoryDao.listAll().size());
	}
}
