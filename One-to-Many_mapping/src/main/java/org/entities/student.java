package org.entities;

import jakarta.persistence.*;

@Entity
public class student
{
    @Id
    @Column(name = "student_id")
    @GeneratedValue
    private long id;

    @Column(name = "student_name")
    private String studentName;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "college_fk")
    private studentCollege studentCollege;

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

    public org.entities.studentCollege getStudentCollege() {
        return studentCollege;
    }

    public void setStudentCollege(org.entities.studentCollege studentCollege) {
        this.studentCollege = studentCollege;
    }

    @Override
    public String toString() {
        return "student{" +
                "id=" + id +
                ", studentName='" + studentName + '\'' +
                ", studentCollege=" + studentCollege +
                '}';
    }
}
