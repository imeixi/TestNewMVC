package cn.imeixi.mvcapp.test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import cn.imeixi.mvcapp.db.JdbcUtils;

public class TestJdbcUtils {

	@Test
	public void testGetConnection() {
		try {
			System.out.println(JdbcUtils.getConnection());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
