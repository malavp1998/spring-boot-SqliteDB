package com.student.springWithSqlite.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "student") // required for writing JPQL in jpa (name should be same)
@Table(name = "student")

public class Student {

    @Id
    private Long id;
  //@Column(name = "rollNum")
    private int rollNum;
    private String name;
}
