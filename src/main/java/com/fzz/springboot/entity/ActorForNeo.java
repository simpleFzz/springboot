package com.fzz.springboot.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.voodoodyne.jackson.jsog.JSOGGenerator;
import org.neo4j.ogm.annotation.*;

/**
 * @ClassName ActorForNeo
 * @Description
 * @Author fzz
 * @Date 2018/10/29
 **/

@JsonIdentityInfo(generator = JSOGGenerator.class)
@NodeEntity(label = "ActorForNeo")
public class ActorForNeo {

    @GraphId
    private Long id;
    @Property(name = "name")
    private String name;
    @Property(name = "born")
    private int born;

    public ActorForNeo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBorn() {
        return born;
    }

    public void setBorn(int born) {
        this.born = born;
    }
}
