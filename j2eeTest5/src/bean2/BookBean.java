package bean2;

public class BookBean {
	private int id;
	private String bookName;
	private String bookNum;
	private String author;
	private float price;
	private PublisherBean publisher;
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
