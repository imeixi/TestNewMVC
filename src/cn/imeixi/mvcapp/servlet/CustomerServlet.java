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
import cn.imeixi.mvcapp.dao.factory.CustomerDAOFactory;
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
	private CustomerDAO customerDAO = CustomerDAOFactory.getInstance().getCustomerDAO();
	
	
	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String idstr = request.getParameter("id");
		int id = 0;
		
		try {
			id = Integer.parseInt(idstr);
			customerDAO.delete(id);
		} catch (Exception e) {
		}
		
		response.sendRedirect("query.do");
	}

	private void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		List<Customer> customers = customerDAO.getAll();
		
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		
		CriteriaCustomer cc = new CriteriaCustomer(name, address, phone);
		
		List<Customer> customers = customerDAO.getForListWithCriteriaCustomer(cc);
		request.setAttribute("customers", customers);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
		
	}

	private void addCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1、获取参数
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		//2、验证名字是否存在
		long count = customerDAO.getCountWithName(name);
		if(count > 0){
			//2.1 如果存在 返还 msg “用户名 name 已存在”
			String msg = "用户名" + name + "已存在";
			//2.2 将表单数据，封装成对象，回传给。
			request.setAttribute("message", msg);
			//2.3 重定向至addNewCustomer
			request.getRequestDispatcher("/addNewCustomer.jsp").forward(request, response);
			return;
		}
		//2.4 前端进行显示
		//3、如果名字不存在，调用save方法，重定向到 query.do
		Customer customer = new Customer(name, address, phone);
		customerDAO.save(customer);
		response.sendRedirect("success.jsp");
		
		
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String oldName = request.getParameter("oldName");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		
		
		if(!oldName.equalsIgnoreCase(name)){
			//2、验证名字是否存在
			long count = customerDAO.getCountWithName(name);
			System.out.println("count: " + count);
			if(count > 0){
				//2.1 如果存在 返还 msg “用户名 name 已存在”
				String msg = "用户名" + name + "已存在";
				//2.2 将表单数据，封装成对象，回传给。
				request.setAttribute("message", msg);
				//2.3 重定向至addNewCustomer
				request.getRequestDispatcher("/updatecustomer.jsp").forward(request, response);
				return;
			}	
		}
		
		Customer customer = new Customer(name, address, phone);
		customer.setId(Integer.parseInt(id));
		
		customerDAO.update(customer);
		response.sendRedirect("query.do");
		
	}
	
	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forwardPath = "/error.jsp";
		String idStr = request.getParameter("id");
		
		try {
			Customer customer = customerDAO.get(Integer.parseInt(idStr));
			if(customer != null){
				forwardPath = "/updatecustomer.jsp";
				request.setAttribute("customer", customer);
			}
			
		} catch (Exception e) {}
		
		request.getRequestDispatcher(forwardPath).forward(request, response);
		  
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
