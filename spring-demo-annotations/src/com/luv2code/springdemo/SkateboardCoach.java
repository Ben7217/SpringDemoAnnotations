package com.luv2code.springdemo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class SkateboardCoach implements Coach {

    @Autowired
    @Qualifier("fileFortuneService")
    private FortuneService fortuneService;

    // define a default constructor
    public SkateboardCoach() {
        System.out.println(">> Skateboard Coach: inside default constructor");
    }


    @Override
    public String getDailyWorkout() {
        return "Practice your ollies!";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

}
