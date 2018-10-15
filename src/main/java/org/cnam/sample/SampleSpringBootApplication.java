package org.cnam.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@EnableAutoConfiguration
public class SampleSpringBootApplication {

    public static void main(String[] args) throws Exception
    {
        SpringApplication.run(SampleSpringBootApplication.class, args);
    }
}
