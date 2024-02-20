package io.namoosori.jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity//Customer는 테이블에 들어갈 entity임을 명시
@Table(name="customer_tb")//(어느테이블에 들어갈지) 들어가게 될 테이블명 명시
public class Customer {

    @Id //pk임을 알려줌
    private Long id;
    private String name;
    private long registerDate;

    //디폴트 생성자가 없는 상태
    //그래서 entitymanager가 객체를 생성할 수 없는 상태
    @Builder // 이게 있어야 select시 담아올 자료형으로 쓸수있음
    public Customer(Long id,String name){
        this.id=id;
        this.name =name;
        this.registerDate=System.currentTimeMillis();
    }

    public static Customer sample(){
        return new Customer(1L,"Kim");
    }

}
