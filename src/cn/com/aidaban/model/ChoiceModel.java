package cn.com.aidaban.model;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import cn.com.aidaban.R;
import cn.com.aidaban.common.BaseBitmapFactory;
import cn.com.aidaban.model.bean.ChoiceBean;
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
	public List<ChoiceBean> getInitPageData(Context context)
	{
		List<ChoiceBean> data = new ArrayList<ChoiceBean>();
		data.add(new ChoiceBean(BaseBitmapFactory.createBitmapByURL("http://www.jumeili.cn/upload/ContentImg/ContentTempImg/u=3092202842,1300320202&fm=11&gp=0.jpg"), "dddddddddddd"));
		data.add(new ChoiceBean(BaseBitmapFactory.createBitmapByURL("http://m.hunlimama.com/login/data/upload/image/2014/03/25/5330da15e8654.png"), "图1"));
		data.add(new ChoiceBean(BaseBitmapFactory.createBitmapByURL("http://img7.paipaiimg.com/item-0FCFB9DC-DF9CC91300000000040100000AD1B3AB.0.200x200.jpg"), "图2"));
		data.add(new ChoiceBean(BaseBitmapFactory.createBitmapByURL("http://img4.imgtn.bdimg.com/it/u=1863603747,2744320751&fm=21&gp=0.jpg"), "图3"));
		data.add(new ChoiceBean(BaseBitmapFactory.createBitmapByURL("http://img1.3lian.com/img2011/w1/104/78/76.jpg"), "图4"));
		return data;
	}
	
	@Override
	public List<ChoiceBean> getNextPageData(int lastPosition)
	{
		
		List<ChoiceBean> data = new ArrayList<ChoiceBean>();
		
		if(1 == lastPosition)
		{
			data.add(new ChoiceBean(BaseBitmapFactory.createBitmapByURL("http://m.hunlimama.com/login/data/upload/image/2014/03/25/5330da15e8654.png"), "图5"));
			data.add(new ChoiceBean(BaseBitmapFactory.createBitmapByURL("http://img7.paipaiimg.com/item-0FCFB9DC-DF9CC91300000000040100000AD1B3AB.0.200x200.jpg"), "图6"));
			data.add(new ChoiceBean(BaseBitmapFactory.createBitmapByURL("http://img4.imgtn.bdimg.com/it/u=1863603747,2744320751&fm=21&gp=0.jpg"), "图7"));
			data.add(new ChoiceBean(BaseBitmapFactory.createBitmapByURL("http://img1.3lian.com/img2011/w1/104/78/76.jpg"), "图8"));
		}
		else if(3 == lastPosition)
		{
			data.add(new ChoiceBean(BaseBitmapFactory.createBitmapByURL("http://m.hunlimama.com/login/data/upload/image/2014/03/25/5330da15e8654.png"), "图99999999999"));
			data.add(new ChoiceBean(BaseBitmapFactory.createBitmapByURL("http://img7.paipaiimg.com/item-0FCFB9DC-DF9CC91300000000040100000AD1B3AB.0.200x200.jpg"), "图10000000"));
			data.add(new ChoiceBean(BaseBitmapFactory.createBitmapByURL("http://img4.imgtn.bdimg.com/it/u=1863603747,2744320751&fm=21&gp=0.jpg"), "图11111111111"));
			data.add(new ChoiceBean(BaseBitmapFactory.createBitmapByURL("http://img1.3lian.com/img2011/w1/104/78/76.jpg"), "图12"));
			
			
		}
		return data;
	}
	
}
