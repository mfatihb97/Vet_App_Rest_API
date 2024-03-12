package dev.patika.Vet.App.dto.ReportDto;


import dev.patika.Vet.App.dao.AnimalRepository;
import dev.patika.Vet.App.dao.DoctorRepository;
import dev.patika.Vet.App.entity.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AppointmentSaveMapper {

    @Autowired

    private AnimalRepository animalRepository;

    @Autowired
    private DoctorRepository doctorRepository;
    public Appointment apply(AppointmentSaveRequest appointmentSaveRequest){

        Appointment newAppointment = new Appointment();

        newAppointment.setAppointmentDate(appointmentSaveRequest.appointmentDate());
        newAppointment.setAnimal(animalRepository.findById(appointmentSaveRequest.animal())
                .orElseThrow());
        newAppointment.setDoctor(doctorRepository.findById(appointmentSaveRequest.doctor())
                .orElseThrow());

        return  newAppointment;
    }

}
