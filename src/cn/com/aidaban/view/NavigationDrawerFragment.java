package cn.com.aidaban.view;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import cn.com.aidaban.BuildConfig;
import cn.com.aidaban.R;
import cn.com.aidaban.presenter.NavigationDrawerPresenter;
import cn.com.aidaban.presenter.viewinterface.NavigationDrawerViewInterface;

/**
 * 抽屉导航管理类
 * @author jie
 */
public class NavigationDrawerFragment extends Fragment implements NavigationDrawerViewInterface
{
	private static final String LOG_TAG = "NavigationDrawerFragment";
	/**
	 * 用于缓存当前选中项的标记字段
	 */
	private static final String STATE_SELECTED_POSITION = "selected_navigation_drawer_position";
	
	/**
	 * 第一次使用APP的标记字段
	 */
	private static final String PREF_USER_LEARNED_DRAWER = "navigation_drawer_learned";
	
	/**
	 * 抽屉组件的辅助组件，用于捆绑动作行为。
	 * 就是抽屉的开关事件
	 */
	private ActionBarDrawerToggle mDrawerToggle;
	
	private ImageView mLoginImageView;
	private DrawerLayout mDrawerLayout;
	private View mFragmentContainerView;
	private TextView mLoginTextView;
	
	private int mCurrentSelectedPosition = 0;
	private boolean mFromSavedInstanceState;
	private boolean mUserLearnedDrawer;
	
	private NavigationDrawerPresenter mNavigationDrawerPresenter;
	private  Handler handler = new Handler();
	
	public NavigationDrawerFragment()
	{
	}
	
