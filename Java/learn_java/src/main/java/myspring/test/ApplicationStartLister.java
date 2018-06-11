package myspring.test;

import myspring.core.ApplicationEvent;
import myspring.core.ApplicationListener;

public class ApplicationStartLister implements ApplicationListener<ApplicationEvent> {

    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("SpringImpl App start");
    }
}
