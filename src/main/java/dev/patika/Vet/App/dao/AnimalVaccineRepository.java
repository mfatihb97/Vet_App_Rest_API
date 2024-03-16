package dev.patika.Vet.App.dao;

import dev.patika.Vet.App.entity.Animal;
import dev.patika.Vet.App.entity.AnimalVaccine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AnimalVaccineRepository extends JpaRepository<AnimalVaccine,Long> {
    List<AnimalVaccine> findByAnimal(Animal animal);
    AnimalVaccine findByAnimalIdAndVaccineId(Long animal_id,Long vaccine_id);
    List<AnimalVaccine> findAllByPrtStartBetween(LocalDate prtStart, LocalDate prtEnd);
}
