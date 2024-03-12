package dev.patika.Vet.App.business.concrete;

import dev.patika.Vet.App.business.abs.IAnimalVaccineService;
import dev.patika.Vet.App.dao.AnimalRepository;
import dev.patika.Vet.App.dao.AnimalVaccineRepository;
import dev.patika.Vet.App.dao.VaccinesRepository;
import dev.patika.Vet.App.dto.ReportDto.AnimalVaccineSaveMapper;
import dev.patika.Vet.App.dto.ReportDto.AnimalVaccineSaveRequest;
import dev.patika.Vet.App.entity.AnimalVaccine;
import dev.patika.Vet.App.entity.Vaccine;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@Service
public class AnimalVaccineManager implements IAnimalVaccineService {

    @Autowired
    private AnimalVaccineRepository animalVaccineRepository;

    @Autowired
    private AnimalVaccineSaveMapper animalVaccineSaveMapper;

    @Autowired
    private AnimalRepository animalRepository;
    @Autowired
    private VaccinesRepository vaccinesRepository;

    @Override
    public AnimalVaccine getByID(Long id) {
        if (this.animalVaccineRepository.findById(id)==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }else {
            return this.animalVaccineRepository.findById(id).orElseThrow();
        }
    }



    @Override
    public AnimalVaccine save(AnimalVaccineSaveRequest animalVaccineSaveRequest) {
       Long animalID = animalVaccineSaveRequest.animal();
       Long vaccineID = animalVaccineSaveRequest.vaccine();
       AnimalVaccine oldVaccine = animalVaccineRepository.findByAnimalIdAndVaccineId(animalID,vaccineID);

       if (oldVaccine != null && oldVaccine.getPrtEnd().isAfter(animalVaccineSaveRequest.prtStart())){
           throw  new ResponseStatusException(HttpStatus.CONFLICT);
       }

       return this.animalVaccineRepository.save(animalVaccineSaveMapper.apply(animalVaccineSaveRequest));
    }

    @Override
    public String delete(Long id) {
        if (this.animalVaccineRepository.findById(id)==null){
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND);
        }else {
            this.animalVaccineRepository.delete(this.getByID(id));
            return "deleted the record with id: " + id;
        }
    }

    @Override
    public AnimalVaccine update(AnimalVaccineSaveRequest animalVaccineSaveRequest, Long id) {
        AnimalVaccine existingAnimalVaccine = animalVaccineRepository.findById(id).orElseThrow();
        if (existingAnimalVaccine == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }else {
            existingAnimalVaccine.setPrtStart(animalVaccineSaveRequest.prtStart());
            existingAnimalVaccine.setPrtEnd(animalVaccineSaveRequest.prtEnd());
            existingAnimalVaccine.setAnimal(animalRepository.findById(animalVaccineSaveRequest.animal()).orElseThrow());
            existingAnimalVaccine.setVaccine(vaccinesRepository.findById(animalVaccineSaveRequest.vaccine()).orElseThrow());
            return this.animalVaccineRepository.save(existingAnimalVaccine);
        }

    }

    @Override
    public List<AnimalVaccine> findAll() {
        return this.animalVaccineRepository.findAll();
    }

    @Override
    public List<AnimalVaccine> findAnimalVaccineByAnimalID(Long id) {
        AnimalVaccine animalVaccine = animalVaccineRepository.findById(id).orElseThrow();
        if (animalVaccine!=null){
            return animalVaccine.getAnimal().getAnimalVaccineList();
        }else {
            return Collections.emptyList();
        }
    }

    @Override
    public List<AnimalVaccine> findAllByPrtStartBetween(LocalDate prt_start, LocalDate prt_end) {
        return animalVaccineRepository.findAllByPrtStartBetween(prt_start,prt_end);
    }


}
