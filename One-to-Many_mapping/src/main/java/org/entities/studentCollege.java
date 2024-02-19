package org.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class studentCollege
{
    @Id
    @GeneratedValue
    @Column(name = "college_id")
    private long collegeId;

    @Column(name = "college_name")
    private String collegeName;

    @OneToMany(mappedBy = "studentCollege", cascade = CascadeType.ALL)
    private List<student> student;
    public long getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(long collegeId) {
        this.collegeId = collegeId;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public List<org.entities.student> getStudent() {
        return student;
    }

    public void setStudent(List<org.entities.student> student) {
        this.student = student;
    }
}
