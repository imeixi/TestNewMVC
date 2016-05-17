package cn.imeixi.mvcapp.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.imeixi.mvcapp.dao.CriteriaCustomer;
import cn.imeixi.mvcapp.dao.CustomerDAO;
import cn.imeixi.mvcapp.dao.impl.CustomerDAOJdbcImpl;
import cn.imeixi.mvcapp.domain.Customer;

/**
 * Servlet implementation class CustomerSevlet
 */
@WebServlet(name="customerServlet",urlPatterns={"*.do","/customerServlet"})
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		
		/**
		 * 一个servlet处理多个请求
		 * 方法一：
		 * 1、通过请求添加method方法参数
		 * 2、再加上switch，获取方法名称进行调用
		 */
		String methodParm = request.getParameter("method");
		if(methodParm != null){
			switch(methodParm){
			case "addCustomer": addCustomer(request,response);break;
			case "query": query(request,response);break;
			case "delete": delete(request,response);break;
			}
		}else{
			
			/**
			 * 方法二：
			 * 通过配置文件，*.do 定义指向的servlet
			 * 通过解析path名称，解析出methodname
			 */
			
			String methodPath = request.getServletPath();
			String methodName = methodPath.substring(1, methodPath.indexOf("."));
			try {
				Method method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
				method.invoke(this, request,response);
			} catch (Exception e) {
				e.printStackTrace();
			} 
			
		}
		
		
	}
	private CustomerDAO customerDAO = new CustomerDAOJdbcImpl();
	
	private void delete(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("delete");
	}

	private void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		List<Customer> customers = customerDAO.getAll();
		
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		
		CriteriaCustomer cc = new CriteriaCustomer(name, address, phone);
		System.out.println(cc);
		
		List<Customer> customers = customerDAO.getForListWithCriteriaCustomer(cc);
		request.setAttribute("customers", customers);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
		
	}

	private void addCustomer(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("add");
		
	}

	private void update(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("update");
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
