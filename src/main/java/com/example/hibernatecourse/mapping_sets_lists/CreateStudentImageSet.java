package com.example.hibernatecourse.mapping_sets_lists;

import com.example.hibernatecourse.mapping_sets_lists.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class CreateStudentImageSet {
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
            List<String> theImages = tempStudent.getImages();

            theImages.add("photo1.jpg");
            theImages.add("photo2.jpg");
            theImages.add("photo3.jpg");
            theImages.add("photo4.jpg");
            theImages.add("photo4.jpg");//duple, filtered at java level by hashSet

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
