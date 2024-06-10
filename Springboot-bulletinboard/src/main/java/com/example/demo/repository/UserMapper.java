package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.domain.user.model.MUser;

@Mapper
public interface UserMapper {
	
	/**投稿*/
	int insertOne(MUser user);
	
	/**取得*/
	public List<MUser> findMany();
	
	/**投稿取得（1件）*/
	public MUser findOne(String userId);
	
	/**投稿更新(1件)*/
	public void updateOne(@Param("name") String name,@Param("title") String title, @Param("content") String content);
	
	/**ユーザー削除(1件)*/
	public int deleteOne(@Param("name") String name);

}
