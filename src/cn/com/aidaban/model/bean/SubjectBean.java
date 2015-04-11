package cn.com.aidaban.model.bean;

import android.graphics.Bitmap;
/**
 * 主题的数据模型
 * @author jie
 */
public class SubjectBean
{
	/**
	 * 图片
	 */
	private Bitmap image;
	/**
	 *标题
	 */
	private String title;
	/**
	 * 说明内容
	 */
	private String content;
	public SubjectBean(Bitmap image,String title,String content)
	{
		this.image = image;
		this.title = title;
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
	public String getTitle()
	{
		return title;
	}
	public void setTitle(String title)
	{
		this.title = title;
	}
	

}
