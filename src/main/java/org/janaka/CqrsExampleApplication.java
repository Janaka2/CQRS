package org.janaka;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class CqrsExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(CqrsExampleApplication.class, args);
    }
}
