package com.mum.ea.socialnetwork.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

    @GetMapping("/")
    private String welcome(Model model){

        model.addAttribute("msg", "Hello Message");

        return "index";
    }
}
