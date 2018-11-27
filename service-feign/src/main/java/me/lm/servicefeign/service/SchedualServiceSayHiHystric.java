package me.lm.servicefeign.service;

import org.springframework.stereotype.Component;

/**
 * Created by blue_ann on 27/11/2018.
 */
@Component
public class SchedualServiceSayHiHystric implements SchedualServiceSayHi {
    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry," + name;
    }
}
