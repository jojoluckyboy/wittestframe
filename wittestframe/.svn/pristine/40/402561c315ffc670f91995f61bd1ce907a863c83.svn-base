package com.icinfo.witest.httpclient;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.http.Consts;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicNameValuePair;
import org.dom4j.Element;

import com.icinfo.witest.bean.ParamBean;
import com.icinfo.witest.utils.shaMD5encryptData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


/** 
* @ClassName: EntityUtil 
* @Description: 封装拼接请求参数实体
* @author wang wencong
* @date 2016年4月11日 上午10:23:23 
*  
*/
public class EntityUtil {
	
	private static Charset ucode = Consts.UTF_8;
	/**
	 * 封装一个针对特定字段拼接加密后作为签名值传递的方法
	 * @param params  加密字符段
	 * @param signkey 加密签名值
	 * @param input_charset 编码
	 * @return HashMap<String, String>
	 */
	public static  HashMap<String, Object> encryptData_sign(HashMap<String, Object> hashMap,String param,String signkey,String input_charset) {
	
		/*
		 * 取测试数据map中特定字段值与签名key拼接
		 */
		ParamBean paraB = new ParamBean();
		String strV = paraB.beanValue(hashMap, param);
		String key = signkey;
		String text = strV+key;
		
		/*
		 * sha加密以sign键值返回给测试数据Map
		 */
		
		shaMD5encryptData sha1 = new shaMD5encryptData();
		String signV = sha1.encryptData_SHA(text, key, input_charset);
		hashMap.put("signature", signV);
		return hashMap;
	}
	
	
	/**
	 * 以json格式封装http请求实体
	 * @param Map<String, String> paramsMap  请求测试数据
	 * @return UrlEncodedFormEntity
	 */
	
	public static  String to_StringJson(Map<String, Object> paramsMapV) {
		
	
		/*
		 * 取测试数据map中特定字段值与签名key拼接
		 */
		try{
			   //向json中添加数据
	         JSONObject jsonStr = new JSONObject();
	  
			for (Iterator iter1 = paramsMapV.entrySet().iterator(); iter1.hasNext();) {
				Map.Entry<String, String> entry = (Map.Entry<String, String>) iter1.next();
				jsonStr.put(entry.getKey(), entry.getValue());
			}
			
			return jsonStr.toString();
			
		}catch(Exception e){
			
			e.printStackTrace();
			
		}
	    return null;
	}
	
	/**
	 * 封装一个获取请求实体的方法
	 * @param params
	 * @param ucode
	 * @return
	 */
	public static StringEntity getFormEntity( String params, Charset ucode) {
	
	
		StringEntity entitys = new StringEntity(params,ucode);
		
		return entitys;
	}
	
	public static void main(String[] args) {

		HashMap<String, Object> locatorMap = new HashMap<String, Object>();
		locatorMap.put("content", "fishtest1");
		locatorMap.put("userId", "wwc123456");
		locatorMap.put("nonceStr", "wwc123check1");
		locatorMap.put("mac", "00-19-5E-D9-C3-D7");
		// System.out.println(locatorMap);
		String signStr = "FAB2456A3E454F7FB7D10C78727AE944";
		String keyParam = "nonceStr";
		EntityUtil eu = new EntityUtil();
		//System.out.println(eu.encryptData_sign(locatorMap, keyParam, signStr, "UTF-8"));
		System.out.println(eu.to_StringJson(locatorMap));

	}
}