	/**
	 * 这里只做一件事
	 * 判断用户是否第一次使用APP，并使用持久化标记。
	 */
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		
		// Read in the flag indicating whether or not the user has demonstrated
		// awareness of the
		// drawer. See PREF_USER_LEARNED_DRAWER for details.
		SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getActivity());
		mUserLearnedDrawer = sp.getBoolean(PREF_USER_LEARNED_DRAWER, false);
		
		if (savedInstanceState != null)
		{
			mCurrentSelectedPosition = savedInstanceState.getInt(STATE_SELECTED_POSITION);
			mFromSavedInstanceState = true;
		}
	
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);
		// Indicate that this fragment would like to influence the set of
		// actions in the action bar.
		setHasOptionsMenu(true);
	}
	
	/**
	 * 创建ListView列表
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		
		View rootView = inflater.inflate(R.layout.navigation_drawer_main, container, false);
		mLoginTextView = (TextView) rootView.findViewById(R.id.drawer_login_textview);
		mLoginImageView = (ImageView) rootView.findViewById(R.id.drawer_login_imageview);
		//主导器
		mNavigationDrawerPresenter = new NavigationDrawerPresenter(getActivity(), this);
		return rootView;
	}
	
	/**
	 * 判断抽屉是否打开
	 * @return boolean 是否已经打开
	 */
	public boolean isDrawerOpen()
	{
		return mDrawerLayout != null && mDrawerLayout.isDrawerOpen(mFragmentContainerView);
	}
	
	/**
	 * 此方法用于设置抽屉导航的布局方式
	 * 使用抽屉的用户在初始化时必须调用此方法完成设置
	 * 
	 * @param fragmentId
	 *            抽屉导航栏的ID，
	 * @param drawerLayout
	 *            DrawerLayout（抽屉布局）的UI对象实例
	 */
	public void setUp(int fragmentId, DrawerLayout drawerLayout)
	{
		//缓存实例对象，以备其它方法使用
		mFragmentContainerView = getActivity().findViewById(fragmentId);
		mDrawerLayout = drawerLayout;
		
		
		// 设置在抽屉打开时间，使用一个自定义的阴影层覆盖主内容
		mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);
		
		//设置抽屉选项列表的点击事件
		//TODO ?这里没有处理？
		
		ActionBar actionBar = getActionBar();
		//开启ActionBar的左上角为可点击,该选项在android4.0以后版本默认为false
		actionBar.setDisplayHomeAsUpEnabled(true);
		//这个是必须和setDisplayHomeAsUpEnabled搭配使用的
		//参考URL : http://blog.csdn.net/lovexieyuan520/article/details/9974929
		actionBar.setHomeButtonEnabled(true);
		

		// 设置在抽屉开启和关闭时的监听事件
		//同时包含左上角标提文字和图标的切换动画处理。
		mDrawerToggle = new ActionBarDrawerToggle(
								getActivity(), /* host Activity */
								mDrawerLayout, /* DrawerLayout object */
								R.drawable.ic_drawer, /* nav drawer image to replace 'Up' caret */
								R.string.navigation_drawer_open, /* "open drawer" description for accessibility */
								R.string.navigation_drawer_close /*   "close drawer" description for accessibility  */
						)
						{
							@Override
							public void onDrawerClosed(View drawerView)
							{
								if(BuildConfig.DEBUG)
									Log.d(LOG_TAG,"onDrawerClosed");
								getActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
								super.onDrawerClosed(drawerView);
					
							}
							
							@Override
							public void onDrawerOpened(View drawerView)
							{
								if(BuildConfig.DEBUG)
									Log.d(LOG_TAG,"onDrawerOpened");
								getActionBar().setNavigationMode(ActionBar.DISPLAY_HOME_AS_UP);
								
								super.onDrawerOpened(drawerView);
								//片段是否已经移除，用途暂不明
								if (!isAdded()) { return; }
								
								/**
								 * 这个是用于标记用户已经不是第一次使用抽屉模式，下次打开APP的时候不再会自动打开（用户抽屉学习），可查看{@link #onCreate}
								 */
								if (!mUserLearnedDrawer)
								{
									mUserLearnedDrawer = true;
									SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getActivity());
									sp.edit().putBoolean(PREF_USER_LEARNED_DRAWER, true).apply();
								}
							}
						};
		
		//首次使用，自动打开抽屉
		if (!mUserLearnedDrawer && !mFromSavedInstanceState)
		{
			mDrawerLayout.openDrawer(mFragmentContainerView);
		}
		
		// 延迟状态同步,参考URL:http://blog.csdn.net/jjwwmlp456/article/details/41206513
		mDrawerLayout.post(new Runnable()
		{
			@Override
			public void run()
			{
				mDrawerToggle.syncState();
			}
		});
		
		//开关监听
		mDrawerLayout.setDrawerListener(mDrawerToggle);
	}
	
	
	/**
	 * 初始化导航栏时触发
	 * 这是在生命周中的第一步
	 * 在这之后是{@link #onCreate}}
	 */
	@Override
	public void onAttach(Activity activity)
	{
		if(BuildConfig.DEBUG)
			Log.d(LOG_TAG,"onAttach");
		
		super.onAttach(activity);
		try
		{
			//mCallbacks = (NavigationDrawerCallbacks) activity;
		} catch (ClassCastException e)
		{
			throw new ClassCastException("Activity must implement NavigationDrawerCallbacks.");
		}
	}
	
	/**
	 * 当这个Fragment布局被移除时触发
	 * 用于清理销毁前清理
	 * 在抽屉关闭时也会触发这个
	 */
	@Override
	public void onDetach()
	{
		if(BuildConfig.DEBUG)
			Log.d(LOG_TAG,"onDetach");
		super.onDetach();
	}
	
	/**
	 * activity切换时的状态保存方法，
	 * 参考 : http://blog.csdn.net/yuzhiboyi/article/details/7677026
	 */
	@Override
	public void onSaveInstanceState(Bundle outState)
	{
		super.onSaveInstanceState(outState);
		outState.putInt(STATE_SELECTED_POSITION, mCurrentSelectedPosition);
	}
	
	/**
	 * 当android的配置被改变时，会触发这方法，有可能重启activity
	 * 当配置被改变时，要同通知DrawerToggle进行调整
	 */
	@Override
	public void onConfigurationChanged(Configuration newConfig)
	{
		super.onConfigurationChanged(newConfig);
		// Forward the new configuration the drawer toggle component.
		mDrawerToggle.onConfigurationChanged(newConfig);
	}
	
	/**
	 *  左上角UP键点击事件
	 *  弹出和关闭抽屉
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		if(BuildConfig.DEBUG)
			Log.d(LOG_TAG,"onOptionsItemSelected");
		
		//如果点击的是HOME键，先隐藏tab栏
		if (item.getItemId() == android.R.id.home)
		{
			getActionBar().setNavigationMode(ActionBar.DISPLAY_HOME_AS_UP);
		}
		
		
		if (mDrawerToggle.onOptionsItemSelected(item))
		{
			return true;
		}
		
		
		if (item.getItemId() == R.id.action_example)
		{
			Toast.makeText(getActivity(), "Example action.", Toast.LENGTH_SHORT).show();
			return true;
		}
		
		return super.onOptionsItemSelected(item);
	}
	
	private ActionBar getActionBar()
	{
		return getActivity().getActionBar();
	}
	
	/**
	 * 登录成功后由{@link MainActivity#onActivityResult(int, int, Intent)}回调，刷新登录信息
	 * 
	 * @see MainActivity#onActivityResult
	 */
	public void loginSuccess()
	{
		//重新建立主导器达到初始化的目的
		mNavigationDrawerPresenter = new NavigationDrawerPresenter(getActivity(), this);
	}
	
	/******************************************************************************************
	 * 下面所有方法为主导器接口实现
	 ******************************************************************************************/

	@Override
	public void setLoginTextViewOnClickListener(OnClickListener onClickListener)
	{
		mLoginTextView.setOnClickListener(onClickListener);
	}

	@Override
	public void setLoginTextViewForText(String text)
	{
		mLoginTextView.setText(text);
	}

	@Override
	public void setLoginImageViewForBitmap(final Bitmap image)
	{
		this.handler.post(new Runnable()
		{
			@Override
			public void run()
			{
				mLoginImageView.setImageBitmap(image);
			}
		});
		
	}

	@Override
	public void toLoginActivity()
	{
		//跳转登录页
		Intent toLoginViewIntent = new Intent(getActivity(),LoginActivity.class);  
		getActivity().startActivityForResult(toLoginViewIntent, 1);
	}

	
}
