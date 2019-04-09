package ro.ubb.catalog.core.service;

import ro.ubb.catalog.core.model.Student;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public interface StudentService {

    List<Student> findAll();

    Optional<Student> findStudent(Long studentId);

    Student updateStudent(Long studentId, String name, Integer groupNumber, Set<Long> disciplines);

    Student saveStudent(String name, Integer groupNumber);

    void deleteById(Long studentId);

    Optional<Student> updateStudentMarks(Long studentId, Map<Long, Integer> marks);
}
