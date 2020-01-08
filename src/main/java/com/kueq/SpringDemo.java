package com.kueq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan({"com.demo", "com.demo;"})
@SpringBootApplication
//All below are covered by springbootApplication annotation
//@Configuration
//@EnableAutoConfiguration
//@ComponentScan //scans for components in this particular package.
// To scan other packages, override @SpringBootApplication as @ComponentScan({"packagename1","packagename2"}) as above


public class SpringDemo {

    public static void main(String[] args) {
        SpringApplication.run(SpringDemo.class, args);
    }
}

