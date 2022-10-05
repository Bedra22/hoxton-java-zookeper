package com.zoo.zookeeperrr;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ZooRoutes {

    @GetMapping("/animal")
    public String getAllAnimal() {
        return "Lalalala";
    }
}
