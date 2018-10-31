package com.fzz.springboot.neo4j;

import com.fzz.springboot.entity.ActorForNeo;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends Neo4jRepository<ActorForNeo,Long> {
}


