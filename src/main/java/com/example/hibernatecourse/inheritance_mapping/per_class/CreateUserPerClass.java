package com.example.hibernatecourse.inheritance_mapping.per_class;

import com.example.hibernatecourse.inheritance_mapping.per_class.entity.Instructor;
import com.example.hibernatecourse.inheritance_mapping.per_class.entity.Student;
import com.example.hibernatecourse.inheritance_mapping.per_class.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public abstract class CreateUserPerClass {
    public static void main(String[] args) {
        //create session factory
        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Instructor.class)
                .buildSessionFactory();
             //create session
             Session session = factory.getCurrentSession()) {

            //create student object
            User Student = new Student("Ivan", "Ivanov", "ivan@mail.ru", "hibernate");
            User instructor = new Instructor("Olga", "Ivanova", "olga@mail.ru", 22.1);

            //start transaction
            session.beginTransaction();

            //save object
            System.out.println("saving the entity's");
            session.persist(Student);
            session.persist(instructor);

            //commit transaction
            session.getTransaction().commit();

        }
        System.out.println("done");
    }
}
