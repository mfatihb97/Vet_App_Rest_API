package dev.patika.Vet.App.business.abs;

import dev.patika.Vet.App.dto.ReportDto.AnimalVaccineSaveRequest;
import dev.patika.Vet.App.entity.AnimalVaccine;

import java.time.LocalDate;
import java.util.List;

public interface IAnimalVaccineService {
    AnimalVaccine getByID(Long id);
    AnimalVaccine save(AnimalVaccineSaveRequest animalVaccineSaveRequest);
    String delete(Long id);
    AnimalVaccine update(AnimalVaccineSaveRequest animalVaccineSaveRequest, Long id);
    List<AnimalVaccine> findAll();
    List<AnimalVaccine> findAnimalVaccineByAnimalID(Long id);
    List<AnimalVaccine> findAllByPrtStartBetween(LocalDate prt_start, LocalDate prt_end);

    List<AnimalVaccine> findByAnimalName(String name);
}
