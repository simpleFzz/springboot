package com.fzz.springboot.dao;

import com.fzz.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ClassName UserInfoRepository
 * @Description
 * @Author fzz
 * @Date 2018/10/24
 **/
public interface UserInfoRepository extends JpaRepository<User, Long> {

    User findUserInfoById(Integer id);

}