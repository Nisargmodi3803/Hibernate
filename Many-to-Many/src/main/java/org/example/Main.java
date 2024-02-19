package org.example;


import org.entities.certification;
import org.entities.student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args)
    {
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(org.entities.student.class);
        configuration.addAnnotatedClass(org.entities.certification.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        try
        {
            session.beginTransaction();

            student tom = new student();
            tom.setStudentName("Tom Cruise");

            student will = new student();
            will.setStudentName("Will Smith");

            student keanu = new student();
            keanu.setStudentName("Keanu Reeves");

            certification aws = new certification();
            aws.setCertificationName("AWS");

            certification springBoot = new certification();
            springBoot.setCertificationName("SPRING BOOT");

            certification sql = new certification();
            sql.setCertificationName("SQL");

            Set<certification> tomCertification = new HashSet<>();
            tomCertification.add(aws);
            tomCertification.add(springBoot);

            Set<certification> willCertification = new HashSet<>();
            willCertification.add(springBoot);

            Set<certification> keanuCertification = new HashSet<>();
            keanuCertification.add(aws);
            keanuCertification.add(springBoot);
            keanuCertification.add(sql);

            tom.setStudentCertification(tomCertification);
            will.setStudentCertification(willCertification);
            keanu.setStudentCertification(keanuCertification);

            session.persist(tom);
            session.persist(will);
            session.persist(keanu);

            session.getTransaction().commit();
        }
        finally
        {
            session.close();
            sessionFactory.close();
        }
    }
}