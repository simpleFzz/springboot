package com.fzz.springboot.config;

/**
 * @ClassName TestDataSourceConfig
 * @Description
 * @Author fzz
 * @Date 2018/10/25
 **/

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableMongoRepositories(basePackages = "com.**.mongodb")
@PropertySource("classpath:test.properties")
public class TestDataSourceConfig extends AbstractMongoConfiguration {
    @Autowired
    private Environment env;

    @Override
    public String getDatabaseName() {
        return env.getRequiredProperty("mongo.name");
    }

    @Override
    public MongoClient mongoClient() {
        ServerAddress serverAddress = new ServerAddress(env.getRequiredProperty("mongo.host"));
        List<MongoCredential> credentials = new ArrayList<>();
        return new MongoClient(serverAddress, credentials);
    }
}