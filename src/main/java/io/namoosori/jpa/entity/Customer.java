package io.namoosori.jpa.entity;

public class Customer {

    private String id;
    private String name;
    private long registerDate;

    public Customer(String id,String name){
        this.id=id;
        this.name =name;
        this.registerDate=System.currentTimeMillis();
    }

    public static Customer sample(){
        return new Customer("I0001","Kim");
    }

}
