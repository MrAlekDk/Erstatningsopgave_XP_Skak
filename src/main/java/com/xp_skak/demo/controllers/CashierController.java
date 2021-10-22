package com.xp_skak.demo.controllers;

import com.xp_skak.demo.models.Member;
import com.xp_skak.demo.services.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class CashierController {

    MemberService memberService;

    public CashierController(MemberService memberService){
        this.memberService= memberService;
    }

    @GetMapping("/members")
    public ResponseEntity<List<Member>> getAllMembers(){

        List<Member> allMembers = memberService.getAllMembers();
        System.out.println(allMembers.get(0).getBirthday());
        return ResponseEntity.status(HttpStatus.OK).body(allMembers);
    }
}
