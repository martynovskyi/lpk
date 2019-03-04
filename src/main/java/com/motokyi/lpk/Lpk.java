package com.motokyi.lpk;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class Lpk {
    public static void main(String[] args) {
        new SpringApplicationBuilder(Lpk.class)
                .headless(false)
                .run(args);
    }
}
