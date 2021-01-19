package sorm.bean;

import java.util.Map;

/**
 * �洢��ṹ����Ϣ
 * @author zdd
 *
 */
public class TableInfo {
	
	/**
	 * ����
	 */
	private String tname;
	
	/**
	 * �����ֶε���Ϣ
	 */
	private Map<String,ColumnInfo> columns;

	/**
	 * Ψһ����(Ŀǰֻ�ܴ������ֻ��һ�����������)
	 */
	private ColumnInfo onlyPriKey;

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public Map<String, ColumnInfo> getColumns() {
		return columns;
	}

	public void setColumns(Map<String, ColumnInfo> columns) {
		this.columns = columns;
	}

	public ColumnInfo getOnlyPriKey() {
		return onlyPriKey;
	}

	public void setOnlyPriKey(ColumnInfo onlyPriKey) {
		this.onlyPriKey = onlyPriKey;
	}

	public TableInfo(String tname, Map<String, ColumnInfo> columns, ColumnInfo onlyPriKey) {
		super();
		this.tname = tname;
		this.columns = columns;
		this.onlyPriKey = onlyPriKey;
	}
	
	public TableInfo() {
	}
}
