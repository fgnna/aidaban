package cn.com.aidaban.presenter.viewinterface;

import java.util.List;

import cn.com.aidaban.model.bean.SubjectBean;
/**
 * 今日页，view视图的业务调用接口
 * @author jie
 */
public interface TodayViewInterface
{
	/**
	 * 初始化第一页的数据
	 * @param list 第一页的数据
	 */
	public void initPageData(List<SubjectBean> list);
}
