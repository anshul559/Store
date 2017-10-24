package net.ash.shoppingBackend.Model;

public class Category {
	private long ctgryId;
	private String ctgryName;
	private String ctgryImg;
	private String ctgryDesc;
	private boolean ctgryActv;
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
	
	
}
