package me.lm.servicefeign.controller;

import me.lm.servicefeign.service.SchedualServiceSayHi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by blue_ann on 26/11/2018.
 */
@RestController
public class HiController {

    @Autowired
    SchedualServiceSayHi schedualServiceSayHi;

    @GetMapping(value = "/hi")
    public String sayHi(@RequestParam String name) {
        return "feign:" + schedualServiceSayHi.sayHiFromClientOne( name );
    }
}
