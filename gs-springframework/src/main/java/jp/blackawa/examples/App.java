package jp.blackawa.examples;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main( String[] args ) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        HelloService service = (HelloService) context.getBean("helloService");
        Hello hw = service.getHello();
        hw.sayHello();
    }
}
