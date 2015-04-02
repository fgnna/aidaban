package cn.com.aidaban.model.bean;

import cn.com.aidaban.view.adapter.ChoiceListViewAdapter;
import android.graphics.Bitmap;
/**
 * 精彩页的数据模型
 * {@link ChoiceListViewAdapter } 的构造方法中，数据参数只接受这个数据模型
 * @author jie
 */
public class ChoiceBean
{
	/**
	 * 图片
	 */
	private Bitmap image;
	/**
	 * 说明内容
	 */
	private String content;
	public ChoiceBean(Bitmap image,String content)
	{
		this.image = image;
		this.content = content;
	}
	public Bitmap getImage()
	{
		return image;
	}
	public void setImage(Bitmap image)
	{
		this.image = image;
	}
	public String getContent()
	{
		return content;
	}
	public void setContent(String content)
	{
		this.content = content;
	}

}
