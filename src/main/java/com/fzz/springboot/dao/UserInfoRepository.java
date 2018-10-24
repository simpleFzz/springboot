package com.fzz.springboot.dao;

import com.fzz.springboot.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ClassName UserInfoRepository
 * @Description
 * @Author fzz
 * @Date 2018/10/24
 **/
public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {

    UserInfo findUserInfoById(Integer id);

}