package com.icinfo.witest.httpclient;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.http.Consts;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.meterware.httpunit.PostMethodWebRequest;


/** 
* @ClassName: HttpClientUtil 
* @Description:  封装一个工具类HttpClientUtil，发送http和https请求的方法(包括get，post，put，delete请求)
* @author wang wencong
* @date 2016年4月12日 上午10:25:05 
*  
*/
public class HttpClientUtil {

	

	/**
	 * get请求
	 * 
	 * @param url
	 * @param params
	 * @param httpclient
	 * @param cookieStore
	 * @return
	 */
	public static CloseableHttpResponse doGet(String url, String entitys, CloseableHttpClient httpclient,
			CookieStore cookieStore,Charset ucode) {

		HttpGet httpget = null;
		

		try {
			
			httpget = new HttpGet(url + '?' + EntityUtil.getFormEntity(entitys, ucode));
			if (cookieStore != null) {
				httpget.setHeader("Cookie", "JSESSIONID=" + cookieStore.getCookies().get(0).getValue().trim());
			}
		

			// 执行get请求，返回response服务器响应对象, 其中包含了状态信息和服务器返回的数据
			CloseableHttpResponse httpResponse = httpclient.execute(httpget);
			return httpResponse;

		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * post请求
	 * @param url
	 * @param paramsMap
	 * @param httpclient
	 * @param cookieStore
	 * @return
	 */
	public static CloseableHttpResponse doPost(String url, String entitys, CloseableHttpClient httpclient, String contentTypeV,CookieStore cookieStore,Charset ucode){
        
		HttpPost httppost = new HttpPost(url);

		if (cookieStore != null) {
			httppost.setHeader("Cookie", "JSESSIONID=" + cookieStore.getCookies().get(0).getValue().trim());
		}
		// 请求实体
	
		httppost.setEntity(EntityUtil.getFormEntity(entitys, ucode));
		httppost.setHeader("Content-Type", contentTypeV);
		
		// 执行post请求，返回response服务器响应对象, 其中包含了状态信息和服务器返回的数据
				try {
					CloseableHttpResponse httpResponse = httpclient.execute(httppost);
					return httpResponse;
					
				} catch (ClientProtocolException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} 
	
		return null;
	}
}
