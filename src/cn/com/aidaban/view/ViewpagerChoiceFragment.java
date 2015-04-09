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
import cn.com.aidaban.model.bean.ChoiceBean;
import cn.com.aidaban.presenter.ChoicePresenter;
import cn.com.aidaban.presenter.viewinterface.ChoiceViewInterface;
import cn.com.aidaban.view.adapter.ChoiceListViewAdapter;
/**
 * 精选页 视图
 * @author jie
 *
 */
public class ViewpagerChoiceFragment extends Fragment implements ChoiceViewInterface
{

	private static final String LOG_TAG = "ViewpagerChoiceFragment";
	private ListView mListView;
	private ChoiceListViewAdapter mChoiceListViewAdapter;
	private ChoicePresenter mChoicePresenter;//业务主导器
	
	private  Handler handler = new Handler();
	
 
	
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
		mListView= (ListView) inflater.inflate(R.layout.viewpager_choice, container, false);
		
		this.mChoicePresenter = new ChoicePresenter(getActivity().getApplicationContext(),this);
		
		return mListView;
	}
	
	@Override
	public void initPageData(final List<ChoiceBean> list)
	{
		mChoiceListViewAdapter = new ChoiceListViewAdapter(getActivity().getApplicationContext(),list,mChoicePresenter);
		
		handler.post(new Runnable() {
		    public void run() {
		    	mListView.setAdapter(mChoiceListViewAdapter );
		    }
		  });
	}
	
	@Override
	public void updateNextPageData(final List<ChoiceBean> data)
	{
		handler.post(new Runnable() {
			   public void run() {
		mChoiceListViewAdapter.addNewDatas(data);
		   }
	  });
	}


	
}
