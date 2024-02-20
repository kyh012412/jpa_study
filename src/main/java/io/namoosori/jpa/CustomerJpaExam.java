package io.namoosori.jpa;

import io.namoosori.jpa.entity.Customer;
import jakarta.persistence.*;
import org.hibernate.internal.build.AllowSysOut;

import java.util.List;

public class CustomerJpaExam {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("customer-exam");
        EntityManager em =  emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        try{
            Customer customer = new Customer("ID0005","Jin"); //비영속 상태(new)
            em.persist(customer); //Customer 객체가 영속 상태(Managed) 가 된다.
            //이 위까지만 햇을때에는 db에 반영되지 않는다.
            
            em.detach(customer); // customer을 detach해서 준영속상태(Detached)를 만들고싶음

            //1차 캐시에 들어있기 때문에 select가 나가지 않는다.
            Customer foundCustomer = em.find(Customer.class,"ID0005");
            System.out.println(foundCustomer);



                //flush와 commit의 개념 구분이 필요
            tx.commit(); // 이때 인설트됨 // h2-conosle에서 db를 바라봐도 올바른 조회가 가능
            System.out.println("커밋완료");
        }catch(Exception e){
            // 문제가 있었을때는 tx.rollback()
            tx.rollback();
            System.out.println("커밋실패 & 롤백 가동");
        }finally {
            em.close();
        }
        emf.close();


    }
}
