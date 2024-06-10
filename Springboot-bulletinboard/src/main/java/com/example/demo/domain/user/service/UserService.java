package com.example.demo.domain.user.service;

import java.util.List;

import com.example.demo.domain.user.model.MUser;

public interface UserService {
	
	/**投稿登録*/
	public void submitPost(MUser user);
	
	/**投稿取得*/
	public List<MUser> getUsers();
	
	/**投稿取得1件*/
	public MUser getUserOne(String name);
	
	/**投稿更新(1件)*/
	public void updateUserOne(String name, String title, String content);
	
	/**投稿削除(1件)*/
	public void deleteUserOne(String name);
}
