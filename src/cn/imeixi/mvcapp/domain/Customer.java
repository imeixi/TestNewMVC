package cn.imeixi.mvcapp.domain;

public class Customer {
	private Integer id;
	private String name;
	private String address;
	private String phone;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Customer(Integer id, String name, String address, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.phone = phone;
	}
	
	public Customer(){
		
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", address=" + address + ", phone=" + phone + "]";
	}
	
	/**
	 * CREATE TABLE customer(
			id INT(10) NOT NULL AUTO_INCREMENT,
			name varchar(10) unique,
			address varchar(20),
			phone varchar(13),
			PRIMARY KEY(id)
	  );
	  
	  ALTER TABLE customer ADD unique(`name`);
	 */

}
