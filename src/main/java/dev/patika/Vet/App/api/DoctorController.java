package dev.patika.Vet.App.api;

import dev.patika.Vet.App.business.abs.IDoctorService;
import dev.patika.Vet.App.entity.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vets")
public class DoctorController {

    @Autowired
    private IDoctorService doctorService;

    @GetMapping("/get")
    @ResponseStatus(HttpStatus.OK)
    public List<Doctor> findAll() {
        return this.doctorService.findAll();
    }

    @GetMapping("/getById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Doctor finByID(@PathVariable("id") Long id) {
        return this.doctorService.getByID(id);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Doctor save(@RequestBody Doctor doctor) {
        return this.doctorService.save(doctor);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Doctor update(
            @PathVariable("id") Long id,
            @RequestBody Doctor doctor) {
        return doctorService.update(doctor,id);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id) {
        return this.doctorService.delete(id);
    }
}
