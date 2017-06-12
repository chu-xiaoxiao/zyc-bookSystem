package com.zyc.entity;
/**
 * 用户
 * CustomerId 用户id
 * CustomerName 用户名
 * CustomerPassword 密码
 * CustomerGroy用户类别
 * @author YuChen Zhang
 *
 */
public class Customer {
	private Integer customerId;
	private String customerName;
	private String customerPassword;
	private String customerGroy;
	/**
	 * 
	 */
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param customerName
	 * @param customerPassword
	 */
	public Customer(String customerName, String customerPassword) {
		super();
		this.customerName = customerName;
		this.customerPassword = customerPassword;
	}
	
	/**
	 * @param customerName
	 * @param customerPassword
	 * @param customerGroy
	 */
	public Customer(String customerName, String customerPassword, String customerGroy) {
		super();
		this.customerName = customerName;
		this.customerPassword = customerPassword;
		this.customerGroy = customerGroy;
	}

	/**
	 * @param customerId
	 * @param customerName
	 * @param customerPassword
	 * @param customerGroy
	 */
	public Customer(Integer customerId, String customerName, String customerPassword, String customerGroy) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerPassword = customerPassword;
		this.customerGroy = customerGroy;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerPassword() {
		return customerPassword;
	}
	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}
	public String getCustomerGroy() {
		return customerGroy;
	}
	public void setCustomerGroy(String customerGroy) {
		this.customerGroy = customerGroy;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerPassword="
				+ customerPassword + ", customerGroy=" + customerGroy + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customerGroy == null) ? 0 : customerGroy.hashCode());
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result + ((customerName == null) ? 0 : customerName.hashCode());
		result = prime * result + ((customerPassword == null) ? 0 : customerPassword.hashCode());
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
		Customer other = (Customer) obj;
		if (customerGroy == null) {
			if (other.customerGroy != null)
				return false;
		} else if (!customerGroy.equals(other.customerGroy))
			return false;
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
			return false;
		if (customerName == null) {
			if (other.customerName != null)
				return false;
		} else if (!customerName.equals(other.customerName))
			return false;
		if (customerPassword == null) {
			if (other.customerPassword != null)
				return false;
		} else if (!customerPassword.equals(other.customerPassword))
			return false;
		return true;
	}
	
}
