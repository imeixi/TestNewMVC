package cn.imeixi.mvcapp.dao;

import java.util.List;

import cn.imeixi.mvcapp.domain.Customer;

public interface CustomerDAO {
	
	public List<Customer> getForListWithCriteriaCustomer(CriteriaCustomer cc);
	
	public List<Customer> getAll();
	
	public Customer get(Integer id);
	
	public void save(Customer customer);
	
	public void delete(Integer id);
	
	public void update(Customer customer);
	
	public long getCountWithName(String name);
}
