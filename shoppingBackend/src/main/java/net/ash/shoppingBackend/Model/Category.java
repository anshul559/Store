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
	
	private boolean ctgryActv = true;
	
	private String ctgryName;
	
	private String ctgryImg;
	
	private String ctgryDesc;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	public long getCtgryId() {
		return ctgryId;
	}
	public void setCtgryId(long ctgryId) {
		this.ctgryId = ctgryId;
	}
	@Column(name="name")
	public String getCtgryName() {
		return ctgryName;
	}
	public void setCtgryName(String ctgryName) {
		this.ctgryName = ctgryName;
	}
	@Column(name="image_url")
	public String getCtgryImg() {
		return ctgryImg;
	}
	public void setCtgryImg(String ctgryImg) {
		this.ctgryImg = ctgryImg;
	}
	@Column(name="description")
	public String getCtgryDesc() {
		return ctgryDesc;
	}
	public void setCtgryDesc(String ctgryDesc) {
		this.ctgryDesc = ctgryDesc;
	}
	@Column(name="is_active")
	public boolean isCtgryActv() {
		return ctgryActv;
	}
	public void setCtgryActv(boolean ctgryActv) {
		this.ctgryActv = ctgryActv;
	}
	@Override
	public String toString() {
		return "Category [ctgryId=" + ctgryId + ", ctgryActv=" + ctgryActv + ", ctgryName=" + ctgryName + ", ctgryImg="
				+ ctgryImg + ", ctgryDesc=" + ctgryDesc + "]";
	}

	
	
	
}
