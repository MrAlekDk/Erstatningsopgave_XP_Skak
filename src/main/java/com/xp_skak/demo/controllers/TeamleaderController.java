package com.xp_skak.demo.controllers;

import com.xp_skak.demo.models.Match;
import com.xp_skak.demo.models.Member;
import com.xp_skak.demo.services.MatchService;
import com.xp_skak.demo.services.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080/match-registration")
@RequestMapping("/matches")
public class TeamleaderController {

    MemberService memberService;
    MatchService matchService;

    public TeamleaderController(MemberService memberService, MatchService matchService){
        this.memberService = memberService;
        this.matchService = matchService;
    }

    @GetMapping
    public ResponseEntity<List<Match>> getAllMatches(){
        List<Match> allMatches = matchService.getAllMatches();
        return ResponseEntity.status(HttpStatus.OK).body(allMatches);
    }

    @PostMapping
    public ResponseEntity<Match> saveMatch(@RequestBody Match match) {
        System.out.println("Vi ramte endpointet");
        System.out.println(match.getWinnerMember().getName());
        matchService.saveMatch(match);
        memberService.updateRank(match.getWinnerMember(), match.getLoserMember());
        return ResponseEntity.status(HttpStatus.OK).body(match);
    }

    @GetMapping
    @RequestMapping(value = "/tournaments")
    public ResponseEntity<List<Match>> getAllTournaments(){
        List<Match> allTournaments = matchService.getAllMatches();
        return ResponseEntity.status(HttpStatus.OK).body(allTournaments);
    }
}
