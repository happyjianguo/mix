package myspring.core;

public interface ApplicationListener<T extends ApplicationEvent> {
    void onApplicationEvent(T event);
}
