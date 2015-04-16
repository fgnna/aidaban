package cn.com.aidaban.presenter.viewinterface;

import android.graphics.Bitmap;
import android.view.View.OnClickListener;
/**
 * 侧滑抽屉，view视图的业务调用接口
 * @author jie
 */
public interface NavigationDrawerViewInterface
{

	/**
	 * 设置 登录按钮的点击事件
	 * @param navigationDrawerPresenter 事件对象
	 */
	public void setLoginTextViewOnClickListener(OnClickListener  onClickListener);
	
	/**
	 * 设置 登录按键的文字
	 * @param text 文字内容
	 */
	public void setLoginTextViewForText( String text);
	
	/**
	 * 设置 登录头像的图片
	 * @param image 图片
	 */
	public void setLoginImageViewForBitmap(Bitmap image);
	
	/**
	 * 跳转登录页
	 */
	public void toLoginActivity();
	
}
