package com.example.hibernatecourse.mapping_maps;

import com.example.hibernatecourse.mapping_maps.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Map;

public class CreateStudentImageMap {
    public static void main(String[] args) {
        //create session factory
        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
             //create session
             Session session = factory.getCurrentSession()) {

            //create object
            Student tempStudent = new Student("Ivan", "Ivanov", "ivan@mail.ru");
            Map<String, String> theImages = tempStudent.getImages();

            theImages.put("photo1.jpg", "photo 1");
            theImages.put("photo2.jpg", "photo 2");
            theImages.put("photo3.jpg", "photo 3");

            //start transaction
            session.beginTransaction();

            //save object
            System.out.println("saving the student");
            session.persist(tempStudent);

            //commit transaction
            session.getTransaction().commit();

        }
        System.out.println("done");
    }
}
