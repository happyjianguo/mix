package com.fanteathy;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {
        IHelloWorld ihw = new HelloWorldImpl();
//        IHelloWorld ihw;
        ihw.sayHello();
    }
}
