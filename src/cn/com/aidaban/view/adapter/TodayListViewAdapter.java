package cn.com.aidaban.view.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import cn.com.aidaban.BuildConfig;
import cn.com.aidaban.R;
import cn.com.aidaban.common.BaseBitmapFactory;
import cn.com.aidaban.model.bean.SubjectBean;

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
	
	private TodayListViewAdapter()
	{
	}
	
	/**
	 * 唯一构造方法
	 * 
	 * @param context
	 * @param dataList
	 *            这里的传入数据限定为 {@link SubjectBean} 的集合
	 */
	public TodayListViewAdapter(Context context, List<SubjectBean> dataList)
	{
		this.mContext = context;
		this.mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		this.mDataList = dataList;
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
