package com.xp_skak.demo.services;


import com.xp_skak.demo.models.Member;
import com.xp_skak.demo.repositories.MembersRepository;
import com.xp_skak.demo.repositories.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberService {

    MembersRepository memberRep;
    PaymentRepository paymentRepository;


    public MemberService(MembersRepository memberRep, PaymentRepository paymentRep){
        this.memberRep = memberRep;
        this.paymentRepository = paymentRep;
    }

    public List<Member> getAllMembers() {
        List<Member> allMembers = new ArrayList<>();
        memberRep.findAll().forEach(allMembers::add);
        return allMembers;
    }

    public Member getSpecificMember(Long i) {
        System.out.println(paymentRepository.findById(Long.valueOf(100)).get().getId());
        return memberRep.findById(i).get();
    }

    public void deleteMemberById(Long id) {


        memberRep.deleteById(id);
    }

    public void addNewMember(Member member) {
        memberRep.save(member);
    }

    public void updateMember(Member memberUpdated) {

        Member memberToUpdate = memberRep.findById(memberUpdated.getId()).get();

        memberToUpdate = memberUpdated;
        memberRep.save(memberToUpdate);
    }
}
