package com.fzz.springboot.redis;


import com.fzz.springboot.entity.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Repository
public class UserRedis {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    public  void add(String key, Long time, User user ){
        Gson gson = new Gson();
        redisTemplate.opsForValue().set(key,gson.toJson(user),time, TimeUnit.MINUTES);
    }

    public User get(String key){
        Gson gson = new Gson();
        String userJson = redisTemplate.opsForValue().get(key);
        User user = null;
        if(!StringUtils.isEmpty(userJson)){
             user = gson.fromJson(userJson, User.class);
        }
        return user;
    }

    public List<User> getList(String key){
        Gson gson = new Gson();
        String listUser = redisTemplate.opsForValue().get(key);
        List<User> users = null;
        if(!StringUtils.isEmpty(listUser)){
            users = gson.fromJson(listUser,new TypeToken<List<User>>(){}.getType());
        }
        return users;
    }

    public void delete(String key){
        redisTemplate.opsForValue().getOperations().delete(key);
    }

}
