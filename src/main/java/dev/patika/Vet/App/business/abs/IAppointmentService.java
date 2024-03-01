package dev.patika.Vet.App.business.abs;

import dev.patika.Vet.App.entity.Appointment;

import java.time.LocalDateTime;
import java.util.List;

public interface IAppointmentService {
    Appointment getByID(Long id);
    Appointment save(Appointment appointment);
    String delete(long id);
    Appointment update(Appointment appointment,Long id);

    List<Appointment> findAll();

    List<Appointment> findByAnimalIdBetweenDates(LocalDateTime startDate, LocalDateTime endDate, Long animal_id);

    List<Appointment> findByDoctorIdBetweenDates(LocalDateTime startDate,LocalDateTime endDate,Long animal_id);


}
