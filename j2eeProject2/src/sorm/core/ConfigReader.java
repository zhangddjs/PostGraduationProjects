package sorm.core;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import sorm.bean.JdbcInfo;

/*
 * 读取xml配置文件sys-config.xml
 * 采用单例模式
 */
public class ConfigReader {
    private static ConfigReader instance = new ConfigReader();
    private Document doc;
    private JdbcInfo jdbcInfo;
    private ConfigReader() {
        try {
             doc = new SAXReader().read(Thread.currentThread()
                    .getContextClassLoader().getResourceAsStream(
                            "DataBase.xml"));
             
                jdbcInfo = new JdbcInfo();
                Element driverNameElt = (Element)doc.selectObject("/config/db-info/driver-name");
                Element urlElt = (Element)doc.selectObject("/config/db-info/url");
                Element usernameElt = (Element)doc.selectObject("/config/db-info/username");
                Element passwordElt = (Element)doc.selectObject("/config/db-info/password");
                
                jdbcInfo.setDbDriver(driverNameElt.getStringValue());
                jdbcInfo.setDbUrl(urlElt.getStringValue());
                jdbcInfo.setDbUser(usernameElt.getStringValue());
                jdbcInfo.setDbPwd(passwordElt.getStringValue());
        } catch (DocumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static ConfigReader getInstance() {
        return instance;
    }
    
    public JdbcInfo getJdbcInfo(){
        return jdbcInfo;
    }
    
    public static void main(String[] args) {
        System.out.println(ConfigReader.getInstance().getJdbcInfo().getDbDriver());
    }
}