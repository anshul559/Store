package net.ash.shoppingBackend.DAO;

import net.ash.shoppingBackend.Model.Address;
import net.ash.shoppingBackend.Model.Cart;
import net.ash.shoppingBackend.Model.UserDetail;

public interface UserDao {
	
	boolean addUser(UserDetail ud);
	
	boolean addAddress(Address addrs);
	
	boolean addCart(Cart crt);
	
}
