package com.mall.product;

public class ProductVO {
	private String pcode;
	private String pname;
	private String image;
	private String madein;
	private String content;
	private String price;
	private String insertDate;
	private String pcolor;
	private String psize;
	private String category;
	private String deliveryFee;
	private String stock;
	private String isPopular;
	
	
	
	
	public String getPcode() {
		return pcode;
	}
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getMadein() {
		return madein;
	}
	public void setMadein(String madein) {
		this.madein = madein;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getinsertDate() {
		return insertDate;
	}
	public void setinsertDate(String insertDate) {
		this.insertDate = insertDate;
	}
	public String getPcolor() {
		return pcolor;
	}
	public void setPcolor(String pcolor) {
		this.pcolor = pcolor;
	}
	public String getPsize() {
		return psize;
	}
	public void setPsize(String psize) {
		this.psize = psize;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getdeliveryFee() {
		return deliveryFee;
	}
	public void setdeliveryFee(String deliveryFee) {
		this.deliveryFee = deliveryFee;
	}
	public String getStock() {
		return stock;
	}
	public void setStock(String stock) {
		this.stock = stock;
	}
	public String getisPopular() {
		return isPopular;
	}
	public void setisPopular(String isPopular) {
		this.isPopular = isPopular;
	}
	@Override
	public String toString() {
		return "ProductVO [pcode=" + pcode + ", pname=" + pname + ", image=" + image + ", madein=" + madein
				+ ", content=" + content + ", price=" + price + ", insertDate=" + insertDate + ", pcolor=" + pcolor
				+ ", psize=" + psize + ", category=" + category + ", deliveryFee=" + deliveryFee + ", stock=" + stock
				+ ", isPopular=" + isPopular + "]";
	}
	
	
	
	
	
}
