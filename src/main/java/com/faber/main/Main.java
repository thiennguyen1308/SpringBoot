package com.faber.main;

//<editor-fold defaultstate="collapsed" desc="IMPORT">
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//</editor-fold>

/**
 *
 * @author Nguyen Duc Thien
 */
//@EnableAutoConfiguration
@SpringBootApplication
@EnableJpaRepositories("com.faber.repositories")
@EntityScan("com.faber.entities")
@ComponentScan("com.faber.*")
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

}
