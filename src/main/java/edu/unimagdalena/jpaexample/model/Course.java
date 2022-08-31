package edu.unimagdalena.jpaexample.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@Table(name = "courses")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;
    
    @OneToOne(mappedBy = "course")
    private CourseMaterial material;

    @ManyToMany
    @JoinTable(
      name = "STUDENTS_COURSES",
      joinColumns = @JoinColumn(name = "COURSE_ID", referencedColumnName = "id"),
      inverseJoinColumns = @JoinColumn(name = "STUDENT_ID", referencedColumnName = "id")
    )
    private List<Student> students = new ArrayList<>();

    public void addStudent(Student student){
        this.students.add(student);
    }
}

