package com.xp_skak.demo.services;


import com.xp_skak.demo.models.Member;
import com.xp_skak.demo.repositories.MembersRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberService {

    MembersRepository memberRep;


    public MemberService(MembersRepository memberRep){
        this.memberRep = memberRep;
    }

    public List<Member> getAllMembers() {
        List<Member> allMembers = new ArrayList<>();
        memberRep.findAll().forEach(member -> allMembers.add(member));
        return allMembers;
    }

    public Member getSpecificMember(Long i) {
        return memberRep.findById(i).get();
    }

    public void deleteMemberById(Long id) {


        memberRep.deleteById(id);
    }

    public void addNewMember(Member member) {
        memberRep.save(member);
    }
}
