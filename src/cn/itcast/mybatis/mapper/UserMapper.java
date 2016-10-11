package cn.itcast.mybatis.mapper;

import java.util.List;

import cn.itcast.mybatis.po.User;
import cn.itcast.mybatis.po.UserCustom;
import cn.itcast.mybatis.po.UserQueryVo;

/**
 * <p>Title: UserMapper</p>
 * <p>Description: mapper接口，相当于dao接口，用户管理 </p>
 * @author ChenAmber
 * @date 2016-10-7
 * @version 1.0
 */
public interface UserMapper {
	
	//用户信息综合查询
	public List<UserCustom> findUserList(UserQueryVo userQueryVo) throws Exception;
	
	//根据ID查询用户信息
	public User findUserById(int id) throws Exception;
		
	//根据名称查询用户列表
	public List<User> findUserByName(String username) throws Exception;

	
	//添加用户信息
	public void insertUser(User user) throws Exception;

	//删除用户信息
	public void deleteUser(int id) throws Exception;

}
