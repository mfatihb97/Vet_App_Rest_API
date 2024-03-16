package dev.patika.Vet.App.business.abs;

import dev.patika.Vet.App.dto.ReportDto.AppointmentSaveRequest;
import dev.patika.Vet.App.entity.Appointment;

import java.time.LocalDateTime;
import java.util.List;

public interface IAppointmentService {
    Appointment getByID(Long id);
    Appointment save(AppointmentSaveRequest appointmentSaveRequest);

    String delete(long id);
    Appointment update(AppointmentSaveRequest appointment, Long id);

    List<Appointment> findAll();

    List<Appointment> findByAnimalIdBetweenDates(LocalDateTime startDate, LocalDateTime endDate, Long animal_id);

    List<Appointment> findByDoctorIdBetweenDates(LocalDateTime startDate,LocalDateTime endDate,Long animal_id);

    List<Appointment> findByAppointmentDateBetweenAndDoctorName(LocalDateTime startDate,LocalDateTime endDate,String name);

    List<Appointment> findByAppointmentDateBetweenAndAnimalName(LocalDateTime startDate,LocalDateTime endDate,String name);


}
