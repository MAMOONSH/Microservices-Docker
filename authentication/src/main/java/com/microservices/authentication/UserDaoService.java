package com.microservices.authentication;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class UserDaoService {
    private static List<User> users=new ArrayList<>();
    static {
        users.add(new User(1111,"1111"));
        users.add(new User(2222,"2222"));
        users.add(new User(3333,"3333"));
    }
    public boolean checkIfValidUser(User user){
        return users.contains(user);
    }

}
