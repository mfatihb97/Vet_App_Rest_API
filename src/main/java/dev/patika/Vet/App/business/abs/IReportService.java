package dev.patika.Vet.App.business.abs;

import dev.patika.Vet.App.entity.Report;

import java.util.List;

public interface IReportService {

    Report getByID(int id);
    Report save(Report report);
    String delete(int id);
    Report update(Report report);
    List<Report> findAll();
}
