package cn.whu.wy.usermanager.controller;

import cn.whu.wy.usermanager.dto.Result;
import cn.whu.wy.usermanager.entity.User;
import cn.whu.wy.usermanager.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/my-info")
@Slf4j
public class MyInfoController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String show(Model model, HttpServletRequest request) {
        User user = userService.queryUserByName(request.getRemoteUser());
        model.addAttribute("userInfo", user);
        return "my-info";
    }

    @PostMapping("/update")
    @ResponseBody
    public Result update(User user) {
        log.info("update phone number: name = {}, phone={}", user.getName(), user.getPhone());
        return userService.update(user);
    }
}
