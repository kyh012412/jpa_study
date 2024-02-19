package io.namoosori.jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity//Customer는 테이블에 들어갈 entity임을 명시
@Table(name="customer_tb")//(어느테이블에 들어갈지) 들어가게 될 테이블명 명시
public class Customer {

    @Id //pk임을 알려줌
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
