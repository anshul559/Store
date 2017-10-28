package net.ash.shoppingBackend.Model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="product")
public class Product {

	private long id;
	private String code;
	private String name;
	private String brand;
	private String description;
	private double unitPrice;
	private int quantity;
	private boolean active;
	private long categoryId;
	private long supplierId;
	private int purchases;
	private long views;
	
	
	public Product() {
		this.code = "PRD"+UUID.randomUUID().toString().substring(26).toUpperCase();
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getBrand() {
		return brand;
	}


	public void setBrand(String brand) {
		this.brand = brand;
	}

	@JsonIgnore
	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name="unit_price")
	public double getUnitPrice() {
		return unitPrice;
	}


	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Column(name="is_active")
	@JsonIgnore
	public boolean isActive() {
		return active;
	}


	public void setActive(boolean active) {
		this.active = active;
	}

	@Column(name="category_id")
	@JsonIgnore
	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	@Column(name="supplier_id")
	@JsonIgnore
	public long getSupplierId() {
		return supplierId;
	}


	public void setSupplierId(long supplierId) {
		this.supplierId = supplierId;
	}


	public int getPurchases() {
		return purchases;
	}


	public void setPurchases(int purchases) {
		this.purchases = purchases;
	}


	public long getViews() {
		return views;
	}


	public void setViews(long views) {
		this.views = views;
	}
	
	
	
	
}
