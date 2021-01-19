package po;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="book")
public class BookBean {
	@Id
	@Column(name="id")
	@GeneratedValue
	private int id;
	@Column(name="bookName")
	private String bookName;
	@Column(name="bookNum")
	private String bookNum;
	@Column(name="author")
	private String author;
	@Column(name="price")
	private float price;
	@ManyToOne
	@JoinColumn(name="publisher")
	private PublisherBean publisher;
	@Column(name="pubDate")
	private String pubDate;
	public BookBean(){}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public PublisherBean getPublisher() {
		return publisher;
	}
	public void setPublisher(PublisherBean publisher) {
		this.publisher = publisher;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookNum() {
		return bookNum;
	}
	public void setBookNum(String bookNum) {
		this.bookNum = bookNum;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getPubDate() {
		return pubDate;
	}
	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}
}
