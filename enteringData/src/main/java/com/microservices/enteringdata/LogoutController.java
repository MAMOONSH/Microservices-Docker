package com.microservices.enteringdata;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LogoutController {
    @GetMapping("/logout")
    public String logout(HttpSession session, Model model){
        session.invalidate();
        if(model.containsAttribute("user")) model.asMap().remove("user");
        if(model.containsAttribute("number")) model.asMap().remove("number");
        return "redirect:login";
    }
}
