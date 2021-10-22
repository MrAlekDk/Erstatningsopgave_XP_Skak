package com.xp_skak.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {


    @GetMapping(value ="/")
    public String getAllMembers(){
        return "memberOverview";
    }
}
