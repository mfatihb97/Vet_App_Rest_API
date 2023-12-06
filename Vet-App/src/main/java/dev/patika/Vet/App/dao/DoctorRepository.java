package dev.patika.Vet.App.dao;

import dev.patika.Vet.App.entity.Doctor;
import dev.patika.Vet.App.entity.DoctorAvailability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Long> {

    Doctor findById(long id);
}
