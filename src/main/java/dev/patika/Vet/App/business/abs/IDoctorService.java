package dev.patika.Vet.App.business.abs;

import dev.patika.Vet.App.entity.Doctor;

import java.util.List;

public interface IDoctorService {

    Doctor getByID(Long id);
    Doctor save(Doctor doctor);
    String delete(Long id);
    Doctor update(Doctor doctor);
    List<Doctor> findAll();
}
