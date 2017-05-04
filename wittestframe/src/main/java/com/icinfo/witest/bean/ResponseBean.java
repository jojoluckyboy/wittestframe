package com.icinfo.witest.bean;

/** 
* @ClassName: ResponseBean 
* @Description: 响应response的bean文件
* @author wang wencong
* @date 2016年4月11日 上午10:20:38 
*  
*/
/** 
* @ClassName: ResponseBean 
* @Description: TODO
* @author wang wencong
* @date 2017年4月11日 上午10:21:06 
*  
*/
/** 
* @ClassName: ResponseBean 
* @Description: TODO
* @author wang wencong
* @date 2017年4月11日 上午10:21:10 
*  
*/
public  class ResponseBean {
    
	public String status;
	public String statusCode;   //响应状态码
	public String contentType;
	public String body;
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	
	

	@Override
	
	public String toString() {
		return "ResponseBean [status=" + status + ", statusCode=" + statusCode + ", contentType=" + contentType
				+ ", body=" + body + "]";
	}
  
   
}