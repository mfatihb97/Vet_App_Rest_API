package dev.patika.Vet.App.business.concrete;

import dev.patika.Vet.App.business.abs.IVaccineService;
import dev.patika.Vet.App.dao.VaccinesRepository;
import dev.patika.Vet.App.entity.Vaccine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class VaccinesManager implements IVaccineService {

    @Autowired
    private VaccinesRepository vaccinesRepository;
    @Override
    public Vaccine getByID(Long id) {
        if (this.vaccinesRepository.findById(id) == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            return this.vaccinesRepository.findById(id).orElseThrow();
        }
    }

    @Override
    public Vaccine save(Vaccine vaccines) {
        return this.vaccinesRepository.save(vaccines);
    }

    @Override
    public String delete(Long id) {
        if (this.vaccinesRepository.findById(id) == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            this.vaccinesRepository.delete(this.getByID(id));
            return "deleted the record with id: " + id;
        }
    }

    @Override
    public Vaccine update(Vaccine vaccines,Long id) {
        Vaccine existingVaccine = vaccinesRepository.findById(id).orElseThrow();
        if (existingVaccine==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }else {
            existingVaccine.setVaccineName(vaccines.getVaccineName());
            existingVaccine.setVaccineCode(vaccines.getVaccineCode());
            return this.vaccinesRepository.save(existingVaccine);
        }
    }

    @Override
    public List<Vaccine> findAll() {
        return this.vaccinesRepository.findAll();
    }
}
