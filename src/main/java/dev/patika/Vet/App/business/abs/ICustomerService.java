package dev.patika.Vet.App.business.abs;

import dev.patika.Vet.App.entity.Animal;
import dev.patika.Vet.App.entity.Customer;

import java.util.List;

public interface ICustomerService {
    Customer getByID(Long id);
    Customer save(Customer customer);
    String delete(Long id);
    Customer update(Customer customer);
    List<Customer> findAll();
    Customer findByName(String name);

    List<Animal> findAnimalByCustomerID(Long id);
}
