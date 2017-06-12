package com.zyc.entity;

public class Acthor {
	private Integer acthorId;
	private String acthorName;
	private Short sex;
	/**
	 * 
	 */
	public Acthor() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param acthorId
	 * @param acthorName
	 * @param sex
	 */
	public Acthor(Integer acthorId, String acthorName, Short sex) {
		super();
		this.acthorId = acthorId;
		this.acthorName = acthorName;
		this.sex = sex;
	}
	public Integer getActhorId() {
		return acthorId;
	}
	public void setActhorId(Integer acthorId) {
		this.acthorId = acthorId;
	}
	public String getActhorName() {
		return acthorName;
	}
	public void setActhorName(String acthorName) {
		this.acthorName = acthorName;
	}
	public Short getSex() {
		return sex;
	}
	public void setSex(Short sex) {
		this.sex = sex;
	}
	@Override
	public String toString() {
		return  acthorName ;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((acthorId == null) ? 0 : acthorId.hashCode());
		result = prime * result + ((acthorName == null) ? 0 : acthorName.hashCode());
		result = prime * result + ((sex == null) ? 0 : sex.hashCode());
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
		Acthor other = (Acthor) obj;
		if (acthorId == null) {
			if (other.acthorId != null)
				return false;
		} else if (!acthorId.equals(other.acthorId))
			return false;
		if (acthorName == null) {
			if (other.acthorName != null)
				return false;
		} else if (!acthorName.equals(other.acthorName))
			return false;
		if (sex == null) {
			if (other.sex != null)
				return false;
		} else if (!sex.equals(other.sex))
			return false;
		return true;
	}
	
}
