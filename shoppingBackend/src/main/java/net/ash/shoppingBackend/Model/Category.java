package net.ash.shoppingBackend.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name="category")
public class Category {
	
	@Id
	@GeneratedValue
	@Column(name="CATEGORY_ID")
	private long ctgryId;
	@Column(name="CATEGORY_ACTIVE")
	private boolean ctgryActv;
	@Column(name="CATEGORY_NAME")
	private String ctgryName;
	@Column(name="CATEGORY_IMG")
	private String ctgryImg;
	@Column(name="CATEGORY_DESCRIPTION")
	private String ctgryDesc;
	@Version
	@Column(name="CATEGORY_VERSION-No")
	private int ctgryV;
	public long getCtgryId() {
		return ctgryId;
	}
	public void setCtgryId(long ctgryId) {
		this.ctgryId = ctgryId;
	}
	public String getCtgryName() {
		return ctgryName;
	}
	public void setCtgryName(String ctgryName) {
		this.ctgryName = ctgryName;
	}
	public String getCtgryImg() {
		return ctgryImg;
	}
	public void setCtgryImg(String ctgryImg) {
		this.ctgryImg = ctgryImg;
	}
	public String getCtgryDesc() {
		return ctgryDesc;
	}
	public void setCtgryDesc(String ctgryDesc) {
		this.ctgryDesc = ctgryDesc;
	}
	public boolean isCtgryActv() {
		return ctgryActv;
	}
	public void setCtgryActv(boolean ctgryActv) {
		this.ctgryActv = ctgryActv;
	}
	public int getCtgryV() {
		return ctgryV;
	}
	public void setCtgryV(int ctgryV) {
		this.ctgryV = ctgryV;
	}
	
	
	
}
