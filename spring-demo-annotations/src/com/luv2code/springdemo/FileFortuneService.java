package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class FileFortuneService implements FortuneService {

    private String fileName ="/Users/BenMorrisRains/Downloads/spring-demo-annotations/src/fortune-data.txt";
    private List<String> theFortunes;

    // create random number gen

    private Random myRandom = new Random();

    public FileFortuneService() {
        System.out.println("Inside FileFortuneService constructor");

    }

    @PostConstruct
    private void loadFile() {

        File theFile = new File(fileName);

        System.out.println("reading from file: " + theFile);
        System.out.println("File exists: " + theFile.exists());

        //initialize the array list

        theFortunes = new ArrayList<>();

        //read fortunes from file
        try (BufferedReader br = new BufferedReader(new FileReader(theFile))) {
            String tempLine;

            while((tempLine = br.readLine()) != null) {
                theFortunes.add(tempLine);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public String getFortune() {
        int index = myRandom.nextInt(theFortunes.size());

        String tempFortune = theFortunes.get(index);

        return tempFortune;
    }
}
