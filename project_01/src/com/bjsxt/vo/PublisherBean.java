package com.bjsxt.vo;

public class PublisherBean {
	private int id;
	private String publisherNum;
	private String publisherName;
	public PublisherBean(){}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPublisherNum() {
		return publisherNum;
	}
	public void setPublisherNum(String publisherNum) {
		this.publisherNum = publisherNum;
	}
	public String getPublisherName() {
		return publisherName;
	}
	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}
	public PublisherBean(int id, String publisherNum, String publisherName) {
		super();
		this.id = id;
		this.publisherNum = publisherNum;
		this.publisherName = publisherName;
	}
	
}