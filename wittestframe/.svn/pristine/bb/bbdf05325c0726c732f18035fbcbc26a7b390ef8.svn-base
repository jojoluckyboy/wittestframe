package com.icinfo.witest.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.*;

import com.icinfo.witest.utils.LogUtil;
import com.icinfo.witest.utils.PropertiesUtil;
import com.icinfo.witest.utils.XmlUtil;


/** 
* @ClassName: XmlUtil 
* @Description: xml应用工具
* @author wang wencong
* @date 2016年4月13日 上午10:30:24 
*  
*/
/** 
* @ClassName: XmlUtil 
* @Description: TODO
* @author wang wencong
* @date 2017年4月11日 上午10:30:58 
*  
*/
/** 
* @ClassName: XmlUtil 
* @Description: TODO
* @author wang wencong
* @date 2017年4月11日 上午10:31:02 
*  
*/
public class XmlUtil {
	
	/**
	 * @param
	 * @param
	 * @author Jerry
	 * @date 2016-03-03
	 */
//	private static LogUtil log = new LogUtil(XmlUtil.class);	

	public static List<HashMap<String, Object>> readXMLDocument(String xmlPath) throws IOException {

		List<HashMap<String, Object>> locatorMap = new ArrayList<>();

		File file = new File(xmlPath);
		if (!file.exists()) {
//			log.error("Can't find " + xmlPath);
			
			System.out.println("can not find path!");
		}

		SAXReader saxReader = new SAXReader();
		Document document;
		try {
			document = saxReader.read(file);
			Element root=document.getRootElement();
	        List<Element> list = root.elements();
	        
	        
			for (Element level2: list) {
				HashMap<String, Object> paraMap = new HashMap<>();

					for (Iterator iter1 = level2.elementIterator(); iter1.hasNext();) {
						Element e2 = (Element) iter1.next();

						String elementName = e2.attributeValue("name").toString();
						String elementValue = e2.attributeValue("value").toString();
						paraMap.put(elementName, elementValue);
						
					}
					locatorMap.add(paraMap);
				}
			      return locatorMap;
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
     
	public static void main(String[] args) throws IOException {
//		List<XmlMap> xmlMaps = new ArrayList<XmlMap>();
//		for(){
//			XmlMap xmlMap = new XmlMap();
//			xmlMap.setUserid("1111");
//			...
//			xmlMaps.add(xmlMap)
//		}
//		return xmlMaps;
		//String url = PropertiesUtil.getValue("url");
		List<HashMap<String, Object>> locatorMap = new ArrayList<>();
		String xmlPath = System.getProperty("user.dir") + "\\src\\test\\resource\\LLlogParaData\\LogAdd.xml";
		File file = new File(xmlPath);
		
		SAXReader saxReader = new SAXReader();
		Document document = null;
		
		try {
			//  List<HashMap<String, Object>> paramsMap = XmlUtil.readXMLDocument(xmlPath);
			document = saxReader.read(file);
			Element root=document.getRootElement();
		
            List<Element> list = root.elements();
            System.out.println(list+"111111");
            
	        
	        
			for (Element level2:list) {
				
				System.out.println(level2+"..............");
				HashMap<String, Object> paraMap = new HashMap<>();
					for (Iterator iter1 = level2.elementIterator(); iter1.hasNext();) {
						Element e2 = (Element) iter1.next();
						System.out.println(e2+"e2222222");

						String elementName = e2.attributeValue("name").toString();
						String elementValue = e2.attributeValue("value").toString();
						paraMap.put(elementName, elementValue);
					}
					locatorMap.add(paraMap);
				}
		      System.out.println(locatorMap);
		      System.out.println(locatorMap.size());

                
	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		Map<String, String> paramsMap = XmlUtil.readXMLDocument(xmlPath, "logAdd1");
//		System.out.println(paramsMap);
		
		//String response = HttpClientUtil.doPost(url, paramsMap);
		//System.out.println(response);
	}


}

