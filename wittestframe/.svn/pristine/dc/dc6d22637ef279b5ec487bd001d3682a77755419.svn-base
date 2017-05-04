package com.icinfo.witest.dao;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;


/** 
* @ClassName: JDBCUtil 
* @Description: JDBC数据库应用
* @author wang wencong
* @date 2016年4月11日 上午10:21:47 
*  
*/
public class JDBCUtil {

	/* 数据库连接 */
	// 驱动包名和数据库url
	private static String url = null;
	private static String driverClass = null;
	// 数据库用户名和密码
	private static String userName = null;
	private static String password = null;

	/**
	 * 初始化驱动程序 静态代码块中（只加载一次）
	 */

	static {

		try {
			Properties prop = new Properties();

			/**
			 * 使用类路径的读取方式 / : 斜杠表示classpath的根目录 在java项目下，classpath的根目录从bin目录开始
			 * 在web项目下，classpath的根目录从WEB-INF/classes目录开始
			 */

			InputStream in = JDBCUtil.class.getResourceAsStream("/db.properties");

			// 加载文件
			prop.load(in);

			// 读取信息
			url = prop.getProperty("url");
			driverClass = prop.getProperty("driverClass");
			userName = prop.getProperty("user");
			password = prop.getProperty("password");

			// 注册驱动程序
			Class.forName(driverClass);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("驱程程序注册出错");
		}

	}

	/**
	 * 打开数据库驱动连接
	 */
	public static Connection getConnection() {
		try {
			Connection conn = DriverManager.getConnection(url, userName, password);
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * 清理环境，关闭连接(顺序:后打开的先关闭)
	 */

	public static void close(Connection conn, Statement stmt, ResultSet rs) {
		if (rs != null)
			try {
				rs.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
				throw new RuntimeException(e1);
			}
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
	}
	
	public static void main(String[] args) {
		
		   Connection conn = null;
	       Statement stmt = null;
	       ResultSet rs = null;
	       JDBCUtil jdu = new JDBCUtil();
           System.out.print("url: " + url);
           System.out.print("username: " + userName);
           System.out.println("password" + password);
		
		
	}

}
