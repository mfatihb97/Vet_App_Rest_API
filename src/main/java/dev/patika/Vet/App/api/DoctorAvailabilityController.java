package dev.patika.Vet.App.api;

import dev.patika.Vet.App.business.abs.IDoctorAvailabilityService;
import dev.patika.Vet.App.dto.ReportDto.DoctorAvDaysRequest;
import dev.patika.Vet.App.entity.DoctorAvailability;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vetAvailability")
public class DoctorAvailabilityController {

    @Autowired
    private IDoctorAvailabilityService doctorAvailabilityService;

    @GetMapping("/get")
    @ResponseStatus(HttpStatus.OK)
    public List<DoctorAvailability> findAll() {
        return this.doctorAvailabilityService.findAll();
    }

    @GetMapping("/getById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DoctorAvailability finByID(@PathVariable("id") Long id) {
        return this.doctorAvailabilityService.getByID(id);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public DoctorAvailability save(@RequestBody DoctorAvDaysRequest doctorAvDaysRequest) {
        return this.doctorAvailabilityService.save(doctorAvDaysRequest);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DoctorAvailability update(
            @PathVariable("id") Long id,
            @RequestBody DoctorAvDaysRequest doctorAvDaysRequest) {
        return doctorAvailabilityService.update(doctorAvDaysRequest,id);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id) {
        return this.doctorAvailabilityService.delete(id);
    }
}
