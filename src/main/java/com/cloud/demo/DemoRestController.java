package com.cloud.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DemoRestController {
    @GetMapping("/hello")
    public String hello(@RequestParam(value="name",required=false) String name)
    {
        return "Hello "+(name!=null?name:"");
    }
}