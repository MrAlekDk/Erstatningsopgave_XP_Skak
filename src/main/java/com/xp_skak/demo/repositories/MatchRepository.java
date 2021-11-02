package com.xp_skak.demo.repositories;

import com.xp_skak.demo.models.Match;
import com.xp_skak.demo.models.Member;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MatchRepository extends CrudRepository<Match, Long> {

    /*
    @Query("delete from Match m where m.winnerMember = ?1")
    void deleteMatchesByWinnerId(Long winnerMember);



    @EntityGraph(value = "Match.winnerMember", type = EntityGraph.EntityGraphType.FETCH)
    Match findByWinnerMemberIdOOrLoserMember_Id(Long winnerMemberId, Long loserMemberId);


    @EntityGraph(value = "Match.loserMember", type = EntityGraph.EntityGraphType.FETCH)
    Match findByLoserMemberIdOrWinnerMemberId(Long id);
*/

    /*
    @Query("from Match r inner join fetch r.id where r.winner_member_id = :id")
    Match findBywinner_member_id(@Param("id") int id);
    */

}
