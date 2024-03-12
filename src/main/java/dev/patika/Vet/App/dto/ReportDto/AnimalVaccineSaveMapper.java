package dev.patika.Vet.App.dto.ReportDto;

import dev.patika.Vet.App.dao.AnimalRepository;
import dev.patika.Vet.App.dao.ReportRepository;
import dev.patika.Vet.App.dao.VaccinesRepository;
import dev.patika.Vet.App.entity.AnimalVaccine;
import dev.patika.Vet.App.entity.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AnimalVaccineSaveMapper {

    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private VaccinesRepository vaccinesRepository;
    @Autowired
    private ReportRepository reportRepository;

    public AnimalVaccine apply(AnimalVaccineSaveRequest animalVaccineSaveRequest){

        AnimalVaccine newAnimalVaccine = new AnimalVaccine();

        newAnimalVaccine.setPrtStart(animalVaccineSaveRequest.prtStart());
        newAnimalVaccine.setPrtEnd(animalVaccineSaveRequest.prtEnd());
        newAnimalVaccine.setReport(reportRepository.findById(animalVaccineSaveRequest.report())
                .orElseThrow());
        newAnimalVaccine.setVaccine(vaccinesRepository.findById(animalVaccineSaveRequest.vaccine())
                .orElseThrow());
        newAnimalVaccine.setAnimal(animalRepository.findById(animalVaccineSaveRequest.animal())
                .orElseThrow());

        return  newAnimalVaccine;
    }
}
