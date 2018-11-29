package com.faber.controller;

//<editor-fold defaultstate="collapsed" desc="IMPORT">
import com.faber.business.Demo;
import com.faber.main.Main;
import com.faber.service.HelloRequest;
import com.faber.service.HelloResponse;
import com.faber.service.HelloServiceGrpc;
import io.grpc.stub.StreamObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
public class Controller {

    @Autowired
    Demo demo;

    //<editor-fold defaultstate="collapsed" desc="DEFER RESULT">
    @RequestMapping(value = "/", method = GET)
    public DeferredResult<String> index() {
        DeferredResult<String> output = new DeferredResult<>();

        HelloServiceGrpc.HelloServiceStub stub = HelloServiceGrpc.newStub(
                Main.channel);

        stub.hello(HelloRequest.newBuilder()
                .setFirstName("Baeldung")
                .setLastName("gRPC")
                .build(), new StreamObserver<HelloResponse>() {
               String response = null;

               @Override
               public void onNext(HelloResponse value) {
                   response = value.getGreeting();
               }

               @Override
               public void onError(Throwable t) {
               }

               @Override
               public void onCompleted() {
                   output.setResult("hahahah");
               }
           });
        return output;
    }
    //</editor-fold>

    @RequestMapping(value = "/", method = POST)
    public String postSample() {
        return "index";
    }

    @RequestMapping(value = "/exception", method = GET)
    public String exception() {
        int a = 1 / 0;
        return "index";
    }

}
