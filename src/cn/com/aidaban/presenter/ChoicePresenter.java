package cn.com.aidaban.presenter;

import java.util.List;

import android.content.Context;
import android.os.AsyncTask;
import cn.com.aidaban.model.ChoiceModel;
import cn.com.aidaban.presenter.modelinterface.ChoiceModelInterface;
import cn.com.aidaban.presenter.viewinterface.ChoiceViewInterface;
import cn.com.aidaban.view.adapter.ChoiceListViewAdapter;
/**
 * 精彩页 的业务主导器
 * 负责数据业务逻辑的调用
 * 应用MVP模式
 * @author jie
 *
 */
public class ChoicePresenter implements ChoiceListViewAdapter.DataUpdateCallback
{
	private Context mContext;
	private ChoiceViewInterface mChoiceViewInterface;
	private ChoiceModelInterface mChoiceModelInterface;
	
	public ChoicePresenter(Context context, ChoiceViewInterface choiceViewInterface)
	{
		this.mContext = context;
		this.mChoiceViewInterface = choiceViewInterface;
		this.mChoiceModelInterface = new ChoiceModel();
		this.init();
	}
	
	@SuppressWarnings(value="all")
	//初始化步骤
	private void init()
	{
		new AsyncTask(){
			@Override
			protected Object doInBackground(Object... params)
			{
				//初始化第一页的数据
				mChoiceViewInterface.initPageData( mChoiceModelInterface.getInitPageData(mContext) );
				return null;
			}
		}.execute(10);
	}
	
	/**
	 * ListView拖动到底部后的回调方法
	 * @param 最后一位的下标
	 */
	@Override
	public void notifyLast(final int lastPosition)
	{
		new AsyncTask(){
			@Override
			protected Object doInBackground(Object... params)
			{
				//初始化第一页的数据
				mChoiceViewInterface.updateNextPageData( mChoiceModelInterface.getNextPageData(lastPosition) );
				return null;
			}
		}.execute(10);
	}
}
