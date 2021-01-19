package sorm.core;

import java.util.List;

/**
 * ��ѯ
 * @author zdd
 *
 */
@SuppressWarnings("all")
public interface Query {
	/**
	 * ֱ��ִ��һ��DML���
	 * @param sql
	 * @param params
	 * @return ִ��sql���Ӱ���¼������
	 */
	public int executeDML(String sql, Object[] params);
	
	/**
	 * ��һ������洢�����ݿ���
	 * @param obj Ҫ�洢�Ķ���
	 */
	public void insert(Object obj);
	
	/**
	 * ɾ��clazz��ʾ���Ӧ�ı��еļ�¼(ָ������ֵid�ļ�¼)
	 * @param clazz
	 * @param id
	 */
	public void delete(Class clazz, int id);
	/**
	 * ɾ�����������ݿ��ж�Ӧ�ļ�¼(�������ڵ����Ӧ����,�����������ֵ��Ӧ����¼)
	 * @param obj
	 */
	public void delete(Object obj);
	
	/**
	 * ���¶����Ӧ�ļ�¼������ֻ����ָ�����ֶε�ֵ
	 * @param obj ��Ҫ���µĶ���
	 * @param fieldNames ���µ������б�
	 * @return ִ��sql���Ӱ���¼������
	 */
	public int update(Object obj, String[] fieldNames);
	
	/**
	 * ��ѯ���ض��м�¼������ÿ�м�¼��װ��clazzָ������Ķ�����
	 * @param sql ��ѯ���
	 * @param clazz ��װ���ݵ�javabean���Class����
	 * @param params sql����
	 * @return ��ѯ���Ľ��
	 */
	public List queryRows(String sql, Class clazz, Object[] params);
	
	/**
	 * ��ѯ����һ�м�¼�������ü�¼��װ��clazzָ������Ķ�����
	 * @param sql ��ѯ���
	 * @param clazz ��װ���ݵ�javabean���Class����
	 * @param params sql����
	 * @return ��ѯ���Ľ��
	 */
	public Object queryUniqueRow(String sql, Class clazz, Object[] params);
	
	/**
	 * ��ѯ����һ��ֵ(һ��һ��)��������ֵ����
	 * @param sql ��ѯ���
	 * @param params sql����
	 * @return ��ѯ���Ľ��
	 */
	public Object queryValue(String sql, Object[] params);
	
	/**
	 * ��ѯ����һ������(һ��һ��)��������ֵ����
	 * @param sql ��ѯ���
	 * @param params sql����
	 * @return ��ѯ��������
	 */
	public Number queryNumber(String sql, Object[] params);
	
}
