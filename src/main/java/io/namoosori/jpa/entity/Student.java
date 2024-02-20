package io.namoosori.jpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name="STUDENT_TB")
public class Student {
    @Id
    @GeneratedValue
    private Long studentId;
    private String name;
    private String grade;
    private Long majorId;
    //private Major major;

    public Student(String name,String grade){
        this.name = name;
        this.grade = grade;
    }
}
