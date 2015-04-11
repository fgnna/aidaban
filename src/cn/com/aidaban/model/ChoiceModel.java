package cn.com.aidaban.model;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import cn.com.aidaban.R;
import cn.com.aidaban.common.BaseBitmapFactory;
import cn.com.aidaban.model.bean.SubjectBean;
import cn.com.aidaban.presenter.modelinterface.ChoiceModelInterface;

/**
 * 精彩页视图模型
 * 
 * @author jie
 * 
 */
public class ChoiceModel implements ChoiceModelInterface
{
	
	@Override
	public List<SubjectBean> getInitPageData(Context context)
	{
		List<SubjectBean> data = new ArrayList<SubjectBean>();
		data.add(new SubjectBean(BaseBitmapFactory.createBitmapByURL("http://www.jumeili.cn/upload/ContentImg/ContentTempImg/u=3092202842,1300320202&fm=11&gp=0.jpg"),"标题1 ","dddddddddddd"));
		data.add(new SubjectBean(BaseBitmapFactory.createBitmapByURL("http://hiphotos.baidu.com/exp/pic/item/7c5fcc1b0ef41bd598145f1851da81cb38db3d53.jpg"),"标题2 ","图1"));
		data.add(new SubjectBean(BaseBitmapFactory.createBitmapByURL("http://img7.paipaiimg.com/item-0FCFB9DC-DF9CC91300000000040100000AD1B3AB.0.200x200.jpg"),"标题1 ","图2"));
		data.add(new SubjectBean(BaseBitmapFactory.createBitmapByURL("http://img4.imgtn.bdimg.com/it/u=1863603747,2744320751&fm=21&gp=0.jpg"),"标题3 ", "图3"));
		data.add(new SubjectBean(BaseBitmapFactory.createBitmapByURL("http://img1.3lian.com/img2011/w1/104/78/76.jpg"),"标题4 ","图4"));
		return data;
	}
	
	@Override
	public List<SubjectBean> getNextPageData(int lastPosition)
	{
		
		List<SubjectBean> data = new ArrayList<SubjectBean>();
		
		if(1 == lastPosition)
		{
			data.add(new SubjectBean(BaseBitmapFactory.createBitmapByURL("http://hiphotos.baidu.com/exp/pic/item/7c5fcc1b0ef41bd598145f1851da81cb38db3d53.jpg"),"标题5", "图5"));
			data.add(new SubjectBean(BaseBitmapFactory.createBitmapByURL("http://img7.paipaiimg.com/item-0FCFB9DC-DF9CC91300000000040100000AD1B3AB.0.200x200.jpg"),"标题6 ", "图6"));
			data.add(new SubjectBean(BaseBitmapFactory.createBitmapByURL("http://img4.imgtn.bdimg.com/it/u=1863603747,2744320751&fm=21&gp=0.jpg"),"标题7 ","图7"));
			data.add(new SubjectBean(BaseBitmapFactory.createBitmapByURL("http://img1.3lian.com/img2011/w1/104/78/76.jpg"),"标题8 ", "图8"));
		}
		else if(3 == lastPosition)
		{
			data.add(new SubjectBean(BaseBitmapFactory.createBitmapByURL("http://hiphotos.baidu.com/exp/pic/item/7c5fcc1b0ef41bd598145f1851da81cb38db3d53.jpg"),"标题9 ", "图99999999999"));
			data.add(new SubjectBean(BaseBitmapFactory.createBitmapByURL("http://img7.paipaiimg.com/item-0FCFB9DC-DF9CC91300000000040100000AD1B3AB.0.200x200.jpg"),"标题10 ", "图10000000"));
			data.add(new SubjectBean(BaseBitmapFactory.createBitmapByURL("http://img4.imgtn.bdimg.com/it/u=1863603747,2744320751&fm=21&gp=0.jpg"),"标题11 ", "图11111111111"));
			data.add(new SubjectBean(BaseBitmapFactory.createBitmapByURL("http://img1.3lian.com/img2011/w1/104/78/76.jpg"),"标题12 ", "图12"));
			
			
		}
		return data;
	}
	
}
