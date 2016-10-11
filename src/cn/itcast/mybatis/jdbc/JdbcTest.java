package cn.itcast.mybatis.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * <p>Title: JdbcTest</p>
 * <p>Description: Use this jdbc project to summarize knowledge </p>
 * @author ChenAmber
 * @date 2016-10-3
 * @version 1.0
 */
public class JdbcTest {

	public static void main(String[] args) {
		// connect to database
		Connection connection = null;
		//prepared statement
		PreparedStatement preparedStatement = null;
		//result set
		ResultSet resultSet=null;		
		try{
			
			//load jdbc driver
			Class.forName("com.mysql.jdbc.Driver");
			//get database connection by driver management class
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/estore?characterEncoding=utf-8","root","shmily");
			//define SQL
			String sql = "select * from user where username=?";
			//obtain preparedStatement
			preparedStatement=connection.prepareStatement(sql);
			//set arguments, 1st argument is position of ?; 2ed arg is the argument
			preparedStatement.setString(1,"Jan");
			//get the result set
			resultSet = preparedStatement.executeQuery();
			//go through all lines
			while(resultSet.next()){
				System.out.println(resultSet.getString("id")+"  "+resultSet.getString("username"));
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			//release space
			if(resultSet!=null){
				try{
					resultSet.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
			if(preparedStatement!=null){
				try{
					preparedStatement.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
			if(connection!=null){
				try{
					connection.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
			
		}

	}
	

}
