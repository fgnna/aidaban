package cn.com.aidaban.presenter.modelinterface;

import java.util.List;
import android.content.Context;
import cn.com.aidaban.model.bean.SubjectBean;

/**
 * 
 * 获取精采页的数据接口
 * 
 * @author jie
 * 
 */
public interface TodayModelInterface
{
	/**
	 * 获取首页数据集
	 * 
	 * @param context
	 * @return
	 */
	public List<SubjectBean> getInitPageData(Context context);
}
