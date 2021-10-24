package com.xp_skak.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
public class ViewController {


    @GetMapping(value ="/cashier")
    public String getAllMembers(){
        return "memberOverview";
    }

    @GetMapping(value= "/newMember")
    public String getNewMemberForm(){
        return "createMember.html";
    }
}
