package dev.patika.Vet.App.business.concrete;

import dev.patika.Vet.App.business.abs.ICustomerService;
import dev.patika.Vet.App.dao.CustomerRepository;
import dev.patika.Vet.App.entity.Animal;
import dev.patika.Vet.App.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.List;

@Service
public class CustomerManager implements ICustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public Customer getByID(Long id) {
        if (this.customerRepository.findById(id)==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }else {
            return this.customerRepository.findById(id).orElseThrow();
        }
    }

    @Override
    public Customer save(Customer customer) {
        if(customerRepository.existsByNameAndPhoneAndMailAndAddressAndCity(
                customer.getName(),
                customer.getPhone(),
                customer.getMail(),
                customer.getAddress(),
                customer.getCity()
        )){
            throw new IllegalArgumentException("This customer is already exists!");
        }
        return this.customerRepository.save(customer);
    }

    @Override
    public String delete(Long id) {
        if (this.customerRepository.findById(id) == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            this.customerRepository.delete(this.getByID(id));
            return "deleted the record with id: " + id;
        }
    }

    @Override
    public Customer update(Customer customer,Long id) {
        Customer existingCustomer = customerRepository.findById(id).orElseThrow();
        if (existingCustomer==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }else {
            existingCustomer.setName(customer.getName());
            existingCustomer.setMail(customer.getMail());
            existingCustomer.setCity(customer.getCity());
            existingCustomer.setAddress(customer.getAddress());
            existingCustomer.setPhone(customer.getPhone());
            return this.customerRepository.save(existingCustomer);
        }

    }

    @Override
    public List<Customer> findAll() {
        return this.customerRepository.findAll();
    }

    @Override
    public Customer findByName(String name) {
        return this.customerRepository.findByName(name);
    }

    @Override
    public List<Animal> findAnimalByCustomerID(Long id) {
        Customer customer = customerRepository.findById(id).orElseThrow();
        if (customer!=null){
            return customer.getAnimalList();
        }else {
            return Collections.emptyList();
        }
    }
}
