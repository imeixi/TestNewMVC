package cn.imeixi.mvcapp.test;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;

import cn.imeixi.mvcapp.dao.CustomerDAO;
import cn.imeixi.mvcapp.dao.CriteriaCustomer;
import cn.imeixi.mvcapp.dao.impl.CustomerDAOJdbcImpl;
import cn.imeixi.mvcapp.domain.Customer;

public class TestCustomerDAOJdbcImpl {
	
	private CustomerDAO customerDAO = new CustomerDAOJdbcImpl(); 
	
	@Test
	public void TestGetForListWithCriteriaCustomer(){
		CriteriaCustomer criteriaCustomer = new CriteriaCustomer("oo", "", "");
		List<Customer> customes = customerDAO.getForListWithCriteriaCustomer(criteriaCustomer);
		System.out.println(customes);
	}
	
	@Test
	public void testGetAll() {
		List<Customer> customers = customerDAO.getAll();
		System.out.println(customers);
	}

	@Test
	public void testGetInteger() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetCountWithName() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateCustomer() {
		fail("Not yet implemented");
	}

	@Test
	public void testSave() {
		Customer cust = new Customer();
		cust.setAddress("shanghai");
		cust.setName("huanpujiang");
		cust.setPhone("13800138124");
		customerDAO.save(cust);
	}

}
