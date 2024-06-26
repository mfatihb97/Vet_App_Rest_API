package dev.patika.Vet.App.api;

import dev.patika.Vet.App.business.abs.ICustomerService;
import dev.patika.Vet.App.entity.Animal;
import dev.patika.Vet.App.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @GetMapping("/get")
    @ResponseStatus(HttpStatus.OK)
    public List<Customer> findAll(){
        return this.customerService.findAll();
    }

    @GetMapping("/getById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Customer finByID(@PathVariable("id") Long id){
        return this.customerService.getByID(id);
    }

    @GetMapping("/getByName/{name}")
    @ResponseStatus(HttpStatus.OK)
    public List<Customer> findByName(@PathVariable("name") String name){
        return this.customerService.findByName(name);
    }

    @GetMapping("/getPets/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Animal> getPets(@PathVariable("id") Long id){
        return customerService.findAnimalByCustomerID(id);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Customer save(@RequestBody Customer customer){
        return this.customerService.save(customer);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Customer update(
            @PathVariable("id") Long id,
            @RequestBody Customer customer){
        return customerService.update(customer,id);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id){
        return this.customerService.delete(id);
    }
}
