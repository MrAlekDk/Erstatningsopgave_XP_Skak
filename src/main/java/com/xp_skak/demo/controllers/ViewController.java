package com.xp_skak.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
public class ViewController {

    @GetMapping(value ="/cashier")
    public String getMemberOverview(){
        return "memberOverview";
    }

    @GetMapping(value="/match-registration")
    public String registerMatch(){
        return "matchRegistration.html";
    }

    @GetMapping(value ="/cashier/restance")
    public String getMemberInRestanceOverview(){
        return "membersInRestanceOverview.html";
    }
}
