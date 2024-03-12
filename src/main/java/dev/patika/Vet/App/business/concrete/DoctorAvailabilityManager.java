package dev.patika.Vet.App.business.concrete;

import dev.patika.Vet.App.business.abs.IDoctorAvailabilityService;
import dev.patika.Vet.App.dao.DoctorAvailabilityRepository;
import dev.patika.Vet.App.dao.DoctorRepository;
import dev.patika.Vet.App.dto.ReportDto.DoctorAvDaysMapper;
import dev.patika.Vet.App.dto.ReportDto.DoctorAvDaysRequest;
import dev.patika.Vet.App.entity.DoctorAvailability;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class DoctorAvailabilityManager implements IDoctorAvailabilityService {

    @Autowired
    private DoctorAvailabilityRepository doctorAvailabilityRepository;

    @Autowired
    private DoctorAvDaysMapper doctorAvDaysMapper;

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public DoctorAvailability getByID(Long id) {

        if (this.doctorAvailabilityRepository.findById(id) == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            return this.doctorAvailabilityRepository.findById(id).orElseThrow();
        }
    }

    @Override
    public DoctorAvailability save(DoctorAvDaysRequest doctorAvDaysRequest) {
        return this.doctorAvailabilityRepository.save(doctorAvDaysMapper.apply(doctorAvDaysRequest));
    }

    @Override
    public String delete(Long id) {
        if (this.doctorAvailabilityRepository.findById(id) == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            this.doctorAvailabilityRepository.delete(this.getByID(id));
            return "deleted the record with id: " + id;
        }
    }

    @Override
    public DoctorAvailability update(DoctorAvDaysRequest doctorAvDaysRequest,Long id) {
        DoctorAvailability existingDoctorAv = doctorAvailabilityRepository.findById(id).orElseThrow();
        if (existingDoctorAv==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }else {
            existingDoctorAv.setAvailableDays(doctorAvDaysRequest.availableDays());
            existingDoctorAv.setDoctor(doctorRepository.findById(doctorAvDaysRequest.doctor()).orElseThrow());
            return this.doctorAvailabilityRepository.save(existingDoctorAv);
        }

    }

    @Override
    public List<DoctorAvailability> findAll() {
        return this.doctorAvailabilityRepository.findAll();
    }
}
