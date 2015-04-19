package cn.com.aidaban.view;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Handler;
import android.text.Spanned;
import android.text.style.ImageSpan;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;
import cn.com.aidaban.BuildConfig;
import cn.com.aidaban.R;
import cn.com.aidaban.presenter.ContentPresenter;
import cn.com.aidaban.presenter.viewinterface.ContentViewInterface;

/**
 * 详细内容页 功能：1.显示主题详细内容 2.收藏主题 3.评论(该部份暂未实现) 2015.04.17
 * 
 * @author jie
 * 
 */
public class ContentActivity extends Activity implements ContentViewInterface
{
	public static final String LOG_TAG = "ContentActivity" ;
	
	private Handler mHandler = new Handler();
	private ContentPresenter mContentPresenter;
	//内容区
	private TextView mContentBodyTextView;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_content);
		getActionBar().setDisplayHomeAsUpEnabled(true);// 开启返回键
		mContentBodyTextView = (TextView) findViewById(R.id.content_bodyText);
		mContentPresenter = new ContentPresenter(this,this);
		
	}
	
	/**
	 * 监听左上角返回按钮事件
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		// TODO Auto-generated method stub
		if (item.getItemId() == android.R.id.home)
		{
			finish();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/******************************************************************************************
	 * 下面所有方法为主导器接口实现
	 ******************************************************************************************/
	@Override
	public void setBodyText(final Spanned bodyText)
	{
		mHandler.post(new Runnable()
		{
			@Override
			public void run()
			{
				if(BuildConfig.DEBUG) Log.d(LOG_TAG,""+bodyText);
				mContentBodyTextView.setText(bodyText);
			}
		});
	
	}

}
