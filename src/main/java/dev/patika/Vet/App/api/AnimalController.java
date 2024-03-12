package dev.patika.Vet.App.api;

import dev.patika.Vet.App.business.abs.IAnimalService;
import dev.patika.Vet.App.dto.ReportDto.AnimalSaveRequest;
import dev.patika.Vet.App.entity.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animals")
public class AnimalController {
    @Autowired
    private IAnimalService animalService;

    @GetMapping("/get")
    @ResponseStatus(HttpStatus.OK)
    public List<Animal> findAll(){
        return this.animalService.findAll();
    }

    @GetMapping("/getById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Animal getById(@PathVariable("id")Long id){
        return this.animalService.getByID(id);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Animal save(@RequestBody AnimalSaveRequest animalSaveRequest){
        return this.animalService.save(animalSaveRequest);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Animal update(
            @PathVariable("id") Long id,
            @RequestBody AnimalSaveRequest animalSaveRequest){
        return animalService.update(animalSaveRequest,id);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        return this.animalService.delete(id);
    }


}
