package sorm.core;

/**
 * ����java�������ͺ����ݿ��������ͻ���ת��
 * @author zdd
 *
 */
public interface TypeConvertor {
	 /**
	  * �����ݿ�����ת����java����
	  * @param columnType
	  * @return java����������
	  */
	public String datebaseType2JavaType(String columnType);
	
	/**
	 * ��java��������ת�������ݿ���������
	 * @param columnType
	 * @return ���ݿ�����
	 */
	public String javaType2DatebaseType(String columnType);
}
