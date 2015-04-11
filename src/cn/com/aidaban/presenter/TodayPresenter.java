package cn.com.aidaban.presenter;

import android.content.Context;
import android.os.AsyncTask;
import cn.com.aidaban.model.TodayModel;
import cn.com.aidaban.presenter.modelinterface.TodayModelInterface;
import cn.com.aidaban.presenter.viewinterface.TodayViewInterface;
/**
 * 精彩页 的业务主导器
 * 负责数据业务逻辑的调用
 * 应用MVP模式
 * @author jie
 *
 */
public class TodayPresenter 
{
	private Context mContext;
	private TodayViewInterface mTodayViewInterface;
	private TodayModelInterface mTodayModelInterface;
	
	public TodayPresenter(Context context,TodayViewInterface todayViewInterface )
	{
		this.mContext = context;
		this.mTodayViewInterface = todayViewInterface;
		this.mTodayModelInterface = new TodayModel();
		this.init();
	}
	
	//初始化步骤
	private void init()
	{
		new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				mTodayViewInterface.initPageData( mTodayModelInterface.getInitPageData(mContext) );				
			}
		}).start();
	}
	
}
