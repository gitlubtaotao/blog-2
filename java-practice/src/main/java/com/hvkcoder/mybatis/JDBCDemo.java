package com.hvkcoder.mybatis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * TODO: 使用 JDBC 连接并操作数据库
 * @author h-vk
 * @date 2019-12-19
 * @since V1.0
 */
public class JDBCDemo {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://127.0.0.1:3306/pmdb?useUnicode=true&characterEncoding=UTF-8&useSSL=false";
		String userName = "root";
		String password = "123456";

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try{
			connection = DriverManager.getConnection(url, userName, password);
			preparedStatement = connection.prepareStatement("SELECT DepartmentID, DepartmentName FROM pm_department_d");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()){
				System.out.println(resultSet.getString("DepartmentID")+"  "+ resultSet.getString("DepartmentName"));
			}
		}catch (Exception ex){
			System.out.println(ex.getMessage());
		}finally {
			if (resultSet != null) {
				resultSet.close();
			}
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (connection != null) {
				connection.close();
			}
		}

	}
}
