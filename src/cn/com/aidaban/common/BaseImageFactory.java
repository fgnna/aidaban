package cn.com.aidaban.common;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.Html.ImageGetter;
import android.text.Html.TagHandler;

/**
 * 生产与图片相关实体类工厂 如： 生产一个通过URL获取的Bitmap{@link #createBitmapByURL(String)} ,<br>
 * 获取 {@link android.text.Html#fromHtml(String source, ImageGetter imageGetter, TagHandler tagHandler)
 * 中的图片处理类{@link ImageGetter}<br>
 * 
 * @see #
 * @author jie
 * 
 */
public class BaseImageFactory extends BitmapFactory
{
	/**
	 * 通过网络路径加载图片
	 * 
	 * @param url
	 * @return
	 */
	public static Bitmap createBitmapByURL(String url)
	{
		URL myFileURL;
		Bitmap bitmap = null;
		try
		{
			myFileURL = new URL(url);
			// 获得连接
			HttpURLConnection conn = (HttpURLConnection) myFileURL.openConnection();
			// 设置超时时间为6000毫秒，conn.setConnectionTiem(0);表示没有时间限制
			conn.setConnectTimeout(6000);
			// 连接设置获得数据流
			conn.setDoInput(true);
			// 不使用缓存
			conn.setUseCaches(false);
			// 这句可有可无，没有影响
			// conn.connect();
			// 得到数据流
			InputStream is = conn.getInputStream();
			// 解析得到图片
			bitmap = BitmapFactory.decodeStream(is);
			// 关闭数据流
			is.close();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return bitmap;
		
	}
	
	/**
	 * 获取一个用于处理Html.fromHtml 中的关于图片处理ImageGetter类的实现类
	 * @see  android.text.Html#fromHtml(String source, ImageGetter imageGetter, TagHandler tagHandler)
	 * @return ImageGetter ImageGetter类的实现类
	 */
	public static ImageGetter createHtmlNetworkImageGetter()
	{
		return new ImageGetter()
		{
			@Override
			public Drawable getDrawable(String source)
			{
				URL url;
				Drawable drawable = null;
				try
				{
					url = new URL(source);
					drawable = Drawable.createFromStream(url.openStream(), null);
					drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
				} catch (MalformedURLException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
					return null;
				} catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
					return null;
				}
				return drawable;
			}
		};
		
	}
}
