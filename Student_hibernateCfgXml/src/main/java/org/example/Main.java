package org.example;

import org.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Configuration config = new Configuration();
        config.configure();    //Load the default file hibernate.cfg.xml

        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();

        try
        {
            session.beginTransaction();

            Student student = new Student();
//            student.setId(100);
            student.setStudentName("Johnny Depp");

            session.persist(student);
            session.getTransaction().commit();
        }
        finally
        {
            session.close();
            sessionFactory.close();
        }
    }
}