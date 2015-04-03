package cn.com.aidaban.presenter;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import cn.com.aidaban.model.ChoiceModel;
import cn.com.aidaban.presenter.modelinterface.ChoiceModelInterface;
import cn.com.aidaban.presenter.viewinterface.ChoiceViewInterface;
/**
 * 精彩页 的业务主导器
 * 负责数据业务逻辑的调用
 * 应用MVP模式
 * @author jie
 *
 */
public class ChoicePresenter
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
			
			
			
		}.execute(100);
		
	}
	
}
