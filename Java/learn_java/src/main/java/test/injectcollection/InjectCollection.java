package test.injectcollection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by joshua on 17/4/13.
 */
public class InjectCollection {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("injectCollection.xml");
        JavaCollection jc = (JavaCollection) ctx.getBean("javaCollection");
        jc.getAddressList();
        jc.getAddressSet();
        jc.getAddressMap();
        jc.getAddressProp();
    }
}
