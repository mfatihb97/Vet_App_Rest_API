package dev.patika.Vet.App.dao;

import dev.patika.Vet.App.entity.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VaccinesRepository extends JpaRepository<Vaccine,Long> {
    boolean existsByVaccineNameAndVaccineCode(String vaccineName,String vaccineCode);
}
