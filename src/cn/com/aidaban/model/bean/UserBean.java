package cn.com.aidaban.model.bean;
/**
 * 登录用户信息
 * @author jie
 *
 */
public class UserBean
{
	private String userName;
	private String userPassword;
	private String userHeadImageURL;
	private String loginToken;
	
	public String getUserName()
	{
		return userName;
	}
	
	public UserBean(String userName, String userPassword)
	{
		super();
		this.userName = userName;
		this.userPassword = userPassword;
		this.userHeadImageURL = userHeadImageURL;
	}

	
	
	public UserBean(String userName, String userPassword, String userHeadImageURL, String loginToken)
	{
		super();
		this.userName = userName;
		this.userPassword = userPassword;
		this.userHeadImageURL = userHeadImageURL;
		this.loginToken = loginToken;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	public String getUserPassword()
	{
		return userPassword;
	}
	public void setUserPassword(String userPassword)
	{
		this.userPassword = userPassword;
	}
	public String getUserHeadImageURL()
	{
		return userHeadImageURL;
	}
	public void setUserHeadImageURL(String userHeadImageURL)
	{
		this.userHeadImageURL = userHeadImageURL;
	}

	public String getLoginToken()
	{
		return loginToken;
	}

	public void setLoginToken(String loginToken)
	{
		this.loginToken = loginToken;
	}
	
	
	
}
