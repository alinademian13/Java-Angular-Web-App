package ro.ubb.catalog.core.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.ubb.catalog.core.model.Discipline;
import ro.ubb.catalog.core.repository.DisciplineRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DisciplineServiceImpl implements DisciplineService {
    private static final Logger log =
            LoggerFactory.getLogger(DisciplineServiceImpl.class);

    @Autowired
    private DisciplineRepository disciplineRepository;

    @Override
    public List<Discipline> getAllDisciplines() {
        log.trace("getAllDisciplines --- method entered");

        List<Discipline> result = disciplineRepository.findAll();

        log.trace("getAllDisciplines: result={}", result);

        return result;
    }

    @Override
    public Discipline saveDiscipline(Discipline discipline) {
        return disciplineRepository.save(discipline);
    }

    @Override
    @Transactional
    public Discipline updateDiscipline(Long id, Discipline discipline) {

        log.trace("updateLabProblem: id={}, labProblem={}", id, discipline);

        Optional<Discipline> optional = disciplineRepository.findById(id);

        Discipline result = optional.orElse(discipline);
        result.setTitle(discipline.getTitle());
        result.setTeacher(discipline.getTeacher());
        result.setLabNumber(discipline.getLabNumber());

        log.trace("updateLabProblem: result={}", result);

        return result;
    }

    @Override
    public void deleteById(Long id) {
        log.trace("deleteById: labProblemId={}", id);

        disciplineRepository.deleteById(id);

        log.trace("deleteById --- method finished");
    }
}
