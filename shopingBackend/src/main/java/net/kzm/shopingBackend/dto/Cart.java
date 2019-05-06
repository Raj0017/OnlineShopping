package net.kzm.shopingBackend.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="cart_line")
public class Cart implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@OneToOne
	private User user;
	
	
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getId() {
		return id;
	}
	
	public int getCartLine() {
		return cartLine;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public void setCartLine(int cartLine) {
		this.cartLine = cartLine;
	}
	
	@Column(name="cart_line")
	private int cartLine;
	@Override
	public String toString() {
		return "Cart [id=" + id + ",  cartLine=" + cartLine + ", grandTotal=" + grandTotal + "]";
	}
	@Column(name="grand_total")
	private double grandTotal;
	public double getGrandTotal() {
		return grandTotal;
	}
	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}
	


}
