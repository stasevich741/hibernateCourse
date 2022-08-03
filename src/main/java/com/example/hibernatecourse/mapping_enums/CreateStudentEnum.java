package com.example.hibernatecourse.mapping_enums;

import com.example.hibernatecourse.mapping_enums.entity.Status;
import com.example.hibernatecourse.mapping_enums.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentEnum {
    public static void main(String[] args) {
        //create session factory
        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
             //create session
             Session session = factory.getCurrentSession()) {

            //create student object
            Student tempStudent = new Student("Ivan", "Ivanov", "ivan@mail.ru", Status.ON);
            Student tempStudent2 = new Student("Olga", "Ivanova", "olga@mail.ru", Status.OFF);

            //start transaction
            session.beginTransaction();

            //save object
            System.out.println("saving the student");
            session.persist(tempStudent);
            session.persist(tempStudent2);

            //commit transaction
            session.getTransaction().commit();

        }
        System.out.println("done");
    }
}
