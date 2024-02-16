package com.microservices.enteringdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("*")
    public String gateway(HttpSession session) {
        User user=(User) session.getAttribute("user");
        if(user==null)
            return "redirect:login";
        return "redirect:error";
    }

    @GetMapping("/login")
    public String getLogin(@ModelAttribute User user,HttpSession session, Model model) {
        User sessionUser=(User) session.getAttribute("user");
        if(sessionUser==null)
            return "login";
        model.addAttribute("user", user);
        return "redirect:insertNumbers";
    }
    @PostMapping("/login")
    public String postLogin(@ModelAttribute User user,HttpSession session, Model model) {
        model.addAttribute("user", user);
        if(isAuthenticated(user))
        {
            session.setAttribute("user",user);
            return "redirect:insertNumbers";
        }else{
            return "login";
        }

    }
    private Boolean isAuthenticated(User user){
        HttpEntity<User> request = new HttpEntity<>(user);
        String AUTHENTICATION_URL = "http://authentication:8085/authenticate/user";
        ResponseEntity<Boolean> response = restTemplate
                .exchange(AUTHENTICATION_URL, HttpMethod.POST, request, Boolean.class);
        return Boolean.TRUE.equals(response.getBody());
    }


}
