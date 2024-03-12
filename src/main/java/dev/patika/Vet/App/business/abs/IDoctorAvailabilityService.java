package dev.patika.Vet.App.business.abs;

import dev.patika.Vet.App.dto.ReportDto.DoctorAvDaysMapper;
import dev.patika.Vet.App.dto.ReportDto.DoctorAvDaysRequest;
import dev.patika.Vet.App.entity.DoctorAvailability;

import java.util.List;

public interface IDoctorAvailabilityService {

    DoctorAvailability getByID(Long id);
    DoctorAvailability save(DoctorAvDaysRequest doctorAvDaysRequest);
    String delete(Long id);
    DoctorAvailability update(DoctorAvDaysRequest doctorAvDaysRequest, Long id);
    List<DoctorAvailability> findAll();
}
