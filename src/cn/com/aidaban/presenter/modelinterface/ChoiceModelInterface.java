package cn.com.aidaban.presenter.modelinterface;
import java.util.List;
import android.content.Context;
import cn.com.aidaban.model.bean.ChoiceBean;
/**
 * 
 * 获取精采页的数据接口
 * @author jie
 *
 */
public interface ChoiceModelInterface
{
	/**
	 * 获取首页数据集
	 * @param context
	 * @return
	 */
	public List<ChoiceBean> getInitPageData(Context context);
}
