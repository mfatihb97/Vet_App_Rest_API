package dev.patika.Vet.App.dao;

import dev.patika.Vet.App.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Long> {
    boolean existsByNameAndPhoneAndMailAndAddressAndCity(String name, String phone, String mail, String address, String city);
}
