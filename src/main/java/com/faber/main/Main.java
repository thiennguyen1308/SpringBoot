package com.faber.main;

//<editor-fold defaultstate="collapsed" desc="IMPORT">
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
//</editor-fold>

/**
 *
 * @author Nguyen Duc Thien
 */
//@EnableAutoConfiguration
@SpringBootApplication
@EntityScan("com.faber.entities")
@ComponentScan("com.faber.*")
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    //<editor-fold defaultstate="collapsed" desc="TOMCAT CONFIG">
    @Bean
    public ConfigurableServletWebServerFactory webServerFactory() {
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
        factory.setPort(9000);
        factory.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/notfound.html"));
        return factory;
    }
    //</editor-fold>

}
