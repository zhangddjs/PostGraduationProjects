package service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import po.BookBean;

public class TestBookService {
	@Test
	public void testAddBook(){
		BookBean book = new BookBean();
		book.setBookNum("SBN-001");
		book.setBookName("JavaEE");
		book.setAuthor("zdd");
		book.setPrice(88);
		
		@SuppressWarnings("resource")
		ApplicationContext context = 
				new ClassPathXmlApplicationContext(new String[] {"applicationContext.xml"});
		
		BookService bookService = (BookService) context.getBean("bookServiceBean", BookService.class);
		bookService.addBook(book, 2);
	}
	
//	@Test
//	public void testAddBook2(){
//		BookBean book = new BookBean();
//		book.setBookNum("SBN-002");
//		book.setBookName("Java");
//		book.setAuthor("zdd");
//		book.setPrice(88);
//		
//		@SuppressWarnings("resource")
//		ApplicationContext context = 
//				new ClassPathXmlApplicationContext(new String[] {"applicationContext.xml"});
//		
//		BookService2 bookService = (BookService2) context.getBean("bookServiceBean2", BookService2.class);
//		bookService.addBook(book, 3);
//	}
	
	@Test
	public void testGetBookList(){
		@SuppressWarnings("resource")
		ApplicationContext context = 
				new ClassPathXmlApplicationContext(new String[] {"applicationContext.xml"});
		
		BookService bookService = (BookService) context.getBean("BookServiceBean", BookService.class);
		bookService.getBookList();
	}
}
