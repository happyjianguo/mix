package com.atguigu.spring.beans.test;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.jdom2.xpath.XPath;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by joshua on 16/6/4.
 */
public class ClassPathXmlApplicationContext implements BeanFactory {
    private Map<String, Object> container = new HashMap<String, Object>();

    public ClassPathXmlApplicationContext(String fileName) throws Exception{
        SAXBuilder sb = new SAXBuilder();
        String f = this.getClass().getClassLoader().getResource(fileName).getPath();
        System.out.println(f);
        Document doc = sb.build(this.getClass().getClassLoader().getResourceAsStream(fileName));
        Element root = doc.getRootElement();
        List list = XPath.selectNodes(root, "/beans/bean");

        for(int i=0;i<list.size();i++){
            Element bean = (Element)list.get(i);
            String id = bean.getAttributeValue("id");
            String clazz = bean.getAttributeValue("class");
            Object o = Class.forName(clazz).newInstance();

            container.put(id, o);

            System.out.println("id=" + id);
            System.out.println("通过id拿到具体的class信息：" +"class");
        }
    }

    @Override
    public Object getBean(String id) {
        return container.get(id);
    }
}
