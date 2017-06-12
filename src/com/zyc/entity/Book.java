package com.zyc.entity;

import java.sql.Date;

/**
 * 书类
 * bookid 书编号
 * bookName 书名
 * author作者
 * bookCategory 书类别
 * bookPress 书出版社
 * inventory 库存
 * rentdate借书日期
 * returndate 还书日期
 * @author YuChen Zhang
 *
 */
public class Book {
	private Integer bookid;
	private String bookName;
	private Acthor acthor;
	private Category bookCategory;
	private Publish bookPress;
	private Date rentdate;
	private Date returndate;
	/**
	 * 
	 */
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	/**
	 * @param bookid
	 * @param bookName
	 * @param acthor
	 * @param bookCategory
	 * @param bookPress
	 * @param rentdate
	 * @param returndate
	 */
	public Book(Integer bookid, String bookName, Acthor acthor, Category bookCategory, Publish bookPress, Date rentdate,
			Date returndate) {
		super();
		this.bookid = bookid;
		this.bookName = bookName;
		this.acthor = acthor;
		this.bookCategory = bookCategory;
		this.bookPress = bookPress;
		this.rentdate = rentdate;
		this.returndate = returndate;
	}


	public Integer getBookid() {
		return bookid;
	}
	public void setBookid(Integer bookid) {
		this.bookid = bookid;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public Category getBookCategory() {
		return bookCategory;
	}
	public void setBookCategory(Category bookCategory) {
		this.bookCategory = bookCategory;
	}
	public Publish getBookPress() {
		return bookPress;
	}
	public void setBookPress(Publish bookPress) {
		this.bookPress = bookPress;
	}
	public Acthor getActhor() {
		return acthor;
	}

	public void setActhor(Acthor acthor) {
		this.acthor = acthor;
	}

	public Date getRentdate() {
		return rentdate;
	}

	public void setRentdate(Date rentdate) {
		this.rentdate = rentdate;
	}

	public Date getReturndate() {
		return returndate;
	}

	public void setReturndate(Date returndate) {
		this.returndate = returndate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((acthor == null) ? 0 : acthor.hashCode());
		result = prime * result + ((bookCategory == null) ? 0 : bookCategory.hashCode());
		result = prime * result + ((bookName == null) ? 0 : bookName.hashCode());
		result = prime * result + ((bookPress == null) ? 0 : bookPress.hashCode());
		result = prime * result + ((bookid == null) ? 0 : bookid.hashCode());
		result = prime * result + ((rentdate == null) ? 0 : rentdate.hashCode());
		result = prime * result + ((returndate == null) ? 0 : returndate.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (acthor == null) {
			if (other.acthor != null)
				return false;
		} else if (!acthor.equals(other.acthor))
			return false;
		if (bookCategory == null) {
			if (other.bookCategory != null)
				return false;
		} else if (!bookCategory.equals(other.bookCategory))
			return false;
		if (bookName == null) {
			if (other.bookName != null)
				return false;
		} else if (!bookName.equals(other.bookName))
			return false;
		if (bookPress == null) {
			if (other.bookPress != null)
				return false;
		} else if (!bookPress.equals(other.bookPress))
			return false;
		if (bookid == null) {
			if (other.bookid != null)
				return false;
		} else if (!bookid.equals(other.bookid))
			return false;
		if (rentdate == null) {
			if (other.rentdate != null)
				return false;
		} else if (!rentdate.equals(other.rentdate))
			return false;
		if (returndate == null) {
			if (other.returndate != null)
				return false;
		} else if (!returndate.equals(other.returndate))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Book [bookid=" + bookid + ", bookName=" + bookName + ", bookCategory=" + bookCategory + ", bookPress="
				+ bookPress + "]";
	}
	
	
}
