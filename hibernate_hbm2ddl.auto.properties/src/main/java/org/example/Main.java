package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args)
    {
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(org.entites.Student.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
//        sessionFactory.close();
    }
}