package cn.com.aidaban.presenter.modelinterface;

import cn.com.aidaban.model.bean.UserBean;

/**
 * 用户登录信息的数据接口
 * 包括验证用户登录状态，
 * 进行用户登录，
 * 注销登录等功能。
 * @author jie
 * 
 */
public interface UserInfoModelInterface
{
	//登录状态，未登录
	public static final  int LOGIN_STATUS_NOT = 1;
	//登录状态，已超时
	public static final  int LOGIN_STATUS_TIMEOUT = 2;
	//登录状态，已登录
	public static final  int LOGIN_STATUS_IN = 3;
	//在保存用户登录信息到本地资源时，使用该字段名
	public static final String LOGIN_USERBEAN = "LOGIN_USERBEAN";
	
	
	/**
	 * 获取当前登录状态，查看是否已经有成功登录的用户
	 * 程序先从本地资源中获取 {@link UserInfoModelInterface#LOGIN_USERBEAN}这个字段名所保存的资源,
	 * 然后发送到服务器进行验证。
	 * @return LOGIN_STATUS 状态码
	 * 
	 * @see #LOGIN_STATUS_NOT
	 * @see #LOGIN_STATUS_TIMEOUT
	 * @see #LOGIN_STATUS_IN
	 */
	public int getLoginStatus();
	
	/**
	 * 登录，把用户名和密码发送到服务端进行验证，
	 * 如果成功，则会把完整的用户信息保存在本地资源的 {@link UserInfoModelInterface#LOGIN_USERBEAN}属性中
	 * @param userBean
	 * 								userBean,内必须包含非空的userName和userPassword
	 * @return UserBean 
	 * 								如果验证失败，直接返回null
	 * 								如果验证成功，返回完整的用户信息对像
	 * 
	 * @see LOGIN_USERBEAN
	 */
	public UserBean login(UserBean userBean);
	
	/**
	 * 获取已经登录的用户的头像路径
	 * @return
	 */
	public String getLoginUserHeadImageRUL();
}
