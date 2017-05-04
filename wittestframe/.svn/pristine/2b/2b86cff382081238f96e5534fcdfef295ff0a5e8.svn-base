package com.icinfo.witest.runfaillistener;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;


/** 
* @ClassName: RetryListener 
* @Description: 添加用例重跑监听器，用例失败自动重跑功能
* @author wang wencong
* @date 2016年4月14日 上午10:11:13 
*  
*/
public class RetryListener implements IAnnotationTransformer {
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        IRetryAnalyzer retry = annotation.getRetryAnalyzer();
        if (retry == null) {
            annotation.setRetryAnalyzer(TestNGRetry.class);
        }
    }
   
}


