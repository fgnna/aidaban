package cn.com.aidaban.view;

import java.util.List;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import cn.com.aidaban.R;
import cn.com.aidaban.model.bean.SubjectBean;
import cn.com.aidaban.presenter.ChoicePresenter;
import cn.com.aidaban.presenter.TodayPresenter;
import cn.com.aidaban.presenter.viewinterface.TodayViewInterface;
import cn.com.aidaban.view.adapter.ChoiceListViewAdapter;
import cn.com.aidaban.view.adapter.TodayListViewAdapter;

/**
 * 《今天》页
 * 
 * @author jie
 * 
 */
public class ViewpagerTodayFragment extends Fragment implements TodayViewInterface
{
	
	private ListView mListView;
	private ChoiceListViewAdapter mChoiceListViewAdapter;
	private  Handler handler = new Handler();
	private TodayPresenter mTodayPresenter;
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
		mListView = (ListView) inflater.inflate(R.layout.viewpager_today, container, false);
		this.mTodayPresenter = new TodayPresenter(getActivity().getApplicationContext(),this);
		return mListView;
	}

	@Override
	public void initPageData(final List<SubjectBean> list)
	{
		handler.post(new Runnable() {
			   public void run() {
				   mListView.setAdapter(new TodayListViewAdapter(getActivity().getApplicationContext(),list));	
		   }
	  });
		
	}
}
