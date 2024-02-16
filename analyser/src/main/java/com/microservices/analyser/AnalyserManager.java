package com.microservices.analyser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.*;

@Component
public class AnalyserManager {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private Analyser analyser;

    private static int numberOfNumbers;
    @Scheduled(fixedRate = 2500)
    public void checkNumberOfNumbers(){
        int oldNumberOfNumbers= numberOfNumbers;
        getNumberOfNumbers();
        if(numberOfNumbers !=oldNumberOfNumbers&&numberOfNumbers!=0)
            analyser.startAnalyser();
    }
    private void getNumberOfNumbers() {
        String NUMBER_OF_NUMBERS_URL
                = "http://mysqlService:8086/numberOfNumbers";
        ResponseEntity<Integer> response;
        try {
            response = restTemplate.getForEntity(NUMBER_OF_NUMBERS_URL, Integer.class);
        } catch (ResourceAccessException e) {
            throw new ConnectionException("can not connect to Mysql Service");
        }
        numberOfNumbers = response.getBody();
    }
}
