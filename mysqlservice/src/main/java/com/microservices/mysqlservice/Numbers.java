package com.microservices.mysqlservice;

import javax.persistence.*;

@Entity
public class Numbers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int number;

    protected Numbers(){}
    protected Numbers(int number){
        this.number=number;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Numbers{" +
                "id=" + id +
                ", number=" + number +
                '}';
    }
}
