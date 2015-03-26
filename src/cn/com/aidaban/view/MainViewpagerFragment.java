package cn.com.aidaban.view;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import cn.com.aidaban.R;
import cn.com.aidaban.view.adapter.MainViewpagerAdapter;

public class MainViewpagerFragment extends Fragment
{
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		//getActivity().gets
		
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		ViewPager mViewPager =  (ViewPager) inflater.inflate(R.layout.pager,container, false);
		mViewPager.setAdapter(new MainViewpagerAdapter( ((FragmentActivity)getActivity()).getSupportFragmentManager()) );
		return mViewPager;
	}
}
