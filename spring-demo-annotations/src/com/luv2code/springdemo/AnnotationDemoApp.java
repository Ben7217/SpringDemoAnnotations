package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

    public static void main(String[] args) {

        // read spring config file
        ClassPathXmlApplicationContext context = new
                ClassPathXmlApplicationContext("applicationContext.xml");

        //get the bean from spring container
        Coach skateCoach = context.getBean("tennisCoach", Coach.class);

        //call a method on the bean

        System.out.println(skateCoach.getDailyWorkout());

        // call method to get the daily fortune
        System.out.println(skateCoach.getDailyFortune());

        //close the context
        context.close();
    }
}
