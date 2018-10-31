package com.fzz.springboot.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.mongodb.util.JSON;
import com.voodoodyne.jackson.jsog.JSOGGenerator;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import javax.persistence.GeneratedValue;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName MovieForNeo
 * @Description
 * @Author fzz
 * @Date 2018/10/29
 **/
@JsonIdentityInfo(generator = JSOGGenerator.class)
@NodeEntity
public class MovieForNeo implements Serializable {

    @GraphId
    Long id;
    private String title;
    private String years;
    private String tagline;

    @Relationship(type = "ACTS_IN",direction = Relationship.INCOMING)
    private List<RoleForNeo> roleForNeos = new ArrayList<>();

    public MovieForNeo() {
    }
    public RoleForNeo addRoleForNeo(ActorForNeo actorForNeo, String name){
        RoleForNeo roleForNeo = new RoleForNeo(name,actorForNeo,this);
        this.roleForNeos.add(roleForNeo);
        return roleForNeo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYears() {
        return years;
    }

    public void setYears(String years) {
        this.years = years;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public List<RoleForNeo> getRoleForNeos() {
        return roleForNeos;
    }

    public void setRoleForNeos(List<RoleForNeo> roleForNeos) {
        this.roleForNeos = roleForNeos;
    }
}
