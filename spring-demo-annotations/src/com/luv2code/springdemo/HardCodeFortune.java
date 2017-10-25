package com.luv2code.springdemo;

public class HardCodeFortune implements FortuneService {


    @Override
    public String getFortune() {
        return "Wish upon a star tonight!";
    }
}
