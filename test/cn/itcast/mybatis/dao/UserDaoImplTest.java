package cn.itcast.mybatis.dao;
import java.io.InputStream;
import java.util.Date;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.itcast.mybatis.po.User;

public class UserDaoImplTest {

	private SqlSessionFactory sqlSessionFactory;
	
	//此方法是在执行testFindUserById之前执行的
	@Before
	public void setUp() throws Exception {
		//创建sqlSessionFactory
		
		//mybatis配置文件		
		String resource = "SqlMapConfig.xml";
		//得到配置文件流
		InputStream inputStream=Resources.getResourceAsStream(resource);
		//创建会话工厂,传入mybatis的配置文件信息
		sqlSessionFactory= new SqlSessionFactoryBuilder().build(inputStream);
		
	}
	@Test
	public void testFindUserById() throws Exception {
		//创建UserDao对象
		UserDao userDao = new UserDaoImpl(sqlSessionFactory);
		//调用UserDao的方法
		User user=userDao.findUserById(1);
		System.out.println(user);
		
	}	
	@Test
	public void testinsertUser() throws Exception {
		//创建UserDao对象
		UserDao userDao = new UserDaoImpl(sqlSessionFactory);
		//创建user对象
		User user=new User();
		user.setUsername("XiaoHua");
		user.setBirthday(new Date());
		user.setSex("1");
		user.setAddress("JP");
		//调用UserDao的方法
		userDao.insertUser(user);		
	}
	@Test
	public void testdeleteUser() throws Exception {
		//创建UserDao对象
		UserDao userDao = new UserDaoImpl(sqlSessionFactory);
		//调用UserDao的方法
		userDao.deleteUser(3);		
	}
}
