package cn.com.aidaban.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import cn.com.aidaban.model.bean.UserBean;
import cn.com.aidaban.presenter.modelinterface.UserInfoModelInterface;

/**
 * 用户信息 模型
 * {@link UserInfoModelInterface}的实现类
 * @see UserInfoModelInterface
 * @author jie
 * 
 */
public class UserInfoModel implements UserInfoModelInterface
{
	private Context mContext;
	private SharedPreferences mPreferences;
	
	public UserInfoModel(Context context)
	{
		this.mContext = context;
		//获取偏好设置，私有模式
		mPreferences = context.getSharedPreferences(LOGIN_USERBEAN, Context.MODE_PRIVATE);
	}
 
	@Override
	public int getLoginStatus()
	{
		if( "".equals(mPreferences.getString("loginToken","")))
				return LOGIN_STATUS_NOT;
		else
				return LOGIN_STATUS_IN;
	}
	@Override
	public UserBean login(UserBean userBean)
	{
		/**
		 *模似数据，不会真正的请求后台处理
		 */
		if(null == userBean) return null;
		if(null == userBean.getUserName() || "".equals(userBean.getUserName())) return null;
		
		userBean.setLoginToken("111111111111111111111");
		userBean.setUserHeadImageURL("http://img2.100bt.com/upload/ttq/20120829/1346214267340.jpg");
		
		Editor editor = mPreferences.edit();
		editor.putString("userName", userBean.getUserName());
		editor.putString("userHeadImageURL", userBean.getUserHeadImageURL());
		editor.putString("loginToken", userBean.getLoginToken());
		editor.apply();
		
		return userBean;
	}

	@Override
	public String getLoginUserHeadImageRUL()
	{
		// TODO Auto-generated method stub
		return mPreferences.getString("userHeadImageURL","");
	}

}
