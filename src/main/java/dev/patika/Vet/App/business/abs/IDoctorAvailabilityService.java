package dev.patika.Vet.App.business.abs;

import dev.patika.Vet.App.entity.DoctorAvailability;

import java.util.List;

public interface IDoctorAvailabilityService {

    DoctorAvailability getByID(Long id);
    DoctorAvailability save(DoctorAvailability doctorAvailability);
    String delete(Long id);
    DoctorAvailability update(DoctorAvailability doctorAvailability);
    List<DoctorAvailability> findAll();
}
