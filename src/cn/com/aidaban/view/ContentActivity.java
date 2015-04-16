package cn.com.aidaban.view;

import cn.com.aidaban.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;

public class ContentActivity extends Activity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_content);
		getActionBar().setDisplayHomeAsUpEnabled(true);//开启返回键
		
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
}
