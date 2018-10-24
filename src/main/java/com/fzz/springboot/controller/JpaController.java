package com.fzz.springboot.controller;

import com.fzz.springboot.dao.DepartmentRepository;
import com.fzz.springboot.dao.RoleRepository;
import com.fzz.springboot.dao.UserInfoRepository;
import com.fzz.springboot.entity.Department;
import com.fzz.springboot.entity.Role;
import com.fzz.springboot.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName Hellworld
 * @Description
 * @Author fzz
 * @Date 2018/10/24
 **/

@Controller
public class JpaController {

    @Autowired
    UserInfoRepository userInfoRepository;
    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    RoleRepository roleRepository;



    @RequestMapping("hello")
    @ResponseBody
    public String hello(){
        return  "helloWorld";
    }

    @RequestMapping("addUser")
    @ResponseBody
    public void addUser(){
        System.out.println(222);
        User userInfo = new User();
        userInfo.setName("fzz");
        userInfo.setCreatedTime(new Date());
        Department department = new Department();
        department.setName("研发部");
        departmentRepository.save(department);
        userInfo.setDepartment(department);
        Role role = new Role();
        role.setName("admin");
        roleRepository.save(role);
        List<Role> roles = new ArrayList<>();
        roles.add(role);
        userInfo.setRoles(roles);
        userInfoRepository.save(userInfo);
    }

    @RequestMapping("/getUserInfo")
    @ResponseBody
    public User getUserInfo() {
        User userInfo = userInfoRepository.findUserInfoById(1);
        return userInfo;
    }

}
