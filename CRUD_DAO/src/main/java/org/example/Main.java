package org.example;

import org.DAO.StudentDAO;
import org.DAO.StudentDAOImpl;
import org.entities.Student;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {
    public static void main(String[] args)
    {
        Configuration config = new Configuration();
        config.addAnnotatedClass(org.entities.Student.class);
        SessionFactory sessionFactory = config.buildSessionFactory();

        StudentDAO studentDAO = new StudentDAOImpl(sessionFactory);

        Student student1 = new Student();
        student1.setStudentName("Ian Somerhalder");
        System.out.println("Addting Student : "+student1);
        studentDAO.saveStudent(student1);

        Student student2 = new Student();
        student2.setStudentName("Paul Wesley");
        System.out.println("Adding Student : "+student2);
        studentDAO.saveStudent(student2);

        List<Student> students = studentDAO.getAllStudent();
        System.out.println("Students : "+students.toString());

        Student studentToUpdate = studentDAO.getStudentById(1);
        if(studentToUpdate!=null)
        {
            studentToUpdate.setStudentName("Damon Salvatore");
            studentDAO.updateStudent(studentToUpdate);
        }

        Student updatedStudent = studentDAO.getStudentById(1);
        System.out.println("UpdatedStudent : "+updatedStudent);

        studentDAO.deleteStudent(2);
        System.out.println("Deleting Student with id "+2);
        List<Student> studentsAfterDelete = studentDAO.getAllStudent();
        System.out.println("Students after delete : "+studentsAfterDelete.toString());
    }
}