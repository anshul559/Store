package net.ash.shoppingBackend.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="cart")
public class Cart {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@OneToOne
	@JoinColumn(name="uId")
	private UserDetail user;
	@Column(name="grand_total")
	private double grandTtl;
	@Column(name="cart_lines")
	private int cartLines;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public UserDetail getUser() {
		return user;
	}
	public void setUser(UserDetail user) {
		this.user = user;
	}
	public double getGrandTtl() {
		return grandTtl;
	}
	public void setGrandTtl(double grandTtl) {
		this.grandTtl = grandTtl;
	}
	public int getCartLines() {
		return cartLines;
	}
	public void setCartLines(int cartLines) {
		this.cartLines = cartLines;
	}
	
	
}
