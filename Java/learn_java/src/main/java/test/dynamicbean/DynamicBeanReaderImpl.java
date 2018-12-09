package test.dynamicbean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.xml.ResourceEntityResolver;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * bean动态加载实现类
 *
 * @author chuanshi - 2018-12-09 19:30
 */
public class DynamicBeanReaderImpl implements DynamicBeanReader, ApplicationContextAware {

    public static final Logger logger = LoggerFactory.getLogger(DynamicBeanReaderImpl.class);

    private ConfigurableApplicationContext applicationContext = null;

    private XmlBeanDefinitionReader beanDefinitionReader;

    public void init() {
        beanDefinitionReader = new XmlBeanDefinitionReader((BeanDefinitionRegistry) applicationContext.getBeanFactory());
        beanDefinitionReader.setEntityResolver(new ResourceEntityResolver(applicationContext));
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = (ConfigurableApplicationContext) applicationContext;
    }

    @Override
    public void loadBean(DynamicBean dynamicBean) {
        long startTime = System.currentTimeMillis();
        String beanName = dynamicBean.getBeanName();
        if (applicationContext.containsBean(beanName)) {
            logger.warn("bean【" + beanName + "】已经加载！");
            return;
        }
        beanDefinitionReader.loadBeanDefinitions(new DynamicResource(dynamicBean));
        logger.info("初始化bean【" + dynamicBean.getBeanName() + "】耗时" + (System.currentTimeMillis() - startTime) + "毫秒。");
    }
}
