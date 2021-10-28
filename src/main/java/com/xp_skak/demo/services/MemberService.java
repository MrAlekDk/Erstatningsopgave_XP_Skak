package com.xp_skak.demo.services;


import com.xp_skak.demo.models.Member;
import com.xp_skak.demo.repositories.MembersRepository;
import com.xp_skak.demo.repositories.PaymentRepository;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MemberService {

    MembersRepository memberRep;
    PaymentRepository paymentRepository;



    public MemberService(MembersRepository memberRep, PaymentRepository paymentRep) {
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

    public static String setAgeCategory(Member member) {
        Date memberBirthday = member.getBirthday();
        LocalDateTime currentDay = LocalDateTime.now();

        int memberAge = (int) Duration.between((Temporal) memberBirthday, currentDay).toDays() / 365;
        //int memberAgeYear = memberAge / 365;



        String ageCategory = null;

        if (memberAge < 18) {
        ageCategory = "Junior";
        }
        if (memberAge >= 18 && memberAge < 60) {
        ageCategory = "Adult";
        }
        if (memberAge >= 60) {
        ageCategory = "Senior";
        }

        return ageCategory;
    }
}