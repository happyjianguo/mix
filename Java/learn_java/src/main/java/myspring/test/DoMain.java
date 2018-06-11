package myspring.test;

import myspring.core.ConfigResolver;

public class DoMain {
    public static void main(String[] args) {
        ConfigResolver cfg = new ConfigResolver("/Users/chuanshi/code/mix/Java/learn_java/src/main/resources/myspring.xml");
        Blind b = (Blind) cfg.getBean("mybean");
        System.out.println(b.getEge().see());
    }
}
