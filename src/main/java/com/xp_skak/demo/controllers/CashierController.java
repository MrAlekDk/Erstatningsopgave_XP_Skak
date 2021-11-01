package com.xp_skak.demo.controllers;

import com.xp_skak.demo.models.Member;
import com.xp_skak.demo.services.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080/cashier")
@RequestMapping("/members")
public class CashierController {

    MemberService memberService;

    public CashierController(MemberService memberService){
        this.memberService= memberService;
    }

    @GetMapping
    public ResponseEntity<List<Member>> getAllMembers(){
        List<Member> allMembers = memberService.getAllMembers();
        return ResponseEntity.status(HttpStatus.OK).body(allMembers);
    }

    @PostMapping
    public ResponseEntity<Member> createNewMember(@RequestBody Member newMember){
        memberService.addNewMember(newMember);
        return ResponseEntity.status(HttpStatus.OK).body(newMember);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Member> updateMemberInformation(@RequestBody Member updatedMember){
        System.out.println(updatedMember.getRank());
        memberService.updateMember(updatedMember);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Member> deleteMember(@PathVariable("id") Long id){

        memberService.deleteMemberById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping(value = "/payments/{id}")
    public ResponseEntity<Member> addPayment(@PathVariable("id")Long id){

        memberService.registerPayment(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
