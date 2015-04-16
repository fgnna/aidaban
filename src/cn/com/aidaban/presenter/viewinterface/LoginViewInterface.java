package cn.com.aidaban.presenter.viewinterface;

import cn.com.aidaban.model.bean.UserBean;
import android.view.View.OnClickListener;

/**
 * 登录 视图控制接口
 * @author jie
 *
 */
public interface LoginViewInterface
{

	/**
	 * 设置登录按钮的点击监听事件
	 * @param onClickListener
	 */
	public void setLoginButtonOnClickListener(OnClickListener onClickListener);

	/**
	 * 获取用户的输入信息,并以{@link UserBean}实体的形式返回
	 * 以下字段不能为空: 
	 * 							userName,userPassword
	 * @return UserBean
	 */
	public UserBean getUserInput();

	/**
	 * 在屏幕上使用toast提供信息
	 * @param string
	 */
	public void toastMessage(String message);

	/**
	 * 登录完成，重新返回{@link cn.com.aidaban.view.MainActivity}
	 * 并确保{@link cn.com.aidaban.view.NavigationDrawerFragment}刷新登录信息
	 */
	public void returnMainActiviy();
	
}
