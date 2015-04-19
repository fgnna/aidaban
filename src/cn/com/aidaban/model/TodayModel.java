package cn.com.aidaban.model;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import cn.com.aidaban.common.BaseImageFactory;
import cn.com.aidaban.model.bean.SubjectBean;
import cn.com.aidaban.presenter.modelinterface.TodayModelInterface;

/**
 * 精彩页视图模型
 * 
 * @author jie
 * 
 */
public class TodayModel implements TodayModelInterface
{
	
	@Override
	public List<SubjectBean> getInitPageData(Context context)
	{
		List<SubjectBean> data = new ArrayList<SubjectBean>();
		data.add(new SubjectBean(BaseImageFactory.createBitmapByURL("http://hiphotos.baidu.com/exp/pic/item/7c5fcc1b0ef41bd598145f1851da81cb38db3d53.jpg"),"标题2 ","图1"));
		data.add(new SubjectBean(BaseImageFactory.createBitmapByURL("http://img7.paipaiimg.com/item-0FCFB9DC-DF9CC91300000000040100000AD1B3AB.0.200x200.jpg"),"标题1 ","图2"));
		data.add(new SubjectBean(BaseImageFactory.createBitmapByURL("http://img4.imgtn.bdimg.com/it/u=1863603747,2744320751&fm=21&gp=0.jpg"),"标题3 ", "图3"));
		data.add(new SubjectBean(BaseImageFactory.createBitmapByURL("http://img1.3lian.com/img2011/w1/104/78/76.jpg"),"标题4 ","图4"));
		return data;
	}
	
}
