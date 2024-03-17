package dev.patika.Vet.App.business.abs;

import dev.patika.Vet.App.dto.ReportDto.AnimalSaveRequest;
import dev.patika.Vet.App.entity.Animal;

import java.util.List;

public interface IAnimalService {
    Animal getByID(Long id);
    Animal save(AnimalSaveRequest animalSaveRequest);
    String delete(Long id);
    Animal update(AnimalSaveRequest animalSaveRequest,Long id);
    List<Animal> findAll();
    List<Animal> findByName(String name);
    List<Animal> getByCustomerName(String name);
}
