package com.icinfo.witest.utils;
import java.io.IOException;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import com.icinfo.sm4src.SM4;
import com.icinfo.sm4src.SM4_Context;
import com.icinfo.shaMD5.Util;


/** 
* @ClassName: sm4EncryptDataUtil 
* @Description: 使用sm4加密字符串
* @author wang wencong
* @date 2016年4月12日 下午14:28:58 
*  
*/
@SuppressWarnings("restriction")
public class sm4EncryptDataUtil {
	private String secretKey = "";
	private String iv = "";
	private boolean hexString = false;
	
	public sm4EncryptDataUtil()
	{
	}
	
	/**
	 * 描述：ECB模式加密
	 * @param plainText
	 * @return
	 */
	public String encryptData_ECB(String plainText)
	{
		try 
		{
			SM4_Context ctx = new SM4_Context();
			ctx.isPadding = true;
			ctx.mode = SM4.SM4_ENCRYPT;
			
			byte[] keyBytes;
			if (hexString)
			{
				keyBytes = Util.hexStringToBytes(secretKey);
			}
			else
			{
				keyBytes = secretKey.getBytes();
			}
			
			SM4 sm4 = new SM4();
			sm4.sm4_setkey_enc(ctx, keyBytes);
			byte[] encrypted = sm4.sm4_crypt_ecb(ctx, plainText.getBytes("UTF-8"));
			String cipherText = new BASE64Encoder().encode(encrypted);
			if (cipherText != null && cipherText.trim().length() > 0)
			{
				Pattern p = Pattern.compile("\\s*|\t|\r|\n");
				Matcher m = p.matcher(cipherText);
				cipherText = m.replaceAll("");
			}
			return cipherText;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 描述：ECB模式解密
	 * @param cipherText
	 * @return
	 */
	public String decryptData_ECB(String cipherText)
	{
		try 
		{
			SM4_Context ctx = new SM4_Context();
			ctx.isPadding = true;
			ctx.mode = SM4.SM4_DECRYPT;
			
			byte[] keyBytes;
			if (hexString)
			{
				keyBytes = Util.hexStringToBytes(secretKey);
			}
			else
			{
				keyBytes = secretKey.getBytes();
			}
			
			SM4 sm4 = new SM4();
			sm4.sm4_setkey_dec(ctx, keyBytes);
			byte[] decrypted = sm4.sm4_crypt_ecb(ctx, new BASE64Decoder().decodeBuffer(cipherText));
			return new String(decrypted, "UTF-8");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 描述：ECB模式解密
	 * @param cipherText
	 * @return
	 */
	public String decryptData_ECB(String cipherText,byte[] keyBytes)
	{
		try 
		{
			SM4_Context ctx = new SM4_Context();
			ctx.isPadding = true;
			ctx.mode = SM4.SM4_DECRYPT;
			SM4 sm4 = new SM4();
			sm4.sm4_setkey_dec(ctx, keyBytes);
			byte[] decrypted = sm4.sm4_crypt_ecb(ctx, new BASE64Decoder().decodeBuffer(cipherText));
			return new String(decrypted, "UTF-8");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return null;
		}
		
		
	}
	
	public String SHA1(String decript)
	{
		try {
			MessageDigest digest = java.security.MessageDigest
					.getInstance("SHA-1");
			digest.update(decript.getBytes());
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
		return "";
	}
	
	/**
	 * CBC模式加密
	 * @param plainText
	 * @param secretKey2 
	 * @return
	 */
	public String encryptData_CBC(String plainText)
	{
		try 
		{
			SM4_Context ctx = new SM4_Context();
			ctx.isPadding = true;
			ctx.mode = SM4.SM4_ENCRYPT;
			
			byte[] keyBytes;
			byte[] ivBytes;
			if (hexString)
			{
				keyBytes = Util.hexStringToBytes(secretKey);
				ivBytes = Util.hexStringToBytes(iv);
			}
			else
			{
				keyBytes = secretKey.getBytes();
				ivBytes = iv.getBytes();
			}
			
			SM4 sm4 = new SM4();
			sm4.sm4_setkey_enc(ctx, keyBytes);
			byte[] encrypted = sm4.sm4_crypt_cbc(ctx, ivBytes, plainText.getBytes("UTF-8"));
			String cipherText = new BASE64Encoder().encode(encrypted);
			if (cipherText != null && cipherText.trim().length() > 0)
			{
				Pattern p = Pattern.compile("\\s*|\t|\r|\n");
				Matcher m = p.matcher(cipherText);
				cipherText = m.replaceAll("");
			}
			return cipherText;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * CBC模式解密
	 * @param cipherText
	 * @return
	 */
	public String decryptData_CBC(String cipherText)
	{
		try 
		{
			SM4_Context ctx = new SM4_Context();
			ctx.isPadding = true;
			ctx.mode = SM4.SM4_DECRYPT;
			
			byte[] keyBytes;
			byte[] ivBytes;
			if (hexString)
			{
				keyBytes = Util.hexStringToBytes(secretKey);
				ivBytes = Util.hexStringToBytes(iv);
			}
			else
			{
				keyBytes = secretKey.getBytes();
				ivBytes = iv.getBytes();
			}
			
			SM4 sm4 = new SM4();
			sm4.sm4_setkey_dec(ctx, keyBytes);
			byte[] decrypted = sm4.sm4_crypt_cbc(ctx, ivBytes, new BASE64Decoder().decodeBuffer(cipherText));
			return new String(decrypted, "UTF-8");
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	public static void main(String[] args) throws IOException 
	{
		String plainText = "{\"userId\":\"wwc123\",\"mac\":\"00-19-5E-D9-C3-D7\",\"content\":\"hello,log fishtest\",\"nonceStr\":\"9527wwc\",\"signature\":\"462b494c8adbb9844d6339fdaf9c300f22d6135b\"}";
		
		String sha1Str = "9527wwcFAB2456A3E454F7FB7D10C78727AE944";
		
		sm4EncryptDataUtil sm4 = new sm4EncryptDataUtil();
		String sha1T =sm4.SHA1(sha1Str);
		System.out.println("sha1摘要生成: " + sha1T);
		

		sm4.secretKey = "JeF8U9wHFOMfs2Y8";
		sm4.hexString = false;
		
		System.out.println("ECB模式");
		String cipherText = sm4.encryptData_ECB(plainText);
		System.out.println("密文: " + cipherText);
		System.out.println("");
		
		plainText = sm4.decryptData_ECB(cipherText);
		System.out.println("明文: " + plainText);
		System.out.println("");
		
		System.out.println("CBC模式");
		sm4.iv = "UISwD9fW6cFh9SNS";
		cipherText = sm4.encryptData_CBC(plainText);
		System.out.println("密文: " + cipherText);
		System.out.println("");
		
		plainText = sm4.decryptData_CBC(cipherText);
		System.out.println("明文: " + plainText);
	}

	public String getSecretKey() {
		return secretKey;
	}

	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}

	public String getIv() {
		return iv;
	}

	public void setIv(String iv) {
		this.iv = iv;
	}

	public boolean isHexString() {
		return hexString;
	}

	public void setHexString(boolean hexString) {
		this.hexString = hexString;
	}
	

}
