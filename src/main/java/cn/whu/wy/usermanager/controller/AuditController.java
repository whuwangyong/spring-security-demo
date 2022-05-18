package cn.whu.wy.usermanager.controller;

import cn.whu.wy.usermanager.entity.OperationLog;
import cn.whu.wy.usermanager.entity.User;
import cn.whu.wy.usermanager.service.AuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/audit")
public class AuditController {

    @Autowired
    private AuditService auditService;

    @GetMapping("/")
    public String show(Model model) {
        List<OperationLog> allOps = auditService.getAllOps();
        model.addAttribute("allOps", allOps);
        return "audit";
    }


}
