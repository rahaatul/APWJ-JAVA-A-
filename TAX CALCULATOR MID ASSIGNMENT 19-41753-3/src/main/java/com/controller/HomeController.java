package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {

    @RequestMapping("/home")
    public String home() {
        return "home";
    }

    @RequestMapping("/greet")
    public String greet() {
        return "greet";
    }

    @RequestMapping("/sayHello")
    public String sayHello(HttpServletRequest request, Model model) {
        String username = request.getParameter("username");
        model.addAttribute("uname", username.toUpperCase());
        return "say-hello";
    }

    @RequestMapping("/sayHello2")
    public String sayHello2(@RequestAttribute("username") String username, Model model) {
        model.addAttribute("uname", username.toUpperCase());
        return "say-hello";
    }

    @RequestMapping("/sayHello3")
    public String sayHello3(@RequestAttribute("firstname") String firstname,@RequestAttribute("lastname") String lastname, Model model) {
        model.addAttribute("firstname", firstname.toUpperCase());
        model.addAttribute("lastname", lastname.toUpperCase());
        return "say-hello";
    }

    @RequestMapping("/calculator")
    public String calculator(@RequestAttribute("bsal") String bsal,@RequestAttribute("allo") String allo,@RequestAttribute("tax") String tax,@RequestAttribute("nsal") String nsal, Model model) {
        model.addAttribute("bsal", bsal.toUpperCase());
        model.addAttribute("nsal", nsal.toUpperCase());
        model.addAttribute("allo", allo.toUpperCase());
        model.addAttribute("tax", tax.toUpperCase());


        return "say-hello";
    }
}
