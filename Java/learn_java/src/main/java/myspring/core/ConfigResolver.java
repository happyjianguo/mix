package myspring.core;

import myspring.annotation.Resources;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;

public class ConfigResolver extends ApplicationEvent implements ApplicationEventMulticaster {

    private String configXml = "myspring.xml";
    static HashMap<String, Object> BeanFactory;
    static HashMap<String, ApplicationListener> RegistryListener;

    static {
        BeanFactory = new HashMap<String, Object>();
        RegistryListener = new HashMap<String, ApplicationListener>();
    }

    public ConfigResolver(String config) {
        configXml = config == null ? configXml : config;
        setConfigLocations(configXml);
        refresh();
    }

    public Object getBean(String beanId) {
        return BeanFactory.get(beanId);
    }

    private void setConfigLocations(String configXml) {

    }

    private void refresh() {
        //注册bean
        invokeBeanFactoryPostProcessors(BeanFactory);
        //登记监听者
        registerListeners();
        //j结束刷新 表面程序已经启动 可以广播这个刷新完毕事件了 广播事件
        finishRefresh();
    }

    private void registerListeners() {
        Iterator<String> it = BeanFactory.keySet().iterator();
        while (it.hasNext()) {
            String key = it.next();
            if (BeanFactory.get(key) instanceof ApplicationListener) {
                RegistryListener.put(key, (ApplicationListener) BeanFactory.get(key));
                it.remove();
            }
        }
    }

    private void invokeBeanFactoryPostProcessors(HashMap beanFactory) {

        InputStream in = null;
        try {
            in = ConfigResolver.class.getResourceAsStream(configXml) == null ? new FileInputStream(configXml) : ConfigResolver.class.getResourceAsStream(configXml);//兼容资源路径 与 绝对路径
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document dc = db.parse(in);
            NodeList nl = dc.getElementsByTagName("bean");
            for (int i = 0; i < nl.getLength(); i++) {
                NamedNodeMap attrs = nl.item(i).getAttributes();
                HashMap<String, String> beanMap = new HashMap<String, String>();//对应一个bean标签
                for (int j = 0; j < attrs.getLength(); j++) {
                    String beanNodeName = attrs.item(j).getNodeName();
                    String beanNodeValue = null;
                    if (beanNodeName != null) {
                        beanNodeValue = attrs.item(j).getNodeValue();
                    }
                    if (beanNodeValue != null) {
                        beanMap.put(beanNodeName, beanNodeValue);
                    }
                }
                String beanId = beanMap.get("id");
                String beanClass = beanMap.get("class");
                if (beanClass == null || beanId == null) {
                    continue;
                }
                try {
                    Class cls = Class.forName(beanClass);
                    Object beanObject = cls.newInstance();
                    Field[] fds = beanObject.getClass().getDeclaredFields();
                    for (Field fd : fds) {
                        fd.setAccessible(true);//获取访问私有变量权限
                        Resources rs = fd.getAnnotation(Resources.class);
                        if (rs != null) {
                            fd.set(beanObject, fd.getType().newInstance());//实例化带有Resource注解的成员
                        }
                    }
                    beanFactory.put(beanId, beanObject);//将bean放到map
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void finishRefresh() {
        publishEvent(this);
    }

    public void publishEvent(ApplicationEvent event) {
        Iterator<String> it = RegistryListener.keySet().iterator();
        while (it.hasNext()) {
            RegistryListener.get(it.next()).onApplicationEvent(event);
        }
    }
}
