package ro.ubb.catalog.core.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "mark")
@IdClass(MarkPK.class)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Mark implements Serializable {

    @Id
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "student_id")
    private Student student;

    @Id
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "discipline_id")
    private Discipline discipline;

    @Column(name = "mark")
    private Integer mark;

    @Override
    public String toString() {
        return "Mark{" +
                "student=" + student.getId() +
                ", discipline=" + discipline.getId() +
                ", mark=" + mark +
                "}";
    }
}
