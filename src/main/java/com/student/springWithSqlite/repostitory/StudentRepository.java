package com.student.springWithSqlite.repostitory;

import com.student.springWithSqlite.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    // writing custom query ..  By default, the query definition uses JPQL
    //JPQL - java persistence query language
    // SQL -  (native query)

    /*
    we could write custom query for selecting or finding data from database but they follow standard syntax for writing
    for ex if we have properties name ... String firstName ... in out model class or entity
    so if we want to select all the record by firstName them write function
      public List<Student> findByFirstName(String name);   // for this query or function jpa will automatically provide its definition
     */

   // public List<Student> findByName(String name);  // jpa automatically providing definition

    //public List<Student> findbyname(String name);// this function will not work automatically we have to provide its definition(or we have to write the query here)

    //lets write the query for retrieving student by roll number (by using @query annotation)


    @Query(value = "SELECT * FROM student s where name =?1", nativeQuery = true)  //for writing sql query we have to make nativeQuery true, by default(it is false) it runs JPQL
    public List<Student> findByName(String  name);


    @Query(value = "SELECT s FROM student s where s.name =?1 ", nativeQuery = false)  //JPQL query // although right now i am not using it but i can make function and can use it in future
    public List<Student> findByNameJPQL(String  name);

    List<Student> findByRollNum(int rollNum); //jpa automatically providing definition

}
