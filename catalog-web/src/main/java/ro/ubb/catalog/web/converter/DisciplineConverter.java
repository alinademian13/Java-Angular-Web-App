package ro.ubb.catalog.web.converter;

import org.springframework.stereotype.Component;
import ro.ubb.catalog.core.model.Discipline;
import ro.ubb.catalog.web.dto.DisciplineDto;

@Component
public class DisciplineConverter
        extends AbstractBaseEntityConverter<Discipline, DisciplineDto> {

    @Override
    public Discipline convertDtoToModel(DisciplineDto dto) {
        Discipline discipline = Discipline.builder()
                .title(dto.getTitle())
                .teacher(dto.getTeacher())
                .labNumber(dto.getLabNumber())
                .build();

        discipline.setId(dto.getId());
        return discipline;
    }

    @Override
    public DisciplineDto convertModelToDto(Discipline discipline) {
        DisciplineDto dto = DisciplineDto.builder()
                .title(discipline.getTitle())
                .teacher(discipline.getTeacher())
                .labNumber(discipline.getLabNumber())
                .build();
        dto.setId(discipline.getId());
        return dto;
    }
}
