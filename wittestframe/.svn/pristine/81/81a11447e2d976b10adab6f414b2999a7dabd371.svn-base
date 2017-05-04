package com.icinfo.witest.utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;



/** 
* @ClassName: PropertiesUtil 
* @Description: 读取.properties格式的配置文件
* @author wang wencong
* @date 2016年4月14日 上午8:36:02 
*  
*/
public class PropertiesUtil {
	
	/**
	 *
	 * @Description:Properties 通过路径取值
	 * @Param:
	 * key----取值的配置项key值
	 * configName--取值文件名
	 * @Return:取得配置项值
	 * @Exception:
	 * @Author:wang wencong
	 * @Date 2016年4月14日 上午10:00:15
	 * 备注：框架需封装成jar包被接口测试项目调用，如果使用类加载获取路径会 mvn构建会报错无法获取到config.properties的
	 * 值
	 */
	/*public static String getValue(String key, String configName) throws IOException {

		// 加载键值对数据
		Properties prop = new Properties();

		String configPath = PropertiesUtil.class.getClassLoader().getResource(configName).getPath();

		FileReader fr = new FileReader(configPath);
		prop.load(fr);
		fr.close();
		// 获取数据
		String value = prop.getProperty(key);

		return value;
	}*/
	/**
	 *
	 * @Description:Properties 通过路径取值
	 * @Param:
	 * configPath----文件路径
	 * configName--取值文件名
	 * @Return:取得配置项值
	 * @Exception:
	 * @Author:wang wencong
	 * @Date 2016年4月14日 上午10:00:15
	 * 备注：不用类加载方式获取文件路径，直接以参数形式传入
	 */
	public static String getTestResourceValue(String configPath,String key) throws IOException {

		// 加载键值对数据
		Properties prop = new Properties();

		FileReader fr = new FileReader(configPath);
		prop.load(fr);
		fr.close();
		// 获取数据
		String value = prop.getProperty(key);

		return value;
	}
}
