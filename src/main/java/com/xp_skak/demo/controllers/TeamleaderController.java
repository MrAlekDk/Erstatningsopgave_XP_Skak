package com.xp_skak.demo.controllers;

import com.xp_skak.demo.models.Match;
import com.xp_skak.demo.models.Member;
import com.xp_skak.demo.models.Tournament;
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

    @PostMapping(value="/{id_winner}/{id_loser}")
    public ResponseEntity<Match> saveMatch(@RequestBody Match match, @PathVariable("id_winner") long winnerId, @PathVariable("id_loser") long loserId) {
        matchService.saveMatch(match);
        memberService.updateRank(winnerId, loserId);
        return ResponseEntity.status(HttpStatus.OK).body(match);
    }

    @GetMapping
    @RequestMapping(value = "/tournaments")
    public ResponseEntity<List<Tournament>> getAllTournaments(){
        List<Tournament> allTournaments = matchService.getAllTournaments();
        return ResponseEntity.status(HttpStatus.OK).body(allTournaments);
    }

    @PostMapping(value = "/tournaments")
    public ResponseEntity<Tournament> createNewTournament(@RequestBody Tournament newTournament){
        matchService.saveNewTournament(newTournament);
        return ResponseEntity.status(HttpStatus.OK).body(newTournament);
    }

    @DeleteMapping(value="/tournaments/{id}")
    public ResponseEntity deleteSpecificTournament(@PathVariable("id") Long id){
        matchService.deleteTournamentById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping(value="/tournaments/{id}")
    public ResponseEntity updateSpecificTournament(@PathVariable("id") Long id, @RequestBody Tournament updatedTournament){
        matchService.updateTournament(updatedTournament);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
