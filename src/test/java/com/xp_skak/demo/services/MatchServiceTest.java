package com.xp_skak.demo.services;

import com.xp_skak.demo.models.Member;
import com.xp_skak.demo.models.Tournament;
import com.xp_skak.demo.repositories.MatchRepository;
import com.xp_skak.demo.repositories.TournamentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;

class MatchServiceTest {

    @Mock
    MatchRepository matchRepository;
    @Mock
    TournamentRepository tournamentRepository;

    @InjectMocks
    MatchService matchService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        Tournament testTournament1 = new Tournament("TestNavn",500,new Date());
        Tournament testTournament2 = new Tournament("TestNavn2",501,new Date());

        List<Tournament> testList = new ArrayList<>();
        testList.add(testTournament1);
        testList.add(testTournament2);

        Mockito.when(tournamentRepository.findById(Long.valueOf(1))).thenReturn(java.util.Optional.of(testTournament1));

        Mockito.when(tournamentRepository.save(testTournament1)).thenReturn(testTournament1);

        Mockito.when(tournamentRepository.findAll()).thenReturn(testList);
    }


    @Test
    void getAllMatchesTest() {
    }

    @Test
    void saveMatchTest() {
    }

    @Test
    void getAllTournamentsTest(){
        List<Tournament> testList = matchService.getAllTournaments();
        assertEquals(2, testList.size());
        Mockito.verify(tournamentRepository, times(1)).findAll();
    }

    @Test
    void createNewTournamentTest(){
        Tournament tournamentTest = new Tournament("Alek'",5000 ,new Date());

        matchService.saveNewTournament(tournamentTest);

        Mockito.verify(tournamentRepository, times(1)).save(Mockito.any(Tournament.class));
    }

    @Test
    void updateTournamentTest(){
        Tournament tournamentToUpdate = matchService.getSpecificTournament(1L);
        tournamentToUpdate.setId(1L);

        //memberService.updateMember(memberToUpdate);
        tournamentToUpdate.setName("A new tournament name");

        matchService.updateTournament(tournamentToUpdate);


        assertEquals("A new tournament name", matchService.getSpecificTournament(1L).getName());
        Mockito.verify(tournamentRepository, times(1)).save(tournamentToUpdate);
    }

    @Test
    void deleteTournamentTest(){

        matchService.deleteTournamentById(1L);

        Mockito.verify(tournamentRepository).deleteById(1l);

        Mockito.when(tournamentRepository.findById(1L)).thenReturn(null);
        Mockito.verify(tournamentRepository, times(1)).deleteById(1L);
        //assertEquals(null,matchService.getSpecificTournament(1l));
    }

}