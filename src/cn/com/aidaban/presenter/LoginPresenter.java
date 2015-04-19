package cn.com.aidaban.presenter;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import cn.com.aidaban.R;
import cn.com.aidaban.common.BaseImageFactory;
import cn.com.aidaban.model.UserInfoModel;
import cn.com.aidaban.model.bean.UserBean;
import cn.com.aidaban.presenter.modelinterface.UserInfoModelInterface;
import cn.com.aidaban.presenter.viewinterface.LoginViewInterface;

/**
 * 登录界面 主导器
 * @author jie
 *
 */
public class LoginPresenter implements OnClickListener
{
	private  final String LOG_TAG = "LoginPresenter";
	
	private Context mContext;
	private LoginViewInterface mLoginViewInterface;
	private UserInfoModelInterface mModelInterface;
	
	public LoginPresenter(Context context, LoginViewInterface loginViewInterface)
	{
		this.mContext = context;
		this.mLoginViewInterface = loginViewInterface;
		this.mModelInterface = new UserInfoModel(context);
		this.init();
	}
	
	/**
	 * 初始化
	 * 设置登录按钮的点击事件
	 */
	private void init()
	{
		this.mLoginViewInterface.setLoginButtonOnClickListener(this);
	}

	@Override
	public void onClick(View v)
	{
		switch (v.getId())
		{
			case R.id.login_button:
				this.LoginButtonOnClick();
				break;
			
			default:
				break;
		}
	}
	
	/**
	 * 登录按钮点击事件处理
	 */
	private void LoginButtonOnClick()
	{
		UserBean user = this.mLoginViewInterface.getUserInput();
		user = mModelInterface.login(user);
		if(null != user)
		{
			this.mLoginViewInterface.returnMainActiviy();
		}
		else
		{
			 this.mLoginViewInterface.toastMessage("用户名密码不能为空");
		}
	}
	
}
