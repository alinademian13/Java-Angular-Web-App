package ro.ubb.catalog.web.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class DisciplineDto extends BaseDto {
    private String title;
    private String teacher;
    private Integer labNumber;

    @Override
    public String toString() {
        return "DisciplineDto{" +
                "title='" + title + '\'' +
                ", teacher='" + teacher + '\'' +
                ", LabNumber=" + labNumber +
                '}' + super.toString();
    }
}
