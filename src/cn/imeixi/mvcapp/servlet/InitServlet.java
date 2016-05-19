package cn.imeixi.mvcapp.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.imeixi.mvcapp.dao.factory.CustomerDAOFactory;

/**
 * Servlet implementation class InitServlet
 */
@WebServlet(value="/initServlet",loadOnStartup=1)
public class InitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   public void init(){
	   InputStream in = getServletContext().getResourceAsStream("/WEB-INF/classes/switch.properties");
	   
	   Properties pro = new Properties();
	   try {
		pro.load(in);
		System.out.println(pro.getProperty("type"));
		CustomerDAOFactory.getInstance().setType(pro.getProperty("type"));
	} catch (IOException e) {
		e.printStackTrace();
	}
   }

}
