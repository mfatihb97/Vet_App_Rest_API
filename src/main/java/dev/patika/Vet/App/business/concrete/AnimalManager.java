package dev.patika.Vet.App.business.concrete;

import dev.patika.Vet.App.business.abs.IAnimalService;
import dev.patika.Vet.App.dao.AnimalRepository;
import dev.patika.Vet.App.dao.CustomerRepository;
import dev.patika.Vet.App.dto.ReportDto.AnimalSaveMapper;
import dev.patika.Vet.App.dto.ReportDto.AnimalSaveRequest;
import dev.patika.Vet.App.entity.Animal;
import dev.patika.Vet.App.entity.AnimalVaccine;
import dev.patika.Vet.App.entity.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnimalManager implements IAnimalService {

    private final AnimalRepository animalRepository;

    private final AnimalSaveMapper animalSaveMapper;
    private final CustomerRepository customerRepository;

    @Override
    public Animal getByID(Long id) {
        if (this.animalRepository.findById(id) == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"ID not found");
        } else {
            return this.animalRepository.findById(id).orElseThrow();
        }

    }

    @Override
    public Animal save(AnimalSaveRequest animalSaveRequest){
        if(animalRepository.existsByNameAndSpeciesAndBreedAndGenderAndColourAndBirthday(
                animalSaveRequest.name(),
                animalSaveRequest.species(),
                animalSaveRequest.breed(),
                animalSaveRequest.gender(),
                animalSaveRequest.colour(),
                animalSaveRequest.birthday()
        )){
            throw new IllegalArgumentException("This animal is already exist!");
        }
        return this.animalRepository.save(animalSaveMapper.apply(animalSaveRequest));
    }

    @Override
    public String delete(Long id) {
        if (this.animalRepository.findById(id) == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            this.animalRepository.delete(this.getByID(id));
            return "deleted the record with id: " + id;
        }

    }

    @Override
    public Animal update(AnimalSaveRequest animalSaveRequest,Long id) {
        Animal existingAnimal = animalRepository.findById(id).orElseThrow();
        if (existingAnimal == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }else{
            Animal updatedAnimal = animalSaveMapper.apply(animalSaveRequest);

            existingAnimal.setBirthday(updatedAnimal.getBirthday());
            existingAnimal.setColour(updatedAnimal.getColour());
            existingAnimal.setBreed(updatedAnimal.getBreed());
            existingAnimal.setGender(updatedAnimal.getGender());
            existingAnimal.setName(updatedAnimal.getName());
            existingAnimal.setSpecies(updatedAnimal.getSpecies());
            existingAnimal.setCustomer(updatedAnimal.getCustomer());
            return animalRepository.save(existingAnimal);
        }

    }

    @Override
    public List<Animal> findAll() {
        return this.animalRepository.findAll();
    }

    @Override
    public Animal findByName(String name) {
        return this.animalRepository.findByName(name);
    }

    @Override
    public List<Animal> getByCustomerName(String name) {
        Customer customer = customerRepository.findByName(name);
        return this.animalRepository.findByCustomer(customer);
    }
}
