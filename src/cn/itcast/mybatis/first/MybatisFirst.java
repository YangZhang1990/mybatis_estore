package cn.itcast.mybatis.first;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.itcast.mybatis.po.User;

/**
 * <p>Title: MybatisFirstr</p>
 * <p>Description: 入门程序 </p>
 * @author ChenAmber
 * @date 2016-10-4
 * @version 1.0
 */
public class MybatisFirst {

	//根据id查询用户信息，得到一条记录结果
	@Test
	public void findUserByIdTest() throws IOException{
		//mybatis配置文件		
		String resource = "SqlMapConfig.xml";
		//得到配置文件流
		InputStream inputStream=Resources.getResourceAsStream(resource);
		//创建会话工厂,传入mybatis的配置文件信息
		SqlSessionFactory sqlSessionFactory= new SqlSessionFactoryBuilder().build(inputStream);
		//通过工厂得到sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//通过SqlSession操作数据库
		//第一个参数：映射文件中statement的id,等于=namespace+statement的id
		//第二个参数：指定和映射文件中所匹配的parameterType类型的参数
		//sqlSession.selectOne结果是与映射文件中所匹配的resultType类型的对象		
		User user = sqlSession.selectOne("test.findUserById", 1);		
		System.out.println(user);
		//释放资源
		sqlSession.close();
	}
	
	//根据用户名称来模糊查询用户列表
	@Test
	public void findUserByNameTest() throws IOException{
		//mybatis配置文件		
		String resource = "SqlMapConfig.xml";
		//得到配置文件流
		InputStream inputStream=Resources.getResourceAsStream(resource);
		//创建会话工厂,传入mybatis的配置文件信息
		SqlSessionFactory sqlSessionFactory= new SqlSessionFactoryBuilder().build(inputStream);
		//通过工厂得到sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//通过SqlSession操作数据库
		//第一个参数：映射文件中statement的id,等于=namespace+statement的id
		//第二个参数：指定和映射文件中所匹配的parameterType类型的参数
		//sqlSession.selectList结果是与映射文件中所匹配的resultType类型的对象		
		List<User> userlist = sqlSession.selectList("test.findUserByName", "Ja");		
		System.out.println(userlist);
		//释放资源
		sqlSession.close();
	}
	
	//添加用户信息
	@Test
	public void insertUserTest() throws IOException{
		//mybatis配置文件		
		String resource = "SqlMapConfig.xml";
		//得到配置文件流
		InputStream inputStream=Resources.getResourceAsStream(resource);
		//创建会话工厂,传入mybatis的配置文件信息
		SqlSessionFactory sqlSessionFactory= new SqlSessionFactoryBuilder().build(inputStream);
		//通过工厂得到sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//通过SqlSession操作数据库
		//第一个参数：映射文件中statement的id,等于=namespace+statement的id
		//第二个参数：指定和映射文件中所匹配的parameterType类型的参数
		//插入用户对象
		User user=new User();
		user.setUsername("XiaoMing");
		user.setBirthday(new Date());
		user.setSex("1");
		user.setAddress("San Diego");
		
		sqlSession.insert("test.insertUser", user);
		
		//提交事务
		sqlSession.commit();
		
		//获取用户信息主键
		System.out.println(user.getId());
		//释放资源
		sqlSession.close();
	}
	
	//根据id删除用户信息
	@Test
	public void deleteUserTest() throws IOException{
		//mybatis配置文件		
		String resource = "SqlMapConfig.xml";
		//得到配置文件流
		InputStream inputStream=Resources.getResourceAsStream(resource);
		//创建会话工厂,传入mybatis的配置文件信息
		SqlSessionFactory sqlSessionFactory= new SqlSessionFactoryBuilder().build(inputStream);
		//通过工厂得到sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//通过SqlSession操作数据库
		//第一个参数：映射文件中statement的id,等于=namespace+statement的id
		//第二个参数：指定和映射文件中所匹配的parameterType类型的参数
		//传入id,删除用户
		sqlSession.delete("test.deleteUser", 7);		
		//提交事务
		sqlSession.commit();		
		//释放资源
		sqlSession.close();
	}
	
	//根据id更新用户信息
	@Test
	public void updateUserTest() throws IOException{
		//mybatis配置文件		
		String resource = "SqlMapConfig.xml";
		//得到配置文件流
		InputStream inputStream=Resources.getResourceAsStream(resource);
		//创建会话工厂,传入mybatis的配置文件信息
		SqlSessionFactory sqlSessionFactory= new SqlSessionFactoryBuilder().build(inputStream);
		//通过工厂得到sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//通过SqlSession操作数据库
		//第一个参数：映射文件中statement的id,等于=namespace+statement的id
		//第二个参数：指定和映射文件中所匹配的parameterType类型的参数
		//根据用户信息		
		User user=new User();
		//必须设置id
		user.setId(8);
		user.setUsername("Xiaohong");
		user.setBirthday(new Date());
		user.setSex("2");
		user.setAddress("LA");
		sqlSession.update("test.updateUser", user);		
		//提交事务
		sqlSession.commit();		
		//释放资源
		sqlSession.close();
	}
	

}
