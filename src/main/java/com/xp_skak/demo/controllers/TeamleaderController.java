package com.xp_skak.demo.controllers;

import com.xp_skak.demo.models.Match;
import com.xp_skak.demo.services.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:8080/match-registration")
public class TeamleaderController {

    MemberService memberService;

    @PostMapping
    public ResponseEntity<Match> saveMatch(@RequestBody Match match) {
        memberService.saveMatch(match);
        memberService.updateRank(match.getWinnerMember(), match.getLoserMember());
        return ResponseEntity.status(HttpStatus.OK).body(match);
    }
}
