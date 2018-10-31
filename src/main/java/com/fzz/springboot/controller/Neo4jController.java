package com.fzz.springboot.controller;

import com.fzz.springboot.entity.ActorForNeo;
import com.fzz.springboot.entity.MovieForNeo;
import com.fzz.springboot.neo4j.ActorRepository;
import com.fzz.springboot.neo4j.MovieRepository;
import com.fzz.springboot.neo4j.RoleForNeoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName Neo4jController
 * @Description
 * @Author fzz
 * @Date 2018/10/29
 **/
@Controller
@RequestMapping("/neo4j")
public class Neo4jController {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    ActorRepository actorRepository;

    @Autowired
    RoleForNeoRepository roleForNeoRepository;

    @RequestMapping("setData")
    @ResponseBody
    public void setDate() {
        movieRepository.deleteAll();
        MovieForNeo matrix1 = new MovieForNeo();
        matrix1.setTitle("The Matrix");
        matrix1.setYears("1999-03-31");
//        movieRepository.save(matrix1);

        MovieForNeo matrix2 = new MovieForNeo();
        matrix2.setTitle("The Matrix Reloaded");
        matrix2.setYears("2003-05-07");
//        movieRepository.save(matrix2);

        MovieForNeo matrix3 = new MovieForNeo();
        matrix3.setTitle("The Matrix Revolutions");
        matrix3.setYears("2003-10-27");
//        movieRepository.save(matrix3);

        ActorForNeo keanu = new ActorForNeo();
        keanu.setName("Keanu Reeves");
//        actorRepository.save(keanu);

        ActorForNeo laurence = new ActorForNeo();
        laurence.setName("Laurence Fishburne");
//        actorRepository.save(laurence);

        ActorForNeo carrieanne = new ActorForNeo();
        carrieanne.setName("Carrie-Anne Moss");
//        actorRepository.save(carrieanne);

        matrix1.addRoleForNeo(keanu, "Neo");
        matrix1.addRoleForNeo(laurence, "Morpheus");
        matrix1.addRoleForNeo(carrieanne, "Trinity");
        movieRepository.save(matrix1);
        matrix2.addRoleForNeo(keanu, "Neo");
        matrix2.addRoleForNeo(laurence, "Morpheus");
        matrix2.addRoleForNeo(carrieanne, "Trinity");
        movieRepository.save(matrix2);
        matrix3.addRoleForNeo(keanu, "Neo");
        matrix3.addRoleForNeo(laurence, "Morpheus");
        matrix3.addRoleForNeo(carrieanne, "Trinity");
        movieRepository.save(matrix3);
    }

    @RequestMapping("getData")
    @ResponseBody
    public MovieForNeo getData(){
        MovieForNeo the_matrix = movieRepository.findByTitle("The Matrix");
        return  the_matrix;
    }

}
