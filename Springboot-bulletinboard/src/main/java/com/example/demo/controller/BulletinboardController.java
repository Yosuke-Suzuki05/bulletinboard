package com.example.demo.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.domain.user.model.MUser;
import com.example.demo.domain.user.service.UserService;

@Controller
public class BulletinboardController {

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;
    
    @GetMapping("bulletinboard")
    public String getBulletinboard() {
        // bulletinboard.htmlに画面遷移
        return "bulletinboard";
    }
 
    @PostMapping("/bulletinboard")
    public String postRequest(@RequestParam("name") String name,
                              @RequestParam("title") String title,
                              @RequestParam("content") String content, Model model) {
        
        // フォームデータをMUserオブジェクトに変換
        MUser user = new MUser();
        user.setName(name);
        user.setTitle(title);
        user.setContent(content);

        // UserServiceにデータを渡して保存
        userService.submitPost(user);
        
        // 保存後のメッセージをモデルに追加
        model.addAttribute("message", "投稿が完了しました");
        
        // 保存完了後のページに遷移
        return "redirect:/user/list";
    }

}
