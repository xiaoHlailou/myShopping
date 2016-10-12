package com.example.shoppingdemo.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.util.Log;

public class HttpUtils {


	public static String get(String url, String charset) {
		String result = null;
		try {
			// 创建发送请求对象HttpClient
			HttpClient client = new DefaultHttpClient();
			// 创建get请求
			HttpGet get = new HttpGet(url);
			// 发送请求 发送没有封装线程的的对象，不需要回调
			HttpResponse response = client.execute(get);// 该方法会阻塞主线程
														// 直接返回结果

			InputStream inputStream = response.getEntity().getContent();// 结果里面可能有文字/图片数据
			byte[] data = StreamUtils.readInputStream(inputStream);
			result = new String(data,charset);
			inputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static String post(String url,List<BasicNameValuePair> params, String charset) {
		String result = null;
		try {
			// 创建发送请求对象httpClient
			HttpClient client = new DefaultHttpClient();

			HttpPost post=new HttpPost(url);
			
			UrlEncodedFormEntity form=new UrlEncodedFormEntity(params,charset);
			post.setEntity(form);//添加表单到请求里，会带到服务端

			HttpResponse response = client.execute(post);
			InputStream is=response.getEntity().getContent();
			
			byte[] data = StreamUtils.readInputStream(is);
			
			result=new String(data);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

}
