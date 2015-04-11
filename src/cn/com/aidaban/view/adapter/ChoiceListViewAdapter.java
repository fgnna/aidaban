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
 * 精彩页，ListView适配器
 * 负责布局加载，并处理底部二次加载
 * @author jie
 */
public class ChoiceListViewAdapter extends BaseAdapter
{
	private static final String LOG_TAG = "ChoiceListViewAdapter";
	
	/**
	 * 户用传入原视图数据集 但由于第二行开始，视图是一行展视两个数据，即两张图片，布局可查看
	 * R.layout.viewpager_choice_body 所以需要先对数据集进行分类，
	 * {@link #groupByDataList(List)} mHeadData 第一个视图，第一行为单个图片信息，所以单独存起
	 * mDataListLeft 左视图， mDataListRight 右视图
	 */
	private SubjectBean mHeadData;
	private List<SubjectBean> mDataListLeft = new ArrayList<SubjectBean>();
	private List<SubjectBean> mDataListRight = new ArrayList<SubjectBean>();
	
	// 备用
	private Context mContext;
	// 构建视图时需要用到
	private LayoutInflater mInflater;
	//拖动到底部，调用的数据更新回调方法
	private DataUpdateCallback mDataUpdateCallback;
	//是否正通知更新,用此标记，避免同一时间多次调用
	private boolean isCallbacking;
	
	private ChoiceListViewAdapter()
	{
	}
	
	/**
	 * 唯一构造方法
	 * 
	 * @param context
	 * @param dataList
	 *            这里的传入数据限定为 {@link SubjectBean} 的集合
	 */
	public ChoiceListViewAdapter(Context context, List<SubjectBean> dataList ,DataUpdateCallback dataUpdateCallback)
	{
		this.mContext = context;
		this.mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
		/**
		 * 检查是否有现实{@link ChoiceListViewAdapter.DataUpdateCallback}
		 */
		mDataUpdateCallback = dataUpdateCallback;
		
		// 对数据进行分组
		groupByDataList(dataList, false);
		
	}
	
	/**
	 * 当新增数据时，需要通过此方法把数据分组 要把数据添加到缓存集合中，必须要调用此方法
	 * 
	 * @param list
	 *            新添加的数据集
	 * @param isUpdate
	 *            是否新增，即数据是否通过调用 @ DataUpdateCallback#addNewData(int)} 获得。
	 *            如果否，即数据是第一次初始化时传入，会把索引为0的对像取出放到{@link #mHeadData}中
	 */
	private void groupByDataList(List<SubjectBean> list, boolean isUpdate)
	{
		int index = 0;
		
		if (!isUpdate)
		{
			this.mHeadData = list.get(0);
			index++;
		}
		// 让两个合集的数量平均放置，mDataListLeft放一个然后 mDataListRight放一个,依此类推
		for (int i = index, size = list.size(); i < size; i++)
		{
			if (mDataListLeft.size() > mDataListRight.size())
			{
				mDataListRight.add(list.get(i));
			} else
			{
				mDataListLeft.add(list.get(i));
			}
		}
	}
	
	@Override
	public int getCount()
	{
		// 以左列视图加上第一行，为总行数
		return mDataListLeft.size() + 1;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		View view;
		if (0 == position) // 首行，取mHeadData的值
		{
			view = mInflater.inflate(R.layout.viewpager_choice_head, parent, false);
			final ImageView mImageView = (ImageView) view.findViewById(R.id.choice_head_image_id);
			mImageView.setImageBitmap(mHeadData.getImage());
		} else	// 第二行开始使用 R.layout.viewpager_choice_body 视图
		{
			// 先把position减1,因为不能把第一行算进来。
			int newPostition = position - 1;
			
			view = mInflater.inflate(R.layout.viewpager_choice_body, parent, false);
			
			//填充左图数据
			if (mDataListLeft.size() > newPostition)
			{
				SubjectBean mChoiceBean = mDataListLeft.get(newPostition);
				ImageView mImageView1 = (ImageView) view.findViewById(R.id.choice_body_image_1);
				mImageView1.setImageBitmap(
						mChoiceBean.getImage());
				
				TextView mTextView1 = (TextView) view.findViewById(R.id.choice_body_text_1);
				mTextView1.setText(mChoiceBean.getContent());
			}
			
			//填充右图数据
			if (mDataListRight.size() > newPostition)
			{
				SubjectBean mChoiceBean = mDataListRight.get(newPostition);
				ImageView mImageView2 = (ImageView) view.findViewById(R.id.choice_body_image_2);
				mImageView2.setImageBitmap(
						mDataListRight.get(newPostition).getImage());
				
				
				TextView mTextView2 = (TextView) view.findViewById(R.id.choice_body_text_2);
				mTextView2.setText(mChoiceBean.getContent());
			}
			
		}
		//如果已经到达底部,并且有实现回调方法，则通知更新,因为position是从0开始，所以和行数对比时要先+1
		if ( (position+1) == getCount() && null != mDataUpdateCallback && !isCallbacking )
		{
			// 先把position减1,因为不能把第一行算进来。
			mDataUpdateCallback.notifyLast(position - 1);
			isCallbacking = true;
		}
		
		return view;
	}
	
	/**
	 * 把新数据添加至尾部
	 * @param newDatas
	 */
	public void addNewDatas(List<SubjectBean> newDatas)
	{
		//对新数据进行分组
		groupByDataList(newDatas,true);
		//通知变更
		notifyDataSetChanged();
		isCallbacking = false;
	}
	
	
	/**
	 * 更新数据的勾子 当列被拉至尾部时，会调查当前{@link ChoiceListViewAdapter#mContext} 是否实现了这个接口，
	 * 如果现实了，则会调用通知，并具需要调用{@link #addNewDatas}方法把新的数据添加至尾部
	 * 
	 * @author jie
	 */
	public static interface DataUpdateCallback
	{
		public void notifyLast(int lastPosition);
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
