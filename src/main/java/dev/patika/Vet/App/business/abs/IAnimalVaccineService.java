package dev.patika.Vet.App.business.abs;

import dev.patika.Vet.App.entity.AnimalVaccine;

import java.time.LocalDate;
import java.util.List;

public interface IAnimalVaccineService {
    AnimalVaccine getByID(Long id);
    AnimalVaccine save(AnimalVaccine animalVaccine);
    String delete(Long id);
    AnimalVaccine update(AnimalVaccine animalVaccine,Long id);
    List<AnimalVaccine> findAll();
    List<AnimalVaccine> findAnimalVaccineByAnimalID(Long id);
    List<AnimalVaccine> findAllByPrtStartBetween(LocalDate prt_start, LocalDate prt_end);

}
