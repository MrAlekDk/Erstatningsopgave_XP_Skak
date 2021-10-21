package com.xp_skak.demo.repositories;


import com.xp_skak.demo.models.Member;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembersRepository extends CrudRepository<Member,Long> {
}
