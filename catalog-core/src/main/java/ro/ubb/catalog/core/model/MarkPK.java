package ro.ubb.catalog.core.model;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class MarkPK implements Serializable {

    private Student student;
    private Discipline discipline;
}
