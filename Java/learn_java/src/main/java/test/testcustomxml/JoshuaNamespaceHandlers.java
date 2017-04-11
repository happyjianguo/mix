package test.testcustomxml;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * Created by joshua on 17/4/11.
 */
public class JoshuaNamespaceHandlers extends NamespaceHandlerSupport {

    public static void main(String[] args) {
        System.out.println(JoshuaNamespaceHandlers.class);
    }

    public void init() {
        registerBeanDefinitionParser("josh", new JoshuaNamespaceParse());
    }
}
