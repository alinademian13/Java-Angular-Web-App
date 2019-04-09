package ro.ubb.catalog.core.service;

import ro.ubb.catalog.core.model.Discipline;

import java.util.List;

public interface DisciplineService {

    List<Discipline> getAllDisciplines();

    Discipline saveDiscipline(Discipline discipline);

    Discipline updateDiscipline(Long id, Discipline discipline);

    void deleteById(Long id);
}
