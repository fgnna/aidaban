package cn.com.aidaban.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import cn.com.aidaban.R;
import cn.com.aidaban.model.bean.UserBean;
import cn.com.aidaban.presenter.LoginPresenter;
import cn.com.aidaban.presenter.viewinterface.LoginViewInterface;

public class LoginActivity extends Activity implements LoginViewInterface
{
	private final String LOG_TAG = "LoginActivity";
	
	private LoginPresenter mLoginPresenter;
	private Button mLoginButton;
	private EditText mUserNameEditText;
	private EditText mPasswordEditText;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		getActionBar().setDisplayHomeAsUpEnabled(true);//开启返回键
		
		mLoginButton = (Button) findViewById(R.id.login_button);
		mUserNameEditText = (EditText) findViewById(R.id.login_textview_username);
		mPasswordEditText = (EditText) findViewById(R.id.login_textview_password);
		
		mLoginPresenter = new LoginPresenter(this,this);
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
	public void setLoginButtonOnClickListener(OnClickListener onClickListener)
	{
		mLoginButton.setOnClickListener(onClickListener);
	}

	@Override
	public UserBean getUserInput()
	{
		
		return new UserBean(
										mUserNameEditText.getText().toString(),
										mPasswordEditText.getText().toString());
	}

	@Override
	public void toastMessage(String message)
	{
		Toast.makeText(getApplicationContext(), message,
			     Toast.LENGTH_SHORT).show();
	}

	@Override
	public void returnMainActiviy()
	{
		this.setResult(1);
		this.finish();
	}
}
