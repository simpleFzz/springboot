package com.fzz.springboot.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName User
 * @Description
 * @Author fzz
 * @Date 2018/10/25
 **/
@Document(collection = "user")
public class UserForMongo {

    @Id
    private String userId;
    @NotNull @Indexed(unique = true)
    private String username;
    @NotNull
    private String password;
    @NotNull
    private String name;
    @NotNull
    private String email;
    @NotNull
    private Date registrationDate = new Date();
    private Set<String> roles = new HashSet<>();

    public UserForMongo(){

    }
    public UserForMongo(String userId, String username, String password, String name, String email, Date registrationDate,
                        Set<String> roles){
            this.userId = userId;
            this.username = username;
            this.password = password;
            this.name = name;
            this.email = email;
            this.registrationDate = registrationDate;
            this.roles = roles;
    }

}
