package service;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;

import po.Publisher;
import util.DBUtil;
import util.StringUtils;

public class Session {
	private Connection conn;
	private Statement stm;
	private PreparedStatement pstm;
	private ResultSet rs;

	/**
	 * Session¹¹ÔìÆ÷
	 */
	public Session() {
		DBUtil db = new DBUtil();
		conn = db.getConnection();
	}

	
	public void save(Object obj) 
			throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class<?> classType = obj.getClass();
		Field[] fields = classType.getDeclaredFields();
		StringBuilder insertColumnName = new StringBuilder();
		StringBuilder insertColumnValue = new StringBuilder();
		StringBuilder sql = new StringBuilder();
		insertColumnName.append("(");
		//Method setMethod = classType.get
		for(int i = 1; i < fields.length; i++){
			Field f = fields[i];
			String fieldName = f.getName();
			Class<?> fieldType = f.getType();
			insertColumnName.append(fieldName);
			if (i != fields.length - 1) {
				insertColumnName.append(",");
			} else {
				insertColumnName.append(")values(");
			}
			String getMethodName = "get" + StringUtils.firstChar2UpperCase(fieldName);
			Method getMethod = classType.getMethod(getMethodName);
			insertColumnValue.append(getMethod.invoke(obj));
			if (i != fields.length - 1) {
				insertColumnValue.append(",");
			} else {
				insertColumnValue.append(")");
			}
		}
		sql.append("insert into publisher");
		System.out.println(sql.append(insertColumnName.append(insertColumnValue)).toString());
		
	}

	public void get(Object obj) {

	}

	public void delete(Object obj) {

	}

	public void update(Object obj) {

	}
	
}
