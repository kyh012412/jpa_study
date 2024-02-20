package io.namoosori.jpa;

import io.namoosori.jpa.entity.Customer;
import io.namoosori.jpa.entity.Major;
import io.namoosori.jpa.entity.Student;
import jakarta.persistence.*;
import jdk.jfr.Category;
import org.hibernate.internal.build.AllowSysOut;

import java.util.List;

public class CustomerJpaExam {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("customer-exam");
        EntityManager em =  emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try{
            Major major = new Major("Computer Science","College of Engineering");
            em.persist(major);

            Student student = new Student("Kim","3");
            student.setMajor(major);
            em.persist(student);

            em.flush();
            em.clear();

            //student 검색
            Student foundStudent = em.find(Student.class,1);
            System.out.println(foundStudent.getMajor().getName());
//            Major foundMajor = em.find(Major.class,foundStudent.getMajor());
//            System.out.println(foundStudent);

//            Major foundMajor = em.find(Major.class,foundStudent.getMajor());
//            System.out.println(foundMajor);

            tx.commit();
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
