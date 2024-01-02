package org.DAO;

import org.entities.Student;

import java.util.List;

public interface StudentDAO
{
    void saveStudent(Student student);

    Student getStudentById(long id);

    List<Student> getAllStudent();

    void updateStudent(Student student);

    void deleteStudent(long id);
}
