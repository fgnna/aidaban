package cn.com.aidaban.presenter.viewinterface;

import java.util.List;

import cn.com.aidaban.model.bean.ChoiceBean;
/**
 * 精彩页，view视图的业务调用接口
 * @author jie
 */
public interface ChoiceViewInterface
{
	/**
	 * 初始化第一页的数据
	 * @param list 第一页的数据
	 */
	public void initPageData(List<ChoiceBean> list);

	/**
	 * 更新下一页的新数据
	 * @param data
	 */
	public void updateNextPageData(List<ChoiceBean> data);
}
