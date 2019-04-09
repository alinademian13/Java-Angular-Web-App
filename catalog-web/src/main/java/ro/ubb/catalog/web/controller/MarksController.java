package ro.ubb.catalog.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.ubb.catalog.core.model.Mark;
import ro.ubb.catalog.core.model.Student;
import ro.ubb.catalog.core.service.StudentService;
import ro.ubb.catalog.web.converter.MarksConverter;
import ro.ubb.catalog.web.dto.MarkDto;

import java.util.*;

@RestController
public class MarksController {

    private static final Logger log = LoggerFactory.getLogger(MarksController.class);

    @Autowired
    private StudentService studentService;

    @Autowired
    private MarksConverter marksConverter;

    @RequestMapping(value = "/marks/{studentId}", method = RequestMethod.GET)
    public Set<MarkDto> getMarks(@PathVariable final Long studentId) {

        log.trace("getMarks: studentId={}", studentId);

        Optional<Student> studentOptional = studentService.findStudent(studentId);
        Set<MarkDto> result = new HashSet<>();
        studentOptional.ifPresent(student -> {
                Set<Mark> marks  = student.getMarks();
                result.addAll(marksConverter.convertModelsToDtos(marks));
                });

        log.trace("getMarks: result={}", result);
        return result;
    }

    @RequestMapping(value = "/marks/{studentId}", method = RequestMethod.PUT)
    public Set<MarkDto> updateStudentMarks(@PathVariable final Long studentId, @RequestBody final Set<MarkDto> markDtos) {

        log.trace("updateStudentMarks: studentId={}, markDtos={}", studentId, markDtos);

        Map<Long, Integer> marks = new HashMap<>();
        markDtos.forEach(mark -> marks.put(mark.getDisciplineId(), mark.getMark()));

        Optional<Student> studentOptional = studentService.updateStudentMarks(studentId, marks);

        Set<MarkDto> result = new HashSet<>();
        studentOptional.ifPresent(student -> {
            result.addAll(marksConverter.convertModelsToDtos(student.getMarks()));
        });

        log.trace("getMarks: result={}", result);
        return result;
    }
}
