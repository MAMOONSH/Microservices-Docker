package com.microservices.analyser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.*;

import java.util.Arrays;
import java.util.List;

@Component
public class Analyser {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private NumbersStatistics numbersStatistics;
    @Autowired
    private NumbersData numbersData;

    public void startAnalyser(){
        List<Numbers> numbersList= Arrays.asList(getNumbers());
        numbersStatistics.analyze(numbersList);
        setNumbersData();
        passNumbersData();
    }

    private Numbers[] getNumbers() {
        String NUMBERS_URL = "http://mysqlService:8086/numbers";
        ResponseEntity<Numbers[]> response;
        try {
            response = restTemplate.getForEntity(
                    NUMBERS_URL, Numbers[].class);
        } catch (ResourceAccessException e) {
            throw new ConnectionException("can not connect to Mysql Service");
        }
        return response.getBody();
    }

    private void setNumbersData() {
        numbersData.setAverage(numbersStatistics.getAverage());
        numbersData.setMax(numbersStatistics.getMax());
        numbersData.setMin(numbersStatistics.getMin());
        numbersData.setMedian(numbersStatistics.getMedian());
    }
    private void passNumbersData(){
        String MONGO_RESTAPI_URL="http://mongoService:7080/numbersData";
        HttpEntity<NumbersData> request = new HttpEntity<>(numbersData);
        try{
            restTemplate.exchange(MONGO_RESTAPI_URL, HttpMethod.POST,request,Object.class);
        }
        catch (ResourceAccessException e) {
            throw new ConnectionException("can not connect to mongodb Service");
        }
    }
}
