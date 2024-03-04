package dev.patika.Vet.App.dto.ReportDto;

import dev.patika.Vet.App.dao.AnimalRepository;
import dev.patika.Vet.App.dao.VaccinesRepository;
import dev.patika.Vet.App.entity.AnimalVaccine;
import org.springframework.beans.factory.annotation.Autowired;

public class AnimalVaccineSaveMapper {

    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private VaccinesRepository vaccinesRepository;

    public AnimalVaccine apply(AnimalVaccineSaveRequest animalVaccineSaveRequest){

        AnimalVaccine newAnimalVaccine = new AnimalVaccine();

        newAnimalVaccine.setPrtStart(animalVaccineSaveRequest.prtStart());
        newAnimalVaccine.setPrtEnd(animalVaccineSaveRequest.prtEnd());
        newAnimalVaccine.setVaccine(vaccinesRepository.findById(animalVaccineSaveRequest.vaccine())
                .orElseThrow());
        newAnimalVaccine.setAnimal(animalRepository.findById(animalVaccineSaveRequest.animal())
                .orElseThrow());

        return  newAnimalVaccine;
    }
}
