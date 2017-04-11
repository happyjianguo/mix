package test.testcustomxml;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSimpleBeanDefinitionParser;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * Created by joshua on 17/4/11.
 */
public class JoshuaNamespaceParse extends AbstractSimpleBeanDefinitionParser {

    @Override
    protected Class<?> getBeanClass(Element element) {
        return Joshua.class;
    }

    @Override
    protected void doParse(Element element, BeanDefinitionBuilder builder) {
        String name = element.getAttribute("name");
        NodeList eles = element.getChildNodes();
        String alias = eles.item(0).getTextContent();
        String code = eles.item(1).getTextContent();
        builder.addPropertyValue("name", name);
        builder.addPropertyValue("alias", alias);
        builder.addPropertyValue("code", code);
    }
}
