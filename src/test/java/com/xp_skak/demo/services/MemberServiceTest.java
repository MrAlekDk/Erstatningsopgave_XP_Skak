package com.xp_skak.demo.services;

import com.xp_skak.demo.models.Member;
import com.xp_skak.demo.repositories.MembersRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static reactor.core.publisher.Mono.when;

class MemberServiceTest {

    @Mock
    MembersRepository memberRep;

    @InjectMocks
    MemberService memberService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        Member memberTest = new Member("Alek", new Date(), "42424242", "email@gmail.com");
        Member memberTest2 = new Member("Jens", new Date(), "42424242", "email@gmail.com");
        Member memberTest3 = new Member("Bent", new Date(), "42424242", "email@gmail.com");
        Member memberTest4 = new Member("Kurt", new Date(), "42424242", "email@gmail.com");

        List<Member> testList = new ArrayList<>();
        testList.add(memberTest);
        testList.add(memberTest2);
        testList.add(memberTest3);
        testList.add(memberTest4);

        Mockito.when(memberRep.findById(1L)).thenReturn(java.util.Optional.of(memberTest));

        Mockito.when(memberRep.findAll()).thenReturn(testList);


    }

    @Test
    void getAllMembersTest() {
        List<Member> testList = memberService.getAllMembers();

        assertEquals(4, testList.size());
        Mockito.verify(memberRep, times(1)).findAll();
    }

    @Test
    void getSpecificMemberTest() {
        Member tmp = memberService.getSpecificMember(1L);

        assertEquals("Alek", tmp.getName());
        assertEquals("42424242", tmp.getPhoneNr());
        assertEquals("email@gmail.com", tmp.getEmail());
        Mockito.verify(memberRep, times(1)).findById(1L);
    }

    @Test
    void createNewMember() {
        Member memberTest = new Member("Alek", new Date(), "42424242", "email@gmail.com");

        memberService.addNewMember(memberTest);

        Mockito.verify(memberRep, times(1)).save(Mockito.any(Member.class));
    }

    @Test
    void updateMemberTest() {
        Member memberToUpdate = memberService.getSpecificMember(1L);
        memberToUpdate.setId(1L);

        memberService.updateMember(memberToUpdate);
        memberToUpdate.setName("Alexander");

        memberService.updateMember(memberToUpdate);


        assertEquals("Alexander", memberService.getSpecificMember(1L).getName());
        Mockito.verify(memberRep, times(2)).save(memberToUpdate);

    }

    @Test
    void deleteMemberTest() {

        Member test = new Member("Alek", new Date(), "10101010", "email@c.com");

        Mockito.when(memberRep.findById(test.getId())).thenReturn(Optional.of(test));
        memberService.deleteMemberById(test.getId());

        Mockito.verify(memberRep).deleteById(test.getId());
    }
}