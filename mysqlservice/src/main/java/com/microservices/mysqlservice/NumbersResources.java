package com.microservices.mysqlservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class NumbersResources {
    @Autowired
    private NumbersRepository numbersRepository;

    private static int numberOfNumbers =0;
    @GetMapping(path = "/numberOfNumbers")
    public int getNumberOfNumbers(){
        return numberOfNumbers;
    }

    @GetMapping(path = "/numbers")
    public List<Numbers> getAllNumbers(){
        List<Numbers> result = new ArrayList<>();
        numbersRepository.findAll().forEach(result::add);
        if(result.isEmpty())
            throw new NumbersNotFoundException("mysql database is empty");
        return result;
    }
    @PostMapping(path = "/addNumber")
    public void addNumber(@RequestBody Numbers number) {
        numberOfNumbers++;
        numbersRepository.save(number);
    }
}
