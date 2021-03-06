package com.fzz.springboot.entity;


import javax.persistence.*;

/**
 * @ClassName Department
 * @Description
 * @Author fzz
 * @Date 2018/10/24
 **/
@Entity   //注意包名
@Table(name="DEPARTMENT")   //自动建表,与数据库对应
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

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
}
