package com.xp_skak.demo.repositories;

import com.xp_skak.demo.models.Tournament;
import org.springframework.data.repository.CrudRepository;

public interface TournamentRepository extends CrudRepository<Tournament, Long> {
}
