package cn.imeixi.mvcapp.dao.factory;

import java.util.HashMap;
import java.util.Map;

import cn.imeixi.mvcapp.dao.CustomerDAO;
import cn.imeixi.mvcapp.dao.impl.CustomerDAOJdbcImpl;
import cn.imeixi.mvcapp.dao.impl.CustomerDAOXmlImpl;
import sun.security.jca.GetInstance;

public class CustomerDAOFactory {
	
	private Map<String,CustomerDAO> map = new HashMap<String,CustomerDAO>();
	
	private String type = null;
	
	private static CustomerDAOFactory instance = new CustomerDAOFactory();
	
	public static CustomerDAOFactory getInstance() {
		return instance;
	}
	
	public CustomerDAOFactory(){
		map.put("jdbc", new CustomerDAOJdbcImpl());
		map.put("xml", new CustomerDAOXmlImpl());
	}
	
	public void setType(String type){
		this.type = type;
	}
	
	

	public CustomerDAO getCustomerDAO(){
		return map.get(type);
	}

}
