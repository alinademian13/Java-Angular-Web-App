package ro.ubb.catalog.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.ubb.catalog.core.model.Discipline;
import ro.ubb.catalog.core.service.DisciplineService;
import ro.ubb.catalog.web.converter.DisciplineConverter;
import ro.ubb.catalog.web.dto.DisciplineDto;

import java.util.List;
import java.util.Set;

@RestController
public class DisciplineController {
    private static final Logger log =
            LoggerFactory.getLogger(DisciplineController.class);

    @Autowired
    private DisciplineService disciplineService;

    @Autowired
    private DisciplineConverter disciplineConverter;


    @RequestMapping(value = "/disciplines", method = RequestMethod.GET)
    Set<DisciplineDto> getAllDisciplines() {
        log.trace("getAllDisciplines --- method entered");

        List<Discipline> disciplines = disciplineService.getAllDisciplines();

        Set<DisciplineDto> result =
                disciplineConverter.convertModelsToDtos(disciplines);

        log.trace("getAllDisciplines: result={}", result);

        return result;
    }

    @RequestMapping(value = "/disciplines", method = RequestMethod.POST)
    DisciplineDto saveDiscipline(@RequestBody DisciplineDto dto) {
        log.trace("saveLabProblem: dto={}", dto);

        Discipline discipline = disciplineService.saveDiscipline(disciplineConverter.convertDtoToModel(dto));

        DisciplineDto result = disciplineConverter.convertModelToDto(discipline);

        log.trace("saveLabProblem: result={}", result);

        return result;
    }

    @RequestMapping(value = "/disciplines/{disciplineId}", method = RequestMethod.PUT)
    DisciplineDto updateDiscipline(@PathVariable Long disciplineId, @RequestBody DisciplineDto dto) {

        log.trace("updateLabProblem: disciplineId={}, dto={}", disciplineId, dto);

        Discipline lab = disciplineService.updateDiscipline(disciplineId, disciplineConverter.convertDtoToModel(dto));

        DisciplineDto result = disciplineConverter.convertModelToDto(lab);

        log.trace("updateLabProblem: result={}", result);

        return result;
    }

    @RequestMapping(value = "/disciplines/{disciplineId}", method = RequestMethod.DELETE)
    ResponseEntity<?> deleteDiscipline(@PathVariable Long disciplineId) {
        log.trace("deleteLabProblem: disciplineId={}", disciplineId);

        disciplineService.deleteById(disciplineId);

        log.trace("deleteLabProblem --- method finished");

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
