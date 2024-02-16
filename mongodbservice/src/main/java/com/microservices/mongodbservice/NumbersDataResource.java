package com.microservices.mongodbservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
public class NumbersDataResource {

    @Autowired
    private NumbersDataRepository numbersDataRepository;

    @PostConstruct
    public void init(){
        numbersDataRepository.deleteAll();
    }

    @GetMapping(path = "/numbersData")
    public NumbersData getNumberData(){
        List<NumbersData> numbersData=numbersDataRepository.findAll();
        if(numbersData.isEmpty())
            return getEmptyData();
        return numbersData.get(0);
    }
    private NumbersData getEmptyData(){
        NumbersData numbersData=new NumbersData();
        numbersData.setAverage(0);
        numbersData.setMax(0);
        numbersData.setMin(0);
        numbersData.setMedian(0);
        return numbersData;
    }
    @PostMapping(path = "/numbersData")
    public void setNumberData(@RequestBody NumbersData numbersData){
        numbersDataRepository.deleteAll();
        numbersDataRepository.save(numbersData);
    }
}
