package cn.com.aidaban.view;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import cn.com.aidaban.BuildConfig;
import cn.com.aidaban.R;
import cn.com.aidaban.view.adapter.MainViewpagerAdapter;
/**
 * APP主入口
 * 这里主要负责实现抽屉栏和开启 精选，今日  这个Viewpeger功能的实例化，详细请看{@link #onCreate(Bundle)}}
 * @author jie
 *
 */
public class MainActivity extends FragmentActivity 
{
	private static final String LOG_TAG = "MainActivity";
	
	
	/**
	 * Fragment managing the behaviors, interactions and presentation of the
	 * navigation drawer.
	 */
	private NavigationDrawerFragment mNavigationDrawerFragment;
	
	private ViewPager mViewPager ;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		//主界面布局包括Viewpager和NavigationDrawer两个。
		setContentView(R.layout.activity_main);
		//删除背景，优性性能
		getWindow().setBackgroundDrawable(null);
		
		mNavigationDrawerFragment = (NavigationDrawerFragment) getFragmentManager().findFragmentById(R.id.navigation_drawer);
		
		// Set up the drawer.
		mNavigationDrawerFragment.setUp(R.id.navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout));
		
		mViewPager =  (ViewPager) findViewById(R.id.viewpager);
		mViewPager.setAdapter(new MainViewpagerAdapter(getSupportFragmentManager()) );
		initViewpagerTitel();
		
	}
	
	/**
	 * 初始化Tab的标题：精选，今日
	 */
	private void initViewpagerTitel()
	{
		final ActionBar actionBar = getActionBar();
		 // Specify that tabs should be displayed in the action bar.
	    actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

	    // Create a tab listener that is called when the user changes tabs.
	    ActionBar.TabListener tabListener = new ActionBar.TabListener() {
	        public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
	        	mViewPager.setCurrentItem(tab.getPosition());
	        }

	        public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
	            // hide the given tab
	        }

	        public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {
	            // probably ignore this event
	        }
	    };

	    
	    
	    
	    // Add 3 tabs, specifying the tab's text and TabListener
	        actionBar.addTab( actionBar.newTab() .setText(R.string.title_tab1) .setTabListener(tabListener));
	        actionBar.addTab( actionBar.newTab() .setText(R.string.title_tab2) .setTabListener(tabListener));
		
	    mViewPager.setOnPageChangeListener(
	            new ViewPager.SimpleOnPageChangeListener() {
	                @Override
	                public void onPageSelected(int position) {
	                    // When swiping between pages, select the
	                    // corresponding tab.
	                	actionBar.setSelectedNavigationItem(position);
	                }
	            });
		
	}
	


	/**
	 *在开关抽屉的过程中触发的事件
	 *
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		if(BuildConfig.DEBUG)
			Log.d(LOG_TAG, "onCreateOptionsMenu");
		if (!mNavigationDrawerFragment.isDrawerOpen())
		{
			// getActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
			return true;
		}
		return super.onCreateOptionsMenu(menu);
	}
	
	/**
	 * 用户通过点击侧滑侧的登录按钮跳转到登录界面，
	 * 当发生onActivityResult事件，即表示登录成功并返回，
	 * 当返回后{@link NavigationDrawerFragment}需要重新刷新登录信息
	 */
	@Override
	protected void onActivityResult(int arg0, int arg1, Intent arg2)
	{
		super.onActivityResult(arg0, arg1, arg2);
		if(BuildConfig.DEBUG) Log.d(LOG_TAG,"登录完成");
		this.mNavigationDrawerFragment.loginSuccess();
	}
}
