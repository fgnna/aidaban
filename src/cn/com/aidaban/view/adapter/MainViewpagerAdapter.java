package cn.com.aidaban.view.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import cn.com.aidaban.view.ViewpagerFragment;

public class MainViewpagerAdapter extends FragmentPagerAdapter
{
	
	public MainViewpagerAdapter(FragmentManager fm)
	{
		super(fm);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Fragment getItem(int arg0)
	{
		ViewpagerFragment mMainViewpagerFragmentnew = new ViewpagerFragment();
		Bundle args = new Bundle();
		args.putInt(ViewpagerFragment.ARG_COUNT_NAME, arg0);
		mMainViewpagerFragmentnew.setArguments(args);
		return mMainViewpagerFragmentnew;
	}
	
	@Override
	public int getCount()
	{
		// TODO Auto-generated method stub
		return 2;
	}
	
}
