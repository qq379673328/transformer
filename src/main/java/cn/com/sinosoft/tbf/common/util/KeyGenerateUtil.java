package cn.com.sinosoft.tbf.common.util;

import java.math.BigDecimal;
import java.util.Random;
import java.util.UUID;

/**
 * 标识生成工具类
 *
 * @author	<a href="mailto:nytclizy@gmail.com">李志勇</a>
 * @date	2015-4-30
 */
public class KeyGenerateUtil {
	
	private static Random r = new Random();
	
	/**
	 * 生成19位的随机主键
	 *
	 * 
	 * @return
	 * @author <a href="mailto:nytclizy@gmail.com">李志勇</a>
	 */
	public static BigDecimal genetatePk19(){
		return new BigDecimal("" + System.currentTimeMillis() + r.nextInt(999999));
	}
	
	/**
	 * 生成普通主键
	 *
	 * 
	 * @return
	 * @author <a href="mailto:nytclizy@gmail.com">李志勇</a>
	 */
	public static String genetatePk(){
		return UUID.randomUUID().toString();
	}
	
}
