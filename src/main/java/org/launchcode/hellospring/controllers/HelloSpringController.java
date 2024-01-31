package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloSpringController {
//    Handles request @ path /hello
//    @GetMapping("/hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";
//    }
//    @GetMapping("/goodbye")
//    public String goodbye() {
//        return "Goodbye, Spring!";
//    }
//    Handles requests of form /hello?name-Launch
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")
    public String hello(@RequestParam String name, Model model) {
        model.addAttribute("greeting", "Hello, " + name + "!");
        return "hello";
    }
//    Handles requests of formm /hello/LaunchCode
    @GetMapping("hello/{name}")
    @ResponseBody
    public String helloWithPathParam(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    @GetMapping("form")
    public String helloForm(){

        return "form";
    }
    @GetMapping("hello-names")
    public String helloNames(Model model) {
        List<String> names = new ArrayList<>();
        names.add("LaunchCode");
        names.add("java");
        names.add("JavaScript");
        model.addAttribute("names", names);
        return "hello-list";
    }
}


