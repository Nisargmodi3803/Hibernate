package org.example;

import org.entities.Student;
import org.entities.StudentDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args)
    {
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(org.entities.Student.class);
        configuration.addAnnotatedClass(org.entities.StudentDetail.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        try
        {
            session.beginTransaction();

            StudentDetail studentDetail = new StudentDetail();
            studentDetail.setZipcode(393002);

            Student student = new Student();
            student.setStudentName("Ian Somerhalder");
            student.setStudentDetail(studentDetail);

            session.persist(student); // One to One mapping
//            session.persist(studentDetail);// One to One Bidirectional mapping

            session.getTransaction().commit();
        }
        finally
        {
            session.close();
            sessionFactory.close();
        }
    }
}