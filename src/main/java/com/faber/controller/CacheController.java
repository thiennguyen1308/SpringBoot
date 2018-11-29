package com.faber.controller;

//<editor-fold defaultstate="collapsed" desc="IMPORT">
import com.faber.business.Demo;
import com.faber.main.Main;
import com.faber.service.HelloRequest;
import com.faber.service.HelloResponse;
import com.faber.service.HelloServiceGrpc;
import io.grpc.stub.StreamObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
//</editor-fold>

/**
 *
 * @author Nguyen Duc Thien
 * @email nguyenducthien@fabercompany.co.jp
 */
@RestController
public class CacheController {

    @Autowired
    Demo demo;

    @RequestMapping(value = "/cache", method = GET)
    public String cache(@RequestParam String name) {
        return demo.cacheDemo(name);
    }

    @RequestMapping(value = "/update-cache", method = GET)
    public String updateCache(@RequestParam String name) {
        return demo.updateCacheDemo(name);
    }

    @RequestMapping(value = "/del-cache", method = GET)
    public String cache() {
        demo.deleteCacheDemo();
        return "";
    }
}
