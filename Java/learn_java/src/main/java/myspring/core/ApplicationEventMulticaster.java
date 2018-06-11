package myspring.core;

public interface ApplicationEventMulticaster {
    void publishEvent(ApplicationEvent event);
}
