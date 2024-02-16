package com.microservices.analyser;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class NumbersStatistics {
    private double average;
    private double median;
    private int max;
    private int min;


    public void analyze(List<Numbers> numbersWithId){
        List<Integer> numbers=new ArrayList<>();
        extractNumbers(numbers,numbersWithId);
        Collections.sort(numbers);
        average(numbers);
        median(numbers);
        max(numbers);
        min(numbers);
    }
    private void extractNumbers(List<Integer> numbers, List<Numbers> numbersWithId)
    {
        for(int i=0;i<numbersWithId.size();i++){
            numbers.add(numbersWithId.get(i).getNumber());
        }
    }

    private void average(List<Integer> numbers){
        average= numbers.stream().mapToDouble(d->d).average().orElse(0.0);
    }
    private void median(List<Integer> numbers){
        int numberNumbers=numbers.size();
        if(numberNumbers%2==0){
            median=(numbers.get(numberNumbers/2)+numbers.get(numberNumbers/2-1))/2.0;
        }
        else{
            median=numbers.get(numberNumbers/2);
        }
    }
    private void max(List<Integer> numbers){
        int numberNumbers=numbers.size();
        max= numbers.get(numberNumbers-1);
    }
    private void min(List<Integer> numbers){
        min= numbers.get(0);
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

    @Override
    public String toString() {
        return "Statistics{" +
                "average=" + average +
                ", median=" + median +
                ", max=" + max +
                ", min=" + min +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NumbersStatistics that = (NumbersStatistics) o;
        return Double.compare(that.average, average) == 0 && Double.compare(that.median, median) == 0 && max == that.max && min == that.min;
    }

    @Override
    public int hashCode() {
        return Objects.hash(average, median, max, min);
    }
}
