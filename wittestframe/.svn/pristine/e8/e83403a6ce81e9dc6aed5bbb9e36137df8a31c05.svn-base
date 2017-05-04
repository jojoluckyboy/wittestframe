package com.icinfo.witest.utils;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.Consts;


/** 
* @ClassName: shaMD5encryptData 
* @Description: 使用MD5和sha加密请求字符串
* @author wang wencong
* @date 2016年4月12日 上午11:27:45 
*  
*/
public class shaMD5encryptData {
	
	   /**
     * MD5加密字符串
     * @param text 需要加密的字符串
     * @param key 密钥
     * @param input_charset 编码格式
     * @return 签名结果
     */
 
	public String encryptData_MD5(String text, String key, String input_charset)
	{
		try 
		{
			text = text + key;
	        return DigestUtils.md5Hex(getContentBytes(text, input_charset));
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return null;
		}
	}
	
	 /**
     * @param content //字符串内容
     * @param charset //编码
     * @return
     * @throws SignatureException
     * @throws UnsupportedEncodingException 
     */
    private static byte[] getContentBytes(String content, String charset) {
        if (charset == null || "".equals(charset)) {
            return content.getBytes();
        }
        try {
            return content.getBytes(charset);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("MD5签名过程中出现错误,指定的编码集不对,您目前指定的编码集是:" + charset);
        }
    }
    
    /**
     * SHA加密字符串
     * @param content 需要加密的字符串
     * @param key 密钥
     * @param input_charset 编码格式
     * @return 加密结果
     */
 
	public String encryptData_SHA(String content, String key, String input_charset)
	{
		try {
			MessageDigest digest = java.security.MessageDigest
					.getInstance("SHA-1");
			digest.update(getContentBytes(content, input_charset));
			byte messageDigest[] = digest.digest();
			// Create Hex String
			StringBuffer hexString = new StringBuffer();
			// 字节数组转换为 十六进制 数
			for (int i = 0; i < messageDigest.length; i++) {
				String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
				if (shaHex.length() < 2) {
					hexString.append(0);
				}
				hexString.append(shaHex);
			}
			return hexString.toString();

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) throws IOException 
	{
		String content = "wwc@1234";
		
		String key = "FAB2456A3E454F7FB7D10C78727AE944";
		
		shaMD5encryptData smd = new shaMD5encryptData();
		String sha1 =smd.encryptData_SHA(content, key, "UTF-8");
		System.out.println("sha摘要生成: " + sha1);
		
		String md51 =smd.encryptData_MD5(content, key, "UTF-8");
		System.out.println("md5摘要生成: " + md51);
		

	}
}
