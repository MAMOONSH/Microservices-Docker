package com.microservices.enteringdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpSession;

@Controller
public class InsertingValuesController {

    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("/insertNumbers")
    public String welcomeToInsert(@ModelAttribute Numbers number, HttpSession session, Model model) {
        User user=(User) session.getAttribute("user");
        if(user==null)
            return "redirect:login";
        model.addAttribute("number", number);
        return "insertNumbers";
    }
    @PostMapping("/insertNumbers")
    public String insertNumber(@ModelAttribute Numbers number,HttpSession session, Model model) {
        User user=(User) session.getAttribute("user");
        if(user==null)
            return "redirect:login";
        model.addAttribute("number", number);
        passNumberToDatabase(number);
        return "insertNumbers";
    }
    private void passNumberToDatabase(Numbers number){
        HttpEntity<Numbers> request = new HttpEntity<>(number);
        String MYSQL_RESTAPI_URL = "http://mysqlService:8086/addNumber";
        restTemplate.exchange(MYSQL_RESTAPI_URL,HttpMethod.POST,request,Object.class);
    }
}
