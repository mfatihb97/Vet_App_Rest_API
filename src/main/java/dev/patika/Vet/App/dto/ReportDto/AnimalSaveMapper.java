package dev.patika.Vet.App.dto.ReportDto;

import dev.patika.Vet.App.dao.AnimalRepository;
import dev.patika.Vet.App.dao.CustomerRepository;
import dev.patika.Vet.App.entity.Animal;
import dev.patika.Vet.App.entity.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class AnimalSaveMapper implements Function<AnimalSaveRequest,Animal> {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Animal apply(AnimalSaveRequest animalSaveRequest){

        Animal newAnimal = new Animal();

        newAnimal.setName(animalSaveRequest.name());
        newAnimal.setSpecies(animalSaveRequest.species());
        newAnimal.setBreed(animalSaveRequest.breed());
        newAnimal.setGender(animalSaveRequest.gender());
        newAnimal.setColour(animalSaveRequest.colour());
        newAnimal.setBirthday(animalSaveRequest.birthday());
        newAnimal.setCustomer(customerRepository.findById(animalSaveRequest.customer())
                .orElseThrow());

        return newAnimal;

    }
}
