package com.fzz.springboot.controller;

import com.fzz.springboot.entity.Department;
import com.fzz.springboot.entity.Role;
import com.fzz.springboot.entity.User;
import com.fzz.springboot.redis.UserRedis;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("redis")
public class RedisController {

    @Autowired
    UserRedis userRedis;

    @RequestMapping("setup")
    public void setup(){
        Department department = new Department();
        department.setName("开发部");

        Role role = new Role();
        role.setName("admin");

        User user = new User();
        user.setName("fzz");
        user.setCreatedTime(new Date());
        user.setDepartment(department);

        List<Role> roles = new ArrayList<>();
        roles.add(role);

        user.setRoles(roles);

        userRedis.delete("fzz");
        userRedis.add("fzz",10L,user);

    }

    @RequestMapping("getUser")
    @ResponseBody
    public String getUser(String key){
        User user = userRedis.get("fzz");
        if(user != null){
            return new Gson().toJson(user);
        }
        return "无此数据key："+key;
    }


}
