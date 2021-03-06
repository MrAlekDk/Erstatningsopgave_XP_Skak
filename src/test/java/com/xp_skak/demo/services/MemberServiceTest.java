package com.xp_skak.demo.services;

import com.xp_skak.demo.models.Member;
import com.xp_skak.demo.models.Payment;
import com.xp_skak.demo.repositories.MembersRepository;
import com.xp_skak.demo.repositories.PaymentRepository;
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
    @Mock
    PaymentRepository paymentRep;

    @InjectMocks
    MemberService memberService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        Member memberTest = new Member("Alek", new Date(), "42424242", "email@gmail.com");
        Member memberTest2 = new Member("Jens", new Date(), "42424242", "email@gmail.com");
        Member memberTest3 = new Member("Bent", new Date(), "42424242", "email@gmail.com");
        Member memberTest4 = new Member("Kurt", new Date(), "42424242", "email@gmail.com");

        Payment paymentTest = new Payment(Long.valueOf(1));

        List<Member> testList = new ArrayList<>();
        testList.add(memberTest);
        testList.add(memberTest2);
        testList.add(memberTest3);
        testList.add(memberTest4);

        Mockito.when(memberRep.findById(1L)).thenReturn(java.util.Optional.of(memberTest));

        Mockito.when(memberRep.save(memberTest)).thenReturn(memberTest);

        Mockito.when(memberRep.findAll()).thenReturn(testList);

        Mockito.when(paymentRep.findById(Long.valueOf(1))).thenReturn(java.util.Optional.of(paymentTest));
        Mockito.when(paymentRep.save(paymentTest)).thenReturn(paymentTest);


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
        memberTest.setId(1L);
        memberService.addNewMember(memberTest);

        Mockito.verify(memberRep, times(1)).save(Mockito.any(Member.class));
    }

    @Test
    void updateMemberTest() {
        Member memberToUpdate = memberService.getSpecificMember(1L);
        memberToUpdate.setId(1L);

        //memberService.updateMember(memberToUpdate);
        memberToUpdate.setName("Alexander S");

        memberService.updateMember(memberToUpdate);


        assertEquals("Alexander S", memberService.getSpecificMember(1L).getName());
        Mockito.verify(memberRep, times(1)).save(memberToUpdate);

    }

    @Test
    void deleteMemberTest() {

        Member test = new Member("Alek", new Date(), "10101010", "email@c.com");

        memberService.deleteMemberById(test.getId());

        Mockito.verify(memberRep).deleteById(test.getId());
    }

    @Test
    void registerPaymentTest(){
        Long id = Long.valueOf(1);
        Payment testPayment = new Payment(id);

        memberService.registerPayment(id);

        Mockito.verify(paymentRep, times(1)).findById(id);
        assertEquals(new Date(),testPayment.getLastPaymentDate());
        //Mockito.verify(paymentRep, times(1)).save(testPayment);
    }

}