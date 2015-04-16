package cn.com.aidaban.presenter;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import cn.com.aidaban.BuildConfig;
import cn.com.aidaban.R;
import cn.com.aidaban.common.BaseBitmapFactory;
import cn.com.aidaban.model.UserInfoModel;
import cn.com.aidaban.presenter.modelinterface.UserInfoModelInterface;
import cn.com.aidaban.presenter.viewinterface.NavigationDrawerViewInterface;

/**
 * 左侧滑动手抽屉栏 主导器
 * @author jie
 *
 */
public class NavigationDrawerPresenter implements OnClickListener
{
	private  final String LOG_TAG = "NavigationDrawerPresenter";
	
	private Context mContext;
	private NavigationDrawerViewInterface mViewInterface;
	private UserInfoModelInterface mModelInterface;
	private boolean isLogin;//是否已经登录
	
	
	public NavigationDrawerPresenter(Context context, NavigationDrawerViewInterface navigationDrawerViewInterface)
	{
		this.mContext = context;
		this.mViewInterface = navigationDrawerViewInterface;
		this.mModelInterface = new UserInfoModel(context);
		this.init();
	}
	
	/**
	 * 初始化
	 * 设置登录控件的图片，
	 * 如果用户未登录，使用默认图片,并设置点击事件为跳转登录页{@link #onClick(View)}
	 * 如果用户已登录，使用自定义头像。
	 */
	private void init()
	{
		//先判定用户是否已经登录过
		if(UserInfoModelInterface.LOGIN_STATUS_IN == this.mModelInterface.getLoginStatus())
		{
			//直接设置头像
			new AsyncTask(){
				@Override
				protected Object doInBackground(Object... params)
				{
					mViewInterface.setLoginImageViewForBitmap(
							BaseBitmapFactory.createBitmapByURL(
									mModelInterface.getLoginUserHeadImageRUL()));
					return null;
				}
			}.execute(10);
			
			//设置"点击登录"的textview为空白字符
			this.mViewInterface.setLoginTextViewForText("");
		}
		else
		{
			if(BuildConfig.DEBUG)Log.d(LOG_TAG, "setLoginTextViewOnClickListener");
			//设置登录控件点击事件为跳转登录界面
			this.mViewInterface.setLoginTextViewOnClickListener(this);
		}
		
	}

	@Override
	public void onClick(View v)
	{
		if(BuildConfig.DEBUG)Log.d(LOG_TAG, "onClick");
		switch (v.getId())
		{
			case R.id.drawer_login_textview:
				if(BuildConfig.DEBUG)Log.d(LOG_TAG, "toLoginActivity");
				this.mViewInterface.toLoginActivity();//跳转登录页
				break;
			
			default:
				break;
		}
		
	}
	
}
