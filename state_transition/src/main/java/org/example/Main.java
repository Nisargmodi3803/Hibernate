package org.example;

import org.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args)
    {
        Configuration config = new Configuration();
        config.addAnnotatedClass(org.entities.Student.class);

        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();

        try
        {
//            session.beginTransaction();
//
//            Student student = new Student();
//            student.setStudentName("Ian Somerhalder");
//
//            session.persist(student);
//
////            student.setStudentName("Paul Wesley");  // Update....
//
//            session.getTransaction().commit();

         //<---------------------------------------------------------------------------------->

//            Student student1 = session.get(Student.class,1); // Using get
//            System.out.println("Student1 : "+student1);
//
//            Student student2 = session.find(Student.class,2);// Using find
//            System.out.println("Student2 : "+student2);

          //<----------------------------------------------------------------------------------->

//            session.beginTransaction();
//
//            Student student = session.get(Student.class,1);
//            System.out.println("Student : "+student);
//            student.setStudentName("damon salvatore");
//            session.getTransaction().commit(); // if remove this statement then also update query is not fired.
//            student.setStudentName("Ian Somerhalder"); // donot get update

          //<------------------------------------------------------------------------------------>

//          session.beginTransaction();
//
//          Student student = session.find(Student.class,1);
//          System.out.println("Student : "+student);
//          session.remove(student);
//
//          session.getTransaction().commit();

         //<--------------------------------------------------------------------------------------->


//            Student student1 = null;
//            Student student2 = null;
//
//            Session session1 = sessionFactory.openSession();
//            session1.beginTransaction();
//            student1 = session1.get(Student.class,1);
//            session1.getTransaction().commit();
//            session1.close();
//
//            student1.setStudentName("Damon Salvatore");
//            Session session2 = sessionFactory.openSession();
//            session2.beginTransaction();
//            session2.merge(student1);
//            session2.getTransaction().commit();
//            session2.close();


        }
        finally
        {
            session.close();
            sessionFactory.close();
        }
    }
}