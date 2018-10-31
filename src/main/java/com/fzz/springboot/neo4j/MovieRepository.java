package com.fzz.springboot.neo4j;

import com.fzz.springboot.entity.MovieForNeo;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.GraphRepositoryQuery;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
/**
 * @ClassName MovieRepository
 * @Description
 * @Author fzz
 * @Date 2018/10/29
 **/
@Repository
public interface MovieRepository extends Neo4jRepository<MovieForNeo,Long> {

    MovieForNeo findByTitle(@Param("title") String title);

}
