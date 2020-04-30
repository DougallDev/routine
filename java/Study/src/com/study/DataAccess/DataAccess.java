package com.study.DataAccess;

import java.sql.*;

public class DataAccess {

	public static void main(String[] args) {
		// 第一步：导包,将数据库驱动jar包拷贝到lib文件下
		// 第二部：加载驱动
		String connUrl = "jdbc:mysql://localhost/test";
		String connUser = "root";
		String connpassword = "root";
//		String sql="select * from trxn";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// 第三步：数据驱动管理者或者连接对象
			Connection conn = DriverManager.getConnection(connUrl, connUser, connpassword);
			// 第四步：创建命令对象
			PreparedStatement cmd = conn.prepareStatement("select * from lp");
			ResultSet res = cmd.executeQuery();
			System.out.print("**********");
			while (res.next()) {
				Integer id = res.getInt("lp_uid");
				String name = res.getString("lpName");
				String lpLoc = res.getString("lpLoc");
				System.out.print(id + " " + name + " " + lpLoc + "\n");
			}
			System.out.print("**********");
			// 第六步：释放数据库资源
			res.close();
			cmd.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}