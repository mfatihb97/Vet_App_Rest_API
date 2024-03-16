package dev.patika.Vet.App.dao;

import dev.patika.Vet.App.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    Customer findByName(String name);
    boolean existsByNameAndPhoneAndMailAndAddressAndCity(String name, String phone, String mail, String address, String city);
}
