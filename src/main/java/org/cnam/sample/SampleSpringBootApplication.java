package org.cnam.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.Entity;

@ComponentScan(basePackages = { "org.cnam.*"})
@EntityScan("org.cnam.sample.model")
@EnableJpaRepositories("org.cnam.sample.repository")
@EnableTransactionManagement
@EnableAutoConfiguration
public class SampleSpringBootApplication {

    //test commit mathieu
    public static void main(String[] args) throws Exception
    {
        SpringApplication.run(SampleSpringBootApplication.class, args);
    }
}
