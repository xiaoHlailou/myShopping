package com.example.shoppingdemo.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class StreamUtils {

	/**
	 * 把一个流里面的内容，转换为String字符串
	 * @param is
	 * @return
	 */
	public static String readStream(InputStream is){
		try {
			byte[] bytes = readInputStream(is);
			return new String(bytes);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 把一个流里面的内容，转换为byte[]字节数据
	 * @param is
	 * @return
	 * @throws IOException 
	 */
	public static byte[] readInputStream(InputStream is) throws IOException {
		ByteArrayOutputStream baos=new ByteArrayOutputStream();
		byte[] bytes=new byte[1024];
		int len=-1;
		while((len=is.read(bytes))!=-1){
			baos.write(bytes,0,len);
		}
		is.close();
		return baos.toByteArray();
	}

}
