package cn.itcast.mybatis.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import cn.itcast.mybatis.po.User;

/**
 * <p>Title: UserDaoImpl</p>
 * <p>Description: dao接口实现类 </p>
 * @author ChenAmber
 * @date 2016-10-7
 * @version 1.0
 */
public class UserDaoImpl implements UserDao{
	//需要向dao实现类注入SqlSessionFactory
	//这里通过构造函数注入
	private SqlSessionFactory sqlSessionFactory;
	public UserDaoImpl(SqlSessionFactory sqlSessionFactory){
		this.sqlSessionFactory=sqlSessionFactory;
	}
	
	@Override
	public User findUserById(int id) throws Exception {
		SqlSession sqlSession=sqlSessionFactory.openSession();	
		User user=sqlSession.selectOne("test.findUserById", id);		
		sqlSession.close();
		return user;
	}
	
	@Override
	public List<User> findUserByName(String username) throws Exception {
		SqlSession sqlSession=sqlSessionFactory.openSession();	
		List<User> userList=sqlSession.selectList("test.findUserByName", username);		
		sqlSession.close();
		return userList;
	}

	@Override
	public void insertUser(User user) throws Exception {
		SqlSession sqlSession=sqlSessionFactory.openSession();	
		//执行插入操作
		sqlSession.insert("test.insertUser", user);		
		//提交事务
		sqlSession.commit();
		//释放资源
		sqlSession.close();
		
	}

	@Override
	public void deleteUser(int id) throws Exception {
		SqlSession sqlSession=sqlSessionFactory.openSession();	
		//执行插入操作
		sqlSession.delete("test.deleteUser", id);	
		//提交事务
		sqlSession.commit();
		//释放资源
		sqlSession.close();
	}



}
