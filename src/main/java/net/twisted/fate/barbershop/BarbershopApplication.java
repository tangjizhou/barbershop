package net.twisted.fate.barbershop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
public class BarbershopApplication {

    public static void main(String[] args) {
        SpringApplication.run(BarbershopApplication.class, args);
    }

}
