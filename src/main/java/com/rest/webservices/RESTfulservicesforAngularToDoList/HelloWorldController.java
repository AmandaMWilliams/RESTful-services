package com.rest.webservices.RESTfulservicesforAngularToDoList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//CONTROLLER
@RestController
public class HelloWorldController {
    //GET
    // URI - /HELLO-WORLD
    @GetMapping(path="/hello-world")
    //METHOD
    public String helloWorld(){
        return "Hello World";
    }
}
