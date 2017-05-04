package com.icinfo.witest.runfaillistener;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.icinfo.witest.utils.LogUtil;

/** 
* @ClassName: TestNGRetry 
* @Description: 用例失败自动重跑逻辑
* @author wang wencong
* @date 2016年4月14日 上午10:13:59 
*  
*/
public class TestNGRetry implements IRetryAnalyzer {
	public LogUtil log = new LogUtil(this.getClass());
	private int retryCount = 0;
	private int maxRetryCount=2;


	public boolean retry(ITestResult result) {
		if (retryCount <= maxRetryCount) {
			String message = "running retry for  '" + result.getName() + "' on class " + 
                                       this.getClass().getName() + " Retrying " + retryCount + " times";
			log.info(message);
			retryCount++;
			return true;
		}
		return false;
	}
}