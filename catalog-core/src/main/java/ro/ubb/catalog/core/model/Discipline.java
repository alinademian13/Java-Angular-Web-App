package ro.ubb.catalog.core.model;

import lombok.*;

import javax.persistence.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Discipline extends BaseEntity<Long> {

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "teacher", nullable = false)
    private String teacher;

    @Column(name = "labNumber", nullable = false)
    private Integer labNumber;

    @OneToMany(mappedBy = "discipline", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Mark> marks = new HashSet<>();

    public Set<Student> getStudents() {
        return Collections.unmodifiableSet(
                marks.stream()
                    .map(Mark::getStudent)
                    .collect(Collectors.toSet())
        );
    }

    public void addStudent(Student student) {
        Mark mark = new Mark();
        mark.setStudent(student);
        mark.setDiscipline(this);
        marks.add(mark);
    }

    public void addMark(Student student, Integer mark) {
        Mark studentMark = new Mark();
        studentMark.setStudent(student);
        studentMark.setMark(mark);
        studentMark.setDiscipline(this);
        marks.add(studentMark);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Discipline that = (Discipline) o;

        return title.equals(that.title);
    }

    @Override
    public int hashCode() {
        return title.hashCode();
    }

    @Override
    public String toString() {
        return "Discipline{" +
                "title='" + title + '\'' +
                ", teacher='" + teacher + '\'' +
                ", labNumber=" + labNumber +
                '}' + super.toString();
    }
}
