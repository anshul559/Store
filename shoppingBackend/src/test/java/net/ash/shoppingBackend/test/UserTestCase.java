package net.ash.shoppingBackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.ash.shoppingBackend.DAO.UserDao;
import net.ash.shoppingBackend.Model.Address;
import net.ash.shoppingBackend.Model.Cart;
import net.ash.shoppingBackend.Model.UserDetail;

public class UserTestCase {

	private static AnnotationConfigApplicationContext context;

	public static UserDao userDao;

	public UserDetail user;
	public Address addrs;
	public Cart cart;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("net.ash.shoppingBackend");
		context.refresh();
		userDao = (UserDao) context.getBean("userDao");
	}

	@Test
	public void TestAtAdd() {
		user = new UserDetail();

		user.setFirstName("Ravi");
		user.setLastName("Sharma");
		user.setEmail("ravi@gmail.com");
		user.setPassword("12345");
		user.setContactno("9977327820");
		user.setRole("USER");

		assertEquals("Hi Add User Test Fails", true, userDao.addUser(user));

		addrs = new Address();

		addrs.setUserId(user.getId());
		addrs.setAddrsLine1("2nd Stage RoopenaAgrahara");
		addrs.setAddrsLine2("Near SilkBoard");
		addrs.setCity("Bangalore");
		addrs.setState("Karnataka");
		addrs.setCountry("India");
		addrs.setPostalCode("560068");
		addrs.setBilling(true);

		assertEquals("Hi Add Billing Address Test Fails", true, userDao.addAddress(addrs));

		if (user.getRole().equals("USER")) {
			cart = new Cart();
			cart.setUser(user);

			assertEquals("Hi Add Cart Test Fails", true, userDao.addCart(cart));

			/* Add Shipping Address */
			addrs = new Address();

			addrs.setUserId(user.getId());
			addrs.setAddrsLine1("2nd Stage RoopenaAgrahara");
			addrs.setAddrsLine2("Near SilkBoard");
			addrs.setCity("Bangalore");
			addrs.setState("Karnataka");
			addrs.setCountry("India");
			addrs.setPostalCode("560068");
			addrs.setShipping(true);

			assertEquals("Hi Add Shipping Address Test Fails", true, userDao.addAddress(addrs));

		}

	}
}
