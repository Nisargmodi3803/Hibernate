package org.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class student
{
    @Id
    @Column(name = "student_id")
    @GeneratedValue
    private long id;

    @Column(name = "student_name")
    private String studentName;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "join_student_certification",
        joinColumns = {@JoinColumn(name = "student_id_fk)")},
        inverseJoinColumns = {@JoinColumn(name = "certification_id_fk")}
    )
    private Set<certification> studentCertification;

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

    public Set<certification> getStudentCertification() {
        return studentCertification;
    }

    public void setStudentCertification(Set<certification> studentCertification) {
        this.studentCertification = studentCertification;
    }
}
