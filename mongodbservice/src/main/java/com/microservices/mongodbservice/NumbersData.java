package com.microservices.mongodbservice;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class NumbersData {
    @Id
    private String id;

    private int max;
    private int min;
    private double average;
    private double median;

    public NumbersData() {
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public double getMedian() {
        return median;
    }

    public void setMedian(double median) {
        this.median = median;
    }

    @Override
    public String toString() {
        return "NumbersData{" +
                "max=" + max +
                ", min=" + min +
                ", average=" + average +
                ", median=" + median +
                '}';
    }
}
