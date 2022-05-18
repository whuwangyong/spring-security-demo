package cn.whu.wy.usermanager.controller;

import cn.whu.wy.usermanager.dto.Result;
import cn.whu.wy.usermanager.entity.OperationLog;
import cn.whu.wy.usermanager.entity.User;
import cn.whu.wy.usermanager.service.AuditService;
import cn.whu.wy.usermanager.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/salary-manage")
@Slf4j
public class SalaryManageController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuditService auditService;

    @GetMapping("/")
    public String show(Model model) {
        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("allUsers", allUsers);
        return "salary-manage";
    }

    @PostMapping("/update")
    @ResponseBody
    public Result updateSalary(User user) {
        log.info("update salary: name = {}, salary={}", user.getName(), user.getSalary());
//        auditService.writeLog(OperationLog.builder()
//                .dateTime(LocalDateTime.now())
//                .operation("name=" + user.getName() + ",salary=" + user.getSalary())
//                .operator("张小龙")
//                .build());
        return userService.update(user);
    }
}
