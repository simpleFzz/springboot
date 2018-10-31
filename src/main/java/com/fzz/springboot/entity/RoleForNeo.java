package com.fzz.springboot.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.voodoodyne.jackson.jsog.JSOGGenerator;
import org.neo4j.ogm.annotation.*;

/**
 * @ClassName RoleForNeo
 * @Description
 * @Author fzz
 * @Date 2018/10/29
 **/
@JsonIdentityInfo(generator = JSOGGenerator.class)
@RelationshipEntity(type = "ACTS_IN")
public class RoleForNeo {

    @GraphId
    Long id;
    @Property(value = "role")
    String role;
    @StartNode
    ActorForNeo actorForNeo;
    @EndNode
    MovieForNeo movieForNeo;

    public RoleForNeo() {
    }

    public RoleForNeo(String role, ActorForNeo actorForNeo, MovieForNeo movieForNeo) {
        this.role = role;
        this.actorForNeo = actorForNeo;
        this.movieForNeo = movieForNeo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public ActorForNeo getActorForNeo() {
        return actorForNeo;
    }

    public void setActorForNeo(ActorForNeo actorForNeo) {
        this.actorForNeo = actorForNeo;
    }

    public MovieForNeo getMovieForNeo() {
        return movieForNeo;
    }

    public void setMovieForNeo(MovieForNeo movieForNeo) {
        this.movieForNeo = movieForNeo;
    }
}
