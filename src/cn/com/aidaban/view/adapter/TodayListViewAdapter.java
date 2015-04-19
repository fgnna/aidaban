package cn.com.aidaban.view.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import cn.com.aidaban.BuildConfig;
import cn.com.aidaban.R;
import cn.com.aidaban.common.BaseImageFactory;
import cn.com.aidaban.model.bean.SubjectBean;
import cn.com.aidaban.view.ContentActivity;
import cn.com.aidaban.view.adapter.ChoiceListViewAdapter.DataUpdateCallback;

/**
 * 今天页，ListView适配器 负责布局加载，并处理底部二次加载
 * 
 * @author jie
 */
public class TodayListViewAdapter extends BaseAdapter
{
	private static final String LOG_TAG = "TodayListViewAdapter";
	
	// 备用
	private Context mContext;
	// 构建视图时需要用到
	private LayoutInflater mInflater;
	private List<SubjectBean> mDataList;
	
	/**
	 * 统一的跳转点击事件,跳转到全文显示页
	 * 本应用只作学习和展示使用，所以全文内容不作动态变化，统一跳转并显示默认容易
	 * 
	 * @see #TodayListViewAdapter(Context, List)
	 */
	private OnClickListener mItemOnClickListener;
	
	private TodayListViewAdapter()
	{
	}
	
	/**
	 * 唯一构造方法
	 * 
	 * @param context
	 * @param dataList
	 *            这里的传入数据限定为 {@link SubjectBean} 的集合
	 *            
	 * @see #mItemOnClickListener
	 */
	public TodayListViewAdapter(Context context, List<SubjectBean> dataList)
	{
		this.mContext = context;
		this.mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		this.mDataList = dataList;
		
		this.mItemOnClickListener = new OnClickListener()
		{
			
			@Override
			public void onClick(View v)
			{
				//跳转到全文显示页
				Intent toContextViewIntent =  new Intent(mContext,ContentActivity.class); 
				toContextViewIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);  
				mContext.startActivity(toContextViewIntent);
			}
		}; 
	}
	
	@Override
	public int getCount()
	{
		return mDataList.size();
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		View view;
		view = mInflater.inflate(R.layout.viewpager_today_item, parent, false);
		final ImageView mImageView = (ImageView) view.findViewById(R.id.today_imageview);
		mImageView.setImageBitmap(mDataList.get(position).getImage());
		view.setOnClickListener(this.mItemOnClickListener);
		return view;
	}
	
	@Override
	public Object getItem(int position)
	{
		return null;
	}
	
	@Override
	public long getItemId(int position)
	{
		return 0;
	}
}
