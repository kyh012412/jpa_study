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
            Customer customer = new Customer("ID0004","Lee"); //비영속 상태(new)
            em.persist(customer); //Customer 객체가 영속 상태(Managed) 가 된다.
            //이 위까지만 햇을때에는 db에 반영되지 않는다.

            //위가 적용된 상태인 것처럼 작업하기위해서는 flush();
            em.flush(); // insert 쿼리가 나가고있지만 커밋은 안 햇음

            Query query = em.createQuery("SELECT c from Customer c",Customer.class);
            List<Customer> customers = query.getResultList();

            System.out.println(customers);




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
