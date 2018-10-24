package com.fzz.springboot.dao;

import com.fzz.springboot.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ClassName DepartmentRepository
 * @Description
 * @Author fzz
 * @Date 2018/10/24
 **/
public interface DepartmentRepository extends JpaRepository<Department, Long> {


}