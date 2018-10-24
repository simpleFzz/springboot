package com.fzz.springboot.dao;

import com.fzz.springboot.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ClassName RoleRepository
 * @Description
 * @Author fzz
 * @Date 2018/10/24
 **/
public interface RoleRepository extends JpaRepository<Role, Long> {


}