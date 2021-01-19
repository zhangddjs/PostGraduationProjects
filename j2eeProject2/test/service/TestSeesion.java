package service;


import java.lang.reflect.InvocationTargetException;

import org.junit.Test;

import po.Publisher;

public class TestSeesion {
	
	@Test
	public void testSave() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Session session = new Session();
		Publisher pub = new Publisher();
		pub.setPublisherName("java");
		pub.setPublisherNum("111");
		session.save(pub);
	}
	
	/*@Test
	public void testUpdata() {
		PublishBean bean=new PublishBean();
		bean.setPublishId(10);
		bean.setPublishName("鏈烘宸ヤ笟鍑虹増绀�");
		bean.setPublishNumber("10002");
		s.updata(bean, PublishBean.class);
	}
	
	@Test
	public void testDelete() {
		s.delete(9, PublishBean.class);
	}

	@Test
	public void testGet() {
		PublishBean bean=(PublishBean)s.get(10, PublishBean.class);
		System.out.println("鍑虹増绀惧悕绉帮細"+bean.getPublishName());
		System.out.println("鍑虹増绀剧紪鍙凤細"+bean.getPublishNumber());
	}*/
}
