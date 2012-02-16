package com.recepies;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class AutowiringExample {

    public static void main(String[] args) {
        ApplicationContext context = new FileSystemXmlApplicationContext("file:/projects/springrecepies/src/test/resources/testApplicationContext.xml");


    }

}