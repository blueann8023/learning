package me.lm.servicesayhi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by blue_ann on 26/11/2018.
 */
@SpringBootApplication
@EnableEurekaClient
@RestController
public class ServiceSayHiApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceSayHiApplication.class);
    }

    @Value("${server.port}")
    private String port;

    @RequestMapping("/hi")
    public String home(@RequestParam(value = "name", defaultValue = "lm") String name) {
        return "hi " + name + " ,i am from port:" + port;
    }
}

