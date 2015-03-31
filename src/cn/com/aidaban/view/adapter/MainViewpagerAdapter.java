package cn.com.aidaban.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import cn.com.aidaban.view.ViewpagerChoiceFragment;
import cn.com.aidaban.view.ViewpagerTodayFragment;
/**
 * Viewpeger适配器
 * 负责生产 精选 和 今日 两个主要界面的fragment对象
 * @author jie
 *
 */
public class MainViewpagerAdapter extends FragmentPagerAdapter
{
	
	public MainViewpagerAdapter(FragmentManager fm)
	{
		super(fm);
	}
	
	@Override
	public Fragment getItem(int arg0)
	{
		switch (arg0)
		{
			case 0: //第一页是精选 页
				return new ViewpagerChoiceFragment();
			case 1://第二页是今天 页
				return new ViewpagerTodayFragment();
			default:
				return null;
		}
	}
	
	@Override
	public int getCount()
	{
		//页数，目前只有两页
		return 2;
	}
	
}
