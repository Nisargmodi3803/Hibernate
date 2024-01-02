package org.entities;

import jakarta.persistence.*;

@Entity
public class Student
{
    @Id
    @Column(name = "student_id")
    @GeneratedValue
    private long id;

    @Column(name = "student_name")
    private String studentName;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "st_detail_fk")
    private StudentDetail studentDetail;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public StudentDetail getStudentDetail() {
        return studentDetail;
    }

    public void setStudentDetail(StudentDetail studentDetail) {
        this.studentDetail = studentDetail;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", studentName='" + studentName + '\'' +
                ", studentDetail=" + studentDetail +
                '}';
    }
}
