package ro.ubb.catalog.web.dto;

import lombok.*;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class StudentDto extends BaseDto {
    private String name;
    private Integer groupNumber;
    private Set<Long> disciplines;

}
