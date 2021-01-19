package po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="publisher")
public class PublisherBean {
	@Id
	@Column(name="id")
	@GeneratedValue
	private int id;
	@Column(name="publisherNum")
	private String publisherNum;
	@Column(name="publisherName")
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

}
