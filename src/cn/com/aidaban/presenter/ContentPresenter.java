package cn.com.aidaban.presenter;

import android.content.Context;
import android.os.AsyncTask;
import android.text.Html;
import android.text.Spanned;
import android.text.style.ImageSpan;
import cn.com.aidaban.common.BaseImageFactory;
import cn.com.aidaban.model.ContentModel;
import cn.com.aidaban.presenter.modelinterface.ContentModelInterface;
import cn.com.aidaban.presenter.viewinterface.ContentViewInterface;

/**
 * 内容页 的业务主导器 负责数据业务逻辑的调用 应用MVP模式
 * 
 * @author jie
 * 
 */
public class ContentPresenter
{
	public static final String LOG_TAG = "ContentPresenter" ;
	
	private Context mContext;
	private ContentViewInterface mContentViewInterface;
	private ContentModelInterface mContentModelInterface;
	private ImageSpan[] mHtmlImageSpans;
	
	public ContentPresenter(Context context, ContentViewInterface contentViewInterface)
	{
		this.mContext = context;
		this.mContentViewInterface = contentViewInterface;
		this.mContentModelInterface = new ContentModel(context);
		this.init();
	}
	
	/**
	 *  初始化步骤
	 */
	private void init()
	{
		final String bodyText = mContentModelInterface.getBodyText();
		new AsyncTask()
		{
			@Override
			protected Object doInBackground(Object... params)
			{
				Spanned htmlTextSpanned = Html.fromHtml(
						bodyText,
						BaseImageFactory.createHtmlNetworkImageGetter(),//URL图片处理类
						null);
				//更新文本内容 
				mContentViewInterface.setBodyText(htmlTextSpanned);
				return null;
			}
		}.execute();
	}
	
}
