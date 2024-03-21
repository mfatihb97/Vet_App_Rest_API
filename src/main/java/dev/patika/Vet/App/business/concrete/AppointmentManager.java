package dev.patika.Vet.App.business.concrete;

import dev.patika.Vet.App.business.abs.IAppointmentService;
import dev.patika.Vet.App.dao.AnimalRepository;
import dev.patika.Vet.App.dao.AppointmentRepository;
import dev.patika.Vet.App.dao.DoctorAvailabilityRepository;
import dev.patika.Vet.App.dao.DoctorRepository;
import dev.patika.Vet.App.dto.ReportDto.AppointmentSaveMapper;
import dev.patika.Vet.App.dto.ReportDto.AppointmentSaveRequest;
import dev.patika.Vet.App.entity.Appointment;
import dev.patika.Vet.App.entity.DoctorAvailability;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Service
public class AppointmentManager implements IAppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private DoctorAvailabilityRepository doctorAvailabilityRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private AppointmentSaveMapper animalVaccineSaveMapper;
    @Override
    public Appointment getByID(Long id) {
        if (this.appointmentRepository.findById(id)==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }else {
            return this.appointmentRepository.findById(id).orElseThrow();
        }
    }

    @Override
    public Appointment save(AppointmentSaveRequest appointmentSaveRequest) {
        LocalDateTime appointmentDate = appointmentSaveRequest.appointmentDate();
        Long doctorID = appointmentSaveRequest.doctor();
        DoctorAvailability availableDate = doctorAvailabilityRepository.findByDoctorIdAndAvailableDays(doctorID,appointmentDate.toLocalDate());

        if (availableDate != null && isApointmentExistsOnDate(doctorID,appointmentDate)){
             throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }else {
            return this.appointmentRepository.save(animalVaccineSaveMapper.apply(appointmentSaveRequest));
        }
    }

    @Override
    public String delete(long id) {
        if (this.appointmentRepository.findById(id) == null){
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND);
        }else {
            this.appointmentRepository.delete(this.getByID(id));
            return "deleted the record with id: " + id;
        }
    }

    @Override
    public Appointment update(AppointmentSaveRequest appointmentSaveRequest, Long id) {
        Appointment existingAppointment = appointmentRepository.findById(id).orElseThrow();
        if (existingAppointment==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }else {
            existingAppointment.setAppointmentDate(appointmentSaveRequest.appointmentDate());
            existingAppointment.setDoctor(doctorRepository.findById(appointmentSaveRequest.doctor()).orElseThrow());
            existingAppointment.setAnimal(animalRepository.findById(appointmentSaveRequest.animal()).orElseThrow());
            return this.appointmentRepository.save(existingAppointment);
        }

    }

    @Override
    public List<Appointment> findAll() {
        return this.appointmentRepository.findAll();
    }

    @Override
    public List<Appointment> findByAnimalIdBetweenDates(LocalDateTime startDate, LocalDateTime endDate, Long animal_id) {
        return this.appointmentRepository.findByAppointmentDateBetweenAndAnimalId(startDate,endDate,animal_id);
    }

    @Override
    public List<Appointment> findByDoctorIdBetweenDates(LocalDateTime startDate, LocalDateTime endDate, Long doctor_id) {
        return this.appointmentRepository.findByAppointmentDateBetweenAndDoctorId(startDate,endDate,doctor_id);
    }

    @Override
    public List<Appointment> findByAppointmentDateBetweenAndDoctorName(LocalDateTime startDate, LocalDateTime endDate, String name) {
        List<Appointment> appointments = appointmentRepository.findAll();

        String regexPattern = ".*" + name + ".*";
        Pattern pattern = Pattern.compile(regexPattern, Pattern.CASE_INSENSITIVE);

        List<Appointment> foundAppointments = new ArrayList<>();

        for(Appointment appointment:appointments){
            Matcher matcher = pattern.matcher(appointment.getDoctor().getName());
            if(matcher.find()){
                foundAppointments.add(appointment);
            }
        }
        return  foundAppointments;

        //return this.appointmentRepository.findByAppointmentDateBetweenAndDoctorName(startDate,endDate,name);
    }

    @Override
    public List<Appointment> findByAppointmentDateBetweenAndAnimalName(LocalDateTime startDate, LocalDateTime endDate, String name) {
        List<Appointment> appointments = appointmentRepository.findAll();

        String regexPattern = ".*" + name + ".*";
        Pattern pattern = Pattern.compile(regexPattern, Pattern.CASE_INSENSITIVE);

        List<Appointment> foundAppointments = new ArrayList<>();

        for(Appointment appointment:appointments){
            Matcher matcher = pattern.matcher(appointment.getAnimal().getName());
            if(matcher.find()){
                foundAppointments.add(appointment);
            }
        }
        return  foundAppointments;

       // return this.appointmentRepository.findByAppointmentDateBetweenAndAnimalName(startDate,endDate,name);
    }

    private boolean isApointmentExistsOnDate(Long doctorId,LocalDateTime appointmentDate){
        return  appointmentRepository.existsByDoctorIdAndAppointmentDate(doctorId,appointmentDate);
    }


}
