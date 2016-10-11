package cn.itcast.mybatis.po;
/**
 * <p>Title: UserQueryVo</p>
 * <p>Description: 用户包装类型 </p>
 * @author ChenAmber
 * @date 2016-10-7
 * @version 1.0
 */
public class UserQueryVo {
	//在这里包装所需要的查询条件
	//用户查询条件
	private UserCustom userCustom;

	public UserCustom getUserCustom() {
		return userCustom;
	}

	public void setUserCustom(UserCustom userCustom) {
		this.userCustom = userCustom;
	}
	
	//还可以包装其他的查询条件比如订单、商品等
	//....
}
