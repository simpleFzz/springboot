package com.fzz.springboot.neo4j;

import com.fzz.springboot.entity.MovieForNeo;
import com.fzz.springboot.entity.RoleForNeo;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

/**
 * @ClassName RoleRepository
 * @Description
 * @Author fzz
 * @Date 2018/10/31
 **/
@Repository
public interface RoleForNeoRepository extends Neo4jRepository<RoleForNeo,Long> {
}
