package com.fzz.springboot.controller;

import com.fzz.springboot.entity.User;
import com.fzz.springboot.entity.UserForMongo;
import com.fzz.springboot.mongodb.UserRepository;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * @ClassName MongodbController
 * @Description
 * @Author fzz
 * @Date 2018/10/25
 **/
@Controller
public class MongodbController {

    private static Logger logger = LoggerFactory.getLogger(MongodbController.class);
    @Autowired
    UserRepository userRepository;

    @RequestMapping("setUp")
    @ResponseBody
    public void setUp(){
        Set<String> roles = new HashSet<>();
        roles.add("mongo");
        UserForMongo userForMongo = new UserForMongo("2","hande","123456","fangzhuangzhan","511208577@qq.com",
                new Date(),roles);
        userRepository.save(userForMongo);
    }

    @RequestMapping("getList")
    @ResponseBody
    public String getList(){
        List<UserForMongo> users = userRepository.findAll();
        return new Gson().toJson(users);
    }
}
