package ro.ubb.catalog.web.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class MarkDto {

    private Long studentId;
    private Long disciplineId;
    private String disciplineName;
    private Integer mark;
}
