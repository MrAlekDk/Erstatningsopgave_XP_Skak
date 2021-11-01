package com.xp_skak.demo.repositories;

import com.xp_skak.demo.models.Match;
import org.springframework.data.repository.CrudRepository;

public interface MatchRepository extends CrudRepository<Match, Integer> {
}
