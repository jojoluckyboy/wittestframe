package com.icinfo.llplatform.testcase;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.Consts;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.icinfo.witest.bean.ParamBean;
import com.icinfo.witest.bean.ResponseBean;
import com.icinfo.witest.httpclient.EntityUtil;
import com.icinfo.witest.httpclient.HttpClientUtil;
import com.icinfo.witest.httpclient.ResponseUtil;
import com.icinfo.witest.utils.PropertiesUtil;
import com.icinfo.witest.utils.XmlUtil;
import com.icinfo.witest.utils.sm4EncryptDataUtil;

/**
 * @ClassName: LLpasmodifyUpdatetime
 * @Description: 根据usb-key序列号 ，查询客户端usb-key密码最新修改时间
 * @author wang wencong
 * @date 2017年4月16日 下午4:05:43
 * 
 */
public class LLpasmodifyUpdatetime {

	static CookieStore cookieStore = null;

	static CloseableHttpClient httpclient = null;
	static String encode = "UTF-8";

	/**
	 *
	 * @Description:LLpasmodifyUpdatetime
	 * @Param:url----测试接口地址
	 * @Return:
	 * @Exception:
	 * @Author:wang wencong
	 * @Date 2017年4月14日 上午10:00:15
	 *
	 */
	@Test
	public void LLogAdd() {

		try {

			// System.out.println(NewTestCase.class.getClassLoader().getResource("config.properties").getPath());

			/* 获取test/resouce目录下的config文件键值 */

			/* NewTestCase为当case类的名字 */
			String configPath = LLlogAdd.class.getClassLoader().getResource("config.properties").getPath();
			String url = PropertiesUtil.getTestResourceValue(configPath, "url2");

			// String url = "http://115.238.48.66:1183/client/log/add";

			// String xmlPath = System.getProperty("user.dir") +
			// "\\src\\test\\resource\\LogAdd.xml";

			/* 获取test/resouce目录下的测试数据xml的值 */

			String xmlPath = getClass().getResource("/LogLastUpdateTime.xml").getPath();

			List<HashMap<String, Object>> paramsMap = XmlUtil.readXMLDocument(xmlPath);

			for (int i = 0, n = paramsMap.size(); i < n; i++) {

				
				
				ParamBean paraB = new ParamBean();
				String strKsn = paraB.beanValue(paramsMap.get(i), "ksn");

				CloseableHttpClient httpclient = HttpClients.createDefault();

				HttpGet httpget = new HttpGet(url+strKsn);
				CloseableHttpResponse httpResponse = httpclient.execute(httpget);

				// CloseableHttpResponse httpResponse =
				// HttpClientUtil.doGet(url, entitys, httpclient, cookieStore,
				// Consts.UTF_8);

				ResponseBean responseBean = ResponseUtil.setResponseBean(httpResponse);

				// add Assert
				System.out.println(responseBean);
				Assert.assertEquals("OK", responseBean.getStatus());
				Assert.assertEquals("200", responseBean.getStatusCode());
				Assert.assertEquals(true, responseBean.getBody().contains("成功！"));

			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@BeforeClass
	public void beforeClass() {
	}

	@AfterClass
	public void AfterClass() {

	}

	@BeforeTest
	public void beforeTest() {
	}

	@AfterTest
	public void afterTest() {
	}

	@BeforeSuite
	public void beforeSuite() {
	}

	@AfterSuite
	public void closeClient() {
		if (httpclient != null) {
			try {
				// 关闭流并释放资源
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
