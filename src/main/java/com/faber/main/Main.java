package com.faber.main;

//<editor-fold defaultstate="collapsed" desc="IMPORT">
import io.grpc.ManagedChannel;
import io.grpc.netty.NettyChannelBuilder;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.cache.annotation.EnableCaching;
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
@EnableCaching
public class Main {

    public static ManagedChannel channel = null;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        int coreProcess = Runtime.getRuntime().availableProcessors();//Get num of core process of OS
        EventLoopGroup bossEventGroup = new NioEventLoopGroup(coreProcess * 2);// should be = core process for best performance

        //Create GRPC client to host
        channel = NettyChannelBuilder.forAddress("172.30.4.165", 8085)
                .usePlaintext()//get response as plain text
                .enableRetry()//enable retry when lost connection
                .maxRetryAttempts(5)//attempt to connect 5 times before throw error
                .maxInboundMessageSize(Integer.MAX_VALUE)//
                .eventLoopGroup(bossEventGroup)// thread for execute request
                .enableFullStreamDecompression()//enable compression stream in client and server
                .executor(new ForkJoinPool(coreProcess * 4, ForkJoinPool.defaultForkJoinWorkerThreadFactory, (Thread t, Throwable e) -> {
                    t.interrupt();
                }, true))
                .build();
    }

    //<editor-fold defaultstate="collapsed" desc="TOMCAT CONFIG">
    @Bean
    public ConfigurableServletWebServerFactory webServerFactory() {
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
        factory.setProtocol("org.apache.coyote.http11.Http11Nio2Protocol");

        factory.setPort(9000);
        List<TomcatConnectorCustomizer> cs = new ArrayList();

//        factory.setTomcatConnectorCustomizers(new Collection<TomcatConnectorCustomizer>);
        factory.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/notfound.html"));
        return factory;
    }
    //</editor-fold>

}
