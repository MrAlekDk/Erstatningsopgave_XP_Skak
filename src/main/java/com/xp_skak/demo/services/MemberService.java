package com.xp_skak.demo.services;

import com.xp_skak.demo.models.Member;
import com.xp_skak.demo.models.Payment;
import com.xp_skak.demo.repositories.MatchRepository;
import com.xp_skak.demo.repositories.MembersRepository;
import com.xp_skak.demo.repositories.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MemberService {

    MembersRepository memberRep;
    PaymentRepository paymentRepository;
    MatchRepository matchRepository;


    public MemberService(MembersRepository memberRep, PaymentRepository paymentRep, MatchRepository matchrep) {
        this.memberRep = memberRep;
        this.paymentRepository = paymentRep;
        this.matchRepository = matchrep;
    }

    public List<Member> getAllMembers() {
        List<Member> allMembers = new ArrayList<>();
        memberRep.findAll().forEach(allMembers::add);
        return allMembers;
    }

    public Member getSpecificMember(Long i) {
        return memberRep.findById(i).get();
    }

    public void deleteMemberById(Long id) {
        memberRep.deleteById(id);
    }

    public void addNewMember(Member member) {
        Member tmp = memberRep.save(member);
        paymentRepository.save(new Payment(tmp.getId()));
    }

    public void updateMember(Member memberUpdated) {
        Member memberToUpdate = memberRep.findById(memberUpdated.getId()).get();

        memberToUpdate = memberUpdated;
        memberRep.save(memberToUpdate);
    }

    public void registerPayment(Long id) {
        Payment tmp = paymentRepository.findById(id).get();
        tmp.setLastPaymentDate(new Date());
        paymentRepository.save(tmp);
    }

    public void updateRank(long winnerId, long loserId) {
        Member winningMember = memberRep.findById(winnerId).get();
        Member losingMember = memberRep.findById(loserId).get();
        int loserPoint = 3;
        int winnerPoint = 3;

        winningMember.setRank(winningMember.getRank() + winnerPoint);
        losingMember.setRank(losingMember.getRank() - loserPoint);

        memberRep.save(winningMember);
        memberRep.save(losingMember);
    }

}
