package dev.patika.Vet.App.dao;

import dev.patika.Vet.App.entity.Doctor;
import dev.patika.Vet.App.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository extends JpaRepository<Report,Long> {
    Report findById(long id);
}
