package cn.edu.hfuu.util;

import java.lang.reflect.*;

import javax.servlet.http.HttpServletRequest;

import cn.edu.hfuu.po.Student;

public class SetBean {

	public static Object setBean(HttpServletRequest request, String className) throws Exception {
		Object object = null;

		Class clazz = Class.forName(className);
		object = clazz.newInstance();

		Field[] fields = clazz.getDeclaredFields();
		for (Field f : fields) {
			String fieldName = f.getName();
			String value = request.getParameter(fieldName);
			if (value != null) {
				// 调用对应的set方法赋值
				String methodName = "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);

				Method setMethod = clazz.getMethod(methodName, new Class[] { f.getType() });

				// 类型转换
				Object value2 = value;
				if ("int".equals(f.getType().getSimpleName())) {
					value2 = Integer.parseInt(value);
				}
				if ("float".equals(f.getType().getSimpleName())) {
					value2 = Integer.parseInt(value);
				}

				setMethod.invoke(object, new Object[] { value2 });

			}

		}

		return object;

	}

}
