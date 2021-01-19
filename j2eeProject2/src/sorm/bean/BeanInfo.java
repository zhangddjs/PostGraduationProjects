package sorm.bean;

public class BeanInfo {
	
	private String className;
	private String beanName;
	private String table;
	private int id;
	private String[] properties;
	public String getBeanName() {
		return beanName;
	}
	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}
	public String getTable() {
		return table;
	}
	public void setTable(String table) {
		this.table = table;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String[] getProperties() {
		return properties;
	}
	public void setProperties(String[] properties) {
		this.properties = properties;
	}
	public BeanInfo(String beanName, int id, String[] properties) {
		super();
		this.beanName = beanName;
		this.id = id;
		this.properties = properties;
	}

	public BeanInfo() {
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
}
