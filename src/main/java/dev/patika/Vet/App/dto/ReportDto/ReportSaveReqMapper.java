package dev.patika.Vet.App.dto.ReportDto;

import dev.patika.Vet.App.dao.AnimalVaccineRepository;
import dev.patika.Vet.App.dao.AppointmentRepository;
import dev.patika.Vet.App.entity.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;


@Component
public class ReportSaveReqMapper implements Function<ReportSaveRequest,Report> {

    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private AnimalVaccineRepository animalVaccineRepository;

    @Override
    public Report apply(ReportSaveRequest reportSaveRequest){

        Report newReport = new Report();

        newReport.setTitle(reportSaveRequest.title());
        newReport.setDiagnosis(reportSaveRequest.diagnosis());
        newReport.setPrice(reportSaveRequest.price());
        newReport.setAppointment(appointmentRepository.findById(reportSaveRequest.appointmentID())
                .orElseThrow());
        newReport.setAnimalVaccine(animalVaccineRepository.findById(reportSaveRequest.animalVaccineID())
                .orElseThrow());

        return newReport;
    }


}
