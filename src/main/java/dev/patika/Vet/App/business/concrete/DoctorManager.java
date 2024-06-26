package dev.patika.Vet.App.business.concrete;

import dev.patika.Vet.App.business.abs.IDoctorService;
import dev.patika.Vet.App.dao.DoctorRepository;
import dev.patika.Vet.App.entity.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class DoctorManager implements IDoctorService {

    @Autowired
    private DoctorRepository doctorRepository;
    @Override
    public Doctor getByID(Long id) {
        if (this.doctorRepository.findById(id) == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            return this.doctorRepository.findById(id).orElseThrow();
        }
    }

    @Override
    public Doctor save(Doctor doctor) {
        if(doctorRepository.existsByNameAndPhoneAndMailAndAddressAndCity(
                doctor.getName(),
                doctor.getPhone(),
                doctor.getMail(),
                doctor.getAddress(),
                doctor.getCity()
        )){
            throw new IllegalArgumentException("This doctor is already exist!");
        }
        return this.doctorRepository.save(doctor);
    }

    @Override
    public String delete(Long id) {
        if (this.doctorRepository.findById(id) == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            this.doctorRepository.delete(this.getByID(id));
            return "deleted the record with id: " + id;
        }
    }

    @Override
    public Doctor update(Doctor doctor,Long id) {
        Doctor existingDoctor = doctorRepository.findById(id).orElseThrow();
        if (existingDoctor==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }else {
            existingDoctor.setName(doctor.getName());
            existingDoctor.setCity(doctor.getCity());
            existingDoctor.setAddress(doctor.getAddress());
            existingDoctor.setMail(doctor.getMail());
            existingDoctor.setPhone(doctor.getPhone());
            return this.doctorRepository.save(existingDoctor);
        }

    }

    @Override
    public List<Doctor> findAll() {
        return this.doctorRepository.findAll();
    }
}
