package com.microservices.showdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpSession;

@Controller
public class ShowDataController {
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/showData")
    public String welcomeToInsert(@ModelAttribute NumbersData data, HttpSession session, Model model) {
        User user=(User) session.getAttribute("user");
        if(user==null)
            return "redirect:login";
        data=getDataFromApi();
        model.addAttribute("data",data);
        return "showData";
    }

    private NumbersData getDataFromApi() {
        String DATA_URL="http://mongoService:7080/numbersData";
        ResponseEntity<NumbersData> response =
                restTemplate.getForEntity(DATA_URL,NumbersData.class);
        return response.getBody();
    }
}
