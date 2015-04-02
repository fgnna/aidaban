package cn.com.aidaban.view;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import cn.com.aidaban.R;

/**
 * 《今天》页
 * 
 * @author jie
 * 
 */
public class ViewpagerTodayFragment extends Fragment
{
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		// 保证最后两个参数不被参改，即必须这样传参，（这是官方注释的原话，不知道我理解是否正确）
		View rootView = inflater.inflate(R.layout.viewpager_choice, container, false);
		
		return rootView;
	}
}
