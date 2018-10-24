package com.fzz.springboot.controller;

import com.fzz.springboot.dao.UserInfoRepository;
import com.fzz.springboot.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName Hellworld
 * @Description
 * @Author fzz
 * @Date 2018/10/24
 **/

@Controller
public class Hellworld {

    @Autowired
    UserInfoRepository userInfoRepository;

    @RequestMapping("hello")
    @ResponseBody
    public String hello(){
        return  "helloWorld";
    }

    @RequestMapping("addUser")
    @ResponseBody
    public void addUser(){
        UserInfo userInfo = new UserInfo();
        userInfo.setAge(19);
        userInfo.setName("fzz");
        userInfoRepository.save(userInfo);
    }

    @RequestMapping("/getUserInfo")
    @ResponseBody
    public UserInfo getUserInfo() {
        UserInfo userInfo = userInfoRepository.findUserInfoById(1);
        return userInfo;
    }

}
