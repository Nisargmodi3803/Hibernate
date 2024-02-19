package org.example;

import org.entities.student;
import org.entities.studentCollege;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args)
    {
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(org.entities.student.class);
        configuration.addAnnotatedClass(org.entities.studentCollege.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        try
        {
            session.beginTransaction();

            student ian = new student();
            ian.setStudentName("Ian Somerhalder");

            student paul = new student();
            paul.setStudentName("Paul wesley");

            student klaus = new student();
            klaus.setStudentName("Klaus Mikealson");

            studentCollege ddu = new studentCollege();
            ddu.setCollegeName("Dharmsinh Desai university");

            studentCollege nirma = new studentCollege();
            nirma.setCollegeName("Nirma University");

//            ian.setStudentCollege(ddu);
//            paul.setStudentCollege(nirma);
//            klaus.setStudentCollege(ddu);

//            session.persist(ian);
//            session.persist(paul);
//            session.persist(klaus);


//          Many to one (Bidirectional)
            List dduStudent = new ArrayList();
            dduStudent.add(ian);
            dduStudent.add(klaus);

            List nirmaStudent = new ArrayList();
            nirmaStudent.add(paul);

            ddu.setStudent(dduStudent);
            nirma.setStudent(nirmaStudent);

            session.persist(ddu);
            session.persist(nirma);

            session.getTransaction().commit();

        }
        finally
        {
            session.close();
            sessionFactory.close();
        }
    }
}