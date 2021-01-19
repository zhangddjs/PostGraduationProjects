package sorm.core;

/**
 * 负责java数据类型和数据库数据类型互相转化
 * @author zdd
 *
 */
public interface TypeConvertor {
	 /**
	  * 将数据库类型转化成java类型
	  * @param columnType
	  * @return java的数据类型
	  */
	public String datebaseType2JavaType(String columnType);
	
	/**
	 * 将java数据类型转化成数据库数据类型
	 * @param columnType
	 * @return 数据库类型
	 */
	public String javaType2DatebaseType(String columnType);
}
