package sorm.core;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import sorm.bean.BeanInfo;

/*
 * 读取xml配置文件sys-config.xml
 * 采用单例模式
 */
public class BeanConfigReader {
    private static BeanConfigReader instance = new BeanConfigReader();
    private Document doc;
    private BeanInfo beanInfo;
    private int count;
    private BeanConfigReader() {
        try {
             doc = new SAXReader().read(Thread.currentThread()
                    .getContextClassLoader().getResourceAsStream(
                            "Bean.xml"));
             	count = 0;
             	beanInfo = new BeanInfo();
                @SuppressWarnings("unchecked")
				List<Element> beanNameElt = doc.selectNodes("/config/bean");
                for(Element elt:beanNameElt){
                	System.out.println(elt.attributeValue("name"));
                }
//                Element driverNameElt = (Element)doc.selectObject("/config/db-info/driver-name");
//                Element urlElt = (Element)doc.selectObject("/config/db-info/url");
//                Element usernameElt = (Element)doc.selectObject("/config/db-info/username");
//                Element passwordElt = (Element)doc.selectObject("/config/db-info/password");
                
//                jdbcInfo.setDbDriver(driverNameElt.getStringValue());
//                jdbcInfo.setDbUrl(urlElt.getStringValue());
//                jdbcInfo.setDbUser(usernameElt.getStringValue());
//                jdbcInfo.setDbPwd(passwordElt.getStringValue());
        } catch (DocumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static BeanConfigReader getInstance() {
        return instance;
    }
    
    public BeanInfo getBeanInfos(){
        return beanInfo;
    }
    
    public static void main(String[] args) {
        System.out.println(BeanConfigReader.getInstance().getBeanInfos());
    }
}