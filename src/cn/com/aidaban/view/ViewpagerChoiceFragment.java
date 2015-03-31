package cn.com.aidaban.view;

import cn.com.aidaban.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/**
 * 精选页
 * @author jie
 *
 */
public class ViewpagerChoiceFragment extends Fragment
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
		View rootView = inflater.inflate(R.layout.fragment_viewpager, container, false);
		
		return rootView;
	}
}
