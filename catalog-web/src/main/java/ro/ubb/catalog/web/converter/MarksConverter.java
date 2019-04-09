package ro.ubb.catalog.web.converter;

import org.springframework.stereotype.Component;
import ro.ubb.catalog.core.model.Mark;
import ro.ubb.catalog.web.dto.MarkDto;

@Component
public class MarksConverter extends AbstractConverter<Mark, MarkDto> {

    @Override
    public Mark convertDtoToModel(MarkDto markDto) {
        throw new RuntimeException("not yet implemented");
    }

    @Override
    public MarkDto convertModelToDto(Mark mark) {
        return MarkDto.builder()
                .studentId(mark.getStudent().getId())
                .disciplineId(mark.getDiscipline().getId())
                .disciplineName(mark.getDiscipline().getTitle())
                .mark(mark.getMark())
                .build();
    }
}
