package org.entities;

import jakarta.persistence.*;

@Entity
public class StudentDetail
{
    @Id
    @GeneratedValue
    @Column(name = "studentdetail_id")
    private long studentDetailId;

    @Column(name = "zipcode")
    private long zipcode;

    @OneToOne(mappedBy = "studentDetail",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Student student;
    public long getStudentDetailId() {
        return studentDetailId;
    }

    public void setStudentDetailId(long studentDetailId) {
        this.studentDetailId = studentDetailId;
    }

    public long getZipcode() {
        return zipcode;
    }

    public void setZipcode(long zipcode) {
        this.zipcode = zipcode;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
