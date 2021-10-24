package com.xp_skak.demo.controllers;

import com.xp_skak.demo.models.Member;
import com.xp_skak.demo.services.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

        return ResponseEntity.status(HttpStatus.OK).body(allMembers);
    }


    @PostMapping(
            value = "/members")
    public ResponseEntity<Member> createNewMember(@RequestBody String test){
        System.out.println(test);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping(value = "/members/{id}")
    public ResponseEntity<Member> updateMemberInformation(@RequestBody Member test, @PathVariable("id") String id){
        System.out.println();

        return ResponseEntity.status(HttpStatus.OK).build();
    }



    @DeleteMapping(value = "/members/{id}")
    public ResponseEntity<Member> deleteMember(@PathVariable("id") Long id){

        memberService.deleteMemberById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
