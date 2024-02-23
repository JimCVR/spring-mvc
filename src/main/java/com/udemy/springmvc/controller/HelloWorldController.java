package com.udemy.springmvc.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    @RequestMapping("/showform")
    public String showForm() {
        return "helloworld-form";
    }

    @RequestMapping("/processform")
    public String processForm() {
        return "helloworld-processForm";
    }

    @RequestMapping("/processformV2")
    public String processFormV2(HttpServletRequest request, Model model) {
        var name = request.getParameter("studentName").toUpperCase();
        var result = "Yo! " + name;
        model.addAttribute("message", result);
        return "helloworld-processForm";
    }

    @PostMapping("/processformV3")
    public String processFormV3(@RequestParam("studentName") String name, Model model) {
        var result = "Hello! " + name;
        model.addAttribute("message", result);
        return "helloworld-processForm";
    }
}
