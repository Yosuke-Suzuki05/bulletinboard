package com.example.demo.domain.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.user.model.MUser;
import com.example.demo.domain.user.service.UserService;
import com.example.demo.repository.UserMapper;

@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserMapper mapper;
    
    /**投稿登録*/
    @Override
    public void submitPost(MUser user) {
        mapper.insertOne(user);
    }
    
    /**投稿取得*/
    @Override
    public List<MUser> getUsers(){
    	return mapper.findMany();
    }
    
    /**ユーザー取得(1件)*/
    @Override
    public MUser getUserOne(String name) {
    	return mapper.findOne(name);
    }
    
    /**投稿更新(1件)*/
    @Override
    public void updateUserOne(String name, String title, String content) {
    	mapper.updateOne(name, title, content);
    }
    
    /**投稿削除(1件)*/
    @Override
    public void deleteUserOne(String name) {
    	int count = mapper.deleteOne(name);
    }
    
}
