package com.icinfo.witest.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


/** 
* @ClassName: ParamBean 
* @Description: 解析从XML，读取的map格式的请求参数
* @author wang wencong
* @date 2016年4月11日 上午10:18:33 
*  
*/
public class ParamBean {

	/**
	 * 解析从XML中读取的map格式的请求参数，将参数的key保存成list格式
	 */
	public ArrayList<String> beanKey(Map<String, String> paramsMap) {

		if (paramsMap.isEmpty()) {

			// log.error("Can't find " + xmlPath);

			System.out.println("paramsMap is Empty");

		}
		try {
			ArrayList<String> list = new ArrayList<String>();
			for (Iterator iter = paramsMap.entrySet().iterator(); iter.hasNext();) {
				Map.Entry entry = (Map.Entry) iter.next();
				String key = (String) entry.getKey();
				list.add(key);
			}

			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * 获取指定key值的参数值
	 */
	public String beanValue(HashMap<String, Object> hashMap, String keyName) {
		if (hashMap.isEmpty()) {

			// log.error("Can't find " + xmlPath);

			System.out.println("paramsMap is Empty");

		}
		try {

			for (Iterator iter = hashMap.entrySet().iterator(); iter.hasNext();) {

				Map.Entry entry = (Map.Entry) iter.next();
				String key = (String) entry.getKey();
				if (key.equalsIgnoreCase(keyName)) {
					String beanValue = (String) entry.getValue();
					return beanValue;
				}

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * 获取指定key值的参数值并加上双引号
	 */
	public String withColonbeanValue(Map<String, String> paramsMap, String keyName) {
		if (paramsMap.isEmpty()) {

			// log.error("Can't find " + xmlPath);

			System.out.println("paramsMap is Empty");

		}
		try {

			for (Iterator iter = paramsMap.entrySet().iterator(); iter.hasNext();) {

				Map.Entry entry = (Map.Entry) iter.next();
				String key = (String) entry.getKey();
				if (key.equalsIgnoreCase(keyName)) {
					String beanValue = (String) entry.getValue();
					return "\""+beanValue+"\"";
				}

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public static void main(String[] args) {

		HashMap<String, String> locatorMap = new HashMap<String, String>();
		locatorMap.put("content", "fishtest1");
		locatorMap.put("signStr", "FAB2456A3E454F7FB7D10C78727AE944");
		locatorMap.put("userId", "wwc123456");
		locatorMap.put("nonceStr", "wwc123check1");
		locatorMap.put("mac", "00-19-5E-D9-C3-D7");
		// System.out.println(locatorMap);
		ParamBean pb = new ParamBean();
		ArrayList<String> ls = pb.beanKey(locatorMap);
		String macV = pb.withColonbeanValue(locatorMap, "mac");
		System.out.println(macV);

	}

}
