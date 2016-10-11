package cn.itcast.mybatis.dao;

import java.util.List;

import cn.itcast.mybatis.po.User;

/**
 * <p>Title: UserDao</p>
 * <p>Description: dao接口，用户管理 </p>
 * @author ChenAmber
 * @date 2016-10-7
 * @version 1.0
 */
public interface UserDao {
	
	//根据ID查询用户信息
	public User findUserById(int id) throws Exception;
	
	//根据名称查询用户信息
	public List<User> findUserByName(String username) throws Exception;
	
	//添加用户信息
	public void insertUser(User user) throws Exception;
	
	//删除用户信息
	public void deleteUser(int id) throws Exception;
}
