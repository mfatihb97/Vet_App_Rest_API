package dev.patika.Vet.App.dto.ReportDto;

import dev.patika.Vet.App.dao.DoctorAvailabilityRepository;
import dev.patika.Vet.App.dao.DoctorRepository;
import dev.patika.Vet.App.entity.DoctorAvailability;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DoctorAvDaysMapper {

    @Autowired
    private DoctorRepository doctorRepository;


    public DoctorAvailability apply(DoctorAvDaysRequest doctorAvDaysRequest){

        DoctorAvailability newDoctorAv = new DoctorAvailability();

        newDoctorAv.setDoctor(doctorRepository.findById(doctorAvDaysRequest.doctor())
                .orElseThrow());
        newDoctorAv.setAvailableDays(doctorAvDaysRequest.availableDays());

        return newDoctorAv;
    }
}
