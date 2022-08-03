package com.example.hibernatecourse.mapping_components;

import com.example.hibernatecourse.mapping_components.entity.Address;
import com.example.hibernatecourse.mapping_components.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentAddress {
    public static void main(String[] args) {
        //create session factory
        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Address.class)
                .buildSessionFactory();
             //create session
             Session session = factory.getCurrentSession()) {

            //create student object
            Student tempStudent = new Student("Ivan", "Ivanov", "ivan@mail.ru");
            //create address object
//            Address homeAddress = new Address("main street", "NY", "255555");
            Address billingAddress = new Address("main street", "NY", "255555");

            //start transaction
            session.beginTransaction();

            //save object
            System.out.println("saving the student");
//            tempStudent.setHomeAddress(homeAddress);
            tempStudent.setHomeAddress(billingAddress);
            session.persist(tempStudent);

            //commit transaction
            session.getTransaction().commit();

        }
        System.out.println("done");
    }
}
