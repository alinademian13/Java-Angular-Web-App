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
public class Student extends BaseEntity<Long> {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "groupNumber", nullable = false)
    private Integer groupNumber;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Mark> marks = new HashSet<>();

    public Set<Discipline> getDisciplines() {
        marks = marks == null ? new HashSet<>() : marks;
        return Collections.unmodifiableSet(
                this.marks.stream()
                    .map(Mark::getDiscipline).collect(Collectors.toSet())
        );
    }

    public void addDiscipline(Discipline discipline) {
        Mark mark = new Mark();
        mark.setDiscipline(discipline);
        mark.setStudent(this);
        marks.add(mark);
    }

    public void addDisciplines(Set<Discipline> disciplines) {
        disciplines.forEach(this::addDiscipline);
    }

    public void addGrade(Discipline discipline, Integer mark) {
        Mark studentMark = new Mark();
        studentMark.setDiscipline(discipline);
        studentMark.setMark(mark);
        studentMark.setStudent(this);
        marks.add(studentMark);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student that = (Student) o;

        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", groupNumber=" + groupNumber +
                ", mark=" + marks +
                '}' +super.toString();
    }
}
