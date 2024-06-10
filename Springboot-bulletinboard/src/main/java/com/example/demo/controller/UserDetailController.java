package com.example.demo.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.user.model.MUser;
import com.example.demo.domain.user.service.UserService;
import com.example.demo.form.UserDetailForm;

@Controller
@RequestMapping("/user")
public class UserDetailController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	/**投稿詳細画面を表示*/
	@GetMapping("/detail/{name:.+}")
	public String getUser(UserDetailForm form, Model model,@PathVariable("name") String name) {
		
		//投稿を1件取得
		MUser user = userService.getUserOne(name);
		
		//MUserをformに変換
		form = modelMapper.map(user, UserDetailForm.class);
		
		//投稿詳細画面を表示
		model.addAttribute("userDetailForm", form);
		
		//投稿詳細画面を表示
		return "user/detail";
		
	}
	
	/**投稿更新処理*/
	@PostMapping(value = "/detail", params = "update")
	public String updateUser(UserDetailForm form, Model model) {
		
		//投稿を更新
		userService.updateUserOne(form.getName(), form.getTitle(), form.getContent());
		
		//投稿一覧画面にリダイレクト
		return "redirect:/user/list";
	}
	
	/**投稿削除処理*/
	@PostMapping(value = "/detail", params = "delete")
	public String deleteUser(UserDetailForm form, Model model) {
		
		//投稿削除
		userService.deleteUserOne(form.getName());
		
		//投稿一覧画面にリダイレクト
		return "redirect:/user/list";
	}

}
