package dev.patika.Vet.App.business.abs;

import dev.patika.Vet.App.entity.Vaccine;

import java.util.List;

public interface IVaccineService {
    Vaccine getByID(Long id);
    Vaccine save(Vaccine vaccine);
    String delete(Long id);
    Vaccine update(Vaccine vaccine);
    List<Vaccine> findAll();
}
