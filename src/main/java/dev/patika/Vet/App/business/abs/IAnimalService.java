package dev.patika.Vet.App.business.abs;

import dev.patika.Vet.App.entity.Animal;

import java.util.List;

public interface IAnimalService {
    Animal getByID(Long id);
    Animal save(Animal animal);
    String delete(Long id);
    Animal update(Animal animal,Long id);
    List<Animal> findAll();
}
