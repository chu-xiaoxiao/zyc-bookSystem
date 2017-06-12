package com.zyc.entity;
/**
 * 出版社
 * publishId 出版社id
 * publishName 出版社名称
 * @author YuChen Zhang
 *
 */
public class Publish {
	private Integer publishId;
	private String publishName;
	/**
	 * 
	 */
	public Publish() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param publishId
	 * @param publishName
	 */
	public Publish(Integer publishId, String publishName) {
		super();
		this.publishId = publishId;
		this.publishName = publishName;
	}
	public Integer getPublishId() {
		return publishId;
	}
	public void setPublishId(Integer publishId) {
		this.publishId = publishId;
	}
	public String getPublishName() {
		return publishName;
	}
	public void setPublishName(String publishName) {
		this.publishName = publishName;
	}
	@Override
	public String toString() {
		return  publishName;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((publishId == null) ? 0 : publishId.hashCode());
		result = prime * result + ((publishName == null) ? 0 : publishName.hashCode());
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
		Publish other = (Publish) obj;
		if (publishId == null) {
			if (other.publishId != null)
				return false;
		} else if (!publishId.equals(other.publishId))
			return false;
		if (publishName == null) {
			if (other.publishName != null)
				return false;
		} else if (!publishName.equals(other.publishName))
			return false;
		return true;
	}
	
}
