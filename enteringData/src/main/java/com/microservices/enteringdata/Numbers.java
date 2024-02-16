package com.microservices.enteringdata;

public class Numbers {
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
