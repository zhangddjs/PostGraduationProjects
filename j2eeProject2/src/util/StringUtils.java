package util;

/**
 * 封装了字符串常用的操�?
 * @author gaoqi www.sxt.cn
 *
 */
public class StringUtils {
	
	/**
	 * 将目标字符串首字母变为大�?
	 * @param str 目标字符�?
	 * @return 首字母变为大写的字符�?
	 */
	public static String firstChar2UpperCase(String str){
		//abcd-->Abcd
		//abcd-->ABCD-->Abcd
		return str.toUpperCase().substring(0, 1)+str.substring(1);
	}
	
}
