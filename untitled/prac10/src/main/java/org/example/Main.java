package org.example;

import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

interface Programmer {
    void doCoding();
}

class Junior implements Programmer {
    @Override
    public void doCoding() {
        System.out.println("Junior programmer is coding.");
    }
}

class Middle implements Programmer {
    @Override
    public void doCoding() {
        System.out.println("Middle programmer is coding.");
    }
}

class Senior implements Programmer {
    @Override
    public void doCoding() {
        System.out.println("Senior programmer is coding.");
    }
}

@Configuration
class AppConfig {
    @Bean
    public Junior junior() {
        return new Junior();
    }

    @Bean
    public Middle middle() {
        return new Middle();
    }

    @Bean
    public Senior senior() {
        return new Senior();
    }
}

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please provide a bean name as an argument.");
            return;
        }

        String beanName = args[0];

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        try {
            Programmer programmer = (Programmer) context.getBean(beanName);
            programmer.doCoding();
        } catch (NoSuchBeanDefinitionException e) {
            System.out.println("Bean with name '" + beanName + "' not found.");
        }
    }
}
