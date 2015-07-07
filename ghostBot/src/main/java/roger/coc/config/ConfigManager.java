package roger.coc.config;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import roger.coc.config.dataobject.Common;
import roger.coc.config.dataobject.GlobalConfig;
import roger.coc.constant.SystemConstant;
import roger.coc.util.LogUtil;

/**
 * @author zirui.wzr
 * get/update bot config
 */
public class ConfigManager {

	public static DocumentBuilder db;
	private static Document dc;
	static
	{
		try
		{
			 db=DocumentBuilderFactory.newInstance().newDocumentBuilder();
			 dc=db.newDocument();
		}
		catch(Exception e)
		{
			LogUtil.log("ConfigManager init fail");
		}
	}
	private static GlobalConfig config;
	/**
	 * write config to hard disk
	 * @param congif
	 * @return
	 */
	public static boolean updateConfig(GlobalConfig config)
	{
		  Element element=config.getNode();
          Document document = db.newDocument();
          document.appendChild(element); 
          try {
        	  TransformerFactory tf = TransformerFactory.newInstance();
              Transformer transformer = tf.newTransformer();
              DOMSource source = new DOMSource(document);
              transformer.setOutputProperty(OutputKeys.ENCODING, "gb2312");
              transformer.setOutputProperty(OutputKeys.INDENT, "yes");
             URL url= System.class.getClassLoader().getResource(SystemConstant.CONFIG_PATH);
              PrintWriter pw = new PrintWriter(new FileOutputStream(url.getPath()+url.getFile()));
              StreamResult result = new StreamResult(pw);
              transformer.transform(source, result);
              LogUtil.log("update config sucess");
          } catch (Exception e)
          {
        	  LogUtil.log("update config fail"+e.getCause());
          }
          return true;
	}
	
	
	/**
	 * read config from hard disk
	 * @return
	 */
	public static boolean refreshConfig()
	{
		try
		{
	      Document document=db.parse(System.class.getClassLoader().getResourceAsStream(SystemConstant.CONFIG_PATH));//鎶婃枃浠惰В鏋愭垚DOCUMENT绫�
	      GlobalConfig config=new GlobalConfig();
	      //set name
	      config.parseNode(document.getDocumentElement()); 
	      return true;
		}
		catch(Exception e)
		{
			LogUtil.log("parse config file fail,"+e.getMessage());
			return false;
		}
	}
	
	
	/**
	 * get current config
	 * @return
	 */
	public static GlobalConfig getConfig()
	{
		return config;
	}
	
	public static Element getElement(String key,String value)
	{
		Element ele=dc.createElement(key);
		ele.appendChild(dc.createTextNode(value));
		return ele;
	}
}
