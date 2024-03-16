package dev.patika.Vet.App.dao;

import dev.patika.Vet.App.entity.Animal;
import dev.patika.Vet.App.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal,Long> {

    List<Animal> findByCustomer(Customer customer);
    Animal findByName(String name);
    boolean existsByNameAndSpeciesAndBreedAndGenderAndColourAndBirthday(String name, String species, String breed, String gender, String colour, LocalDate birthday);
}
