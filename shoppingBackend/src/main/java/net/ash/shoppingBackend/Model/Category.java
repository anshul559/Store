package net.ash.shoppingBackend.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name="category")
public class Category {
	

	private long ctgryId;
	
	private boolean ctgryActv;
	
	private String ctgryName;
	
	private String ctgryImg;
	
	private String ctgryDesc;
	
	private int ctgryV;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CATEGORY_ID")
	public long getCtgryId() {
		return ctgryId;
	}
	public void setCtgryId(long ctgryId) {
		this.ctgryId = ctgryId;
	}
	@Column(name="CATEGORY_NAME")
	public String getCtgryName() {
		return ctgryName;
	}
	public void setCtgryName(String ctgryName) {
		this.ctgryName = ctgryName;
	}
	@Column(name="CATEGORY_IMG")
	public String getCtgryImg() {
		return ctgryImg;
	}
	public void setCtgryImg(String ctgryImg) {
		this.ctgryImg = ctgryImg;
	}
	@Column(name="CATEGORY_DESCRIPTION")
	public String getCtgryDesc() {
		return ctgryDesc;
	}
	public void setCtgryDesc(String ctgryDesc) {
		this.ctgryDesc = ctgryDesc;
	}
	@Column(name="CATEGORY_ACTIVE")
	public boolean isCtgryActv() {
		return ctgryActv;
	}
	public void setCtgryActv(boolean ctgryActv) {
		this.ctgryActv = ctgryActv;
	}
	@Version
	@Column(name="CATEGORY_VERSION")
	public int getCtgryV() {
		return ctgryV;
	}
	public void setCtgryV(int ctgryV) {
		this.ctgryV = ctgryV;
	}
	
	
	
}
