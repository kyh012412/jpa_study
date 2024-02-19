package io.namoosori.jpa;

import io.namoosori.jpa.entity.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.hibernate.internal.build.AllowSysOut;

public class CustomerJpaExam {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("customer-exam");
        EntityManager em =  emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        try{
            //실제넣을객체를 persist로 전달
            //em.persist(Customer.sample());

            Customer foundCustomer = em.find(Customer.class, "ID0001");
            //System.out.println(foundCustomer.toString());

//            foundCustomer.setName("Park");
            em.remove(foundCustomer);

//            em.persist(foundCustomer);

            tx.commit();
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
