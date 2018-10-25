package com.fzz.springboot.mongodb;

import com.fzz.springboot.entity.UserForMongo;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @ClassName UserRepository
 * @Description
 * @Author fzz
 * @Date 2018/10/25
 **/
public interface UserRepository extends MongoRepository<UserForMongo,String> {

}
