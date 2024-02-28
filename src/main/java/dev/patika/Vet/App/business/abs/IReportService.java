package dev.patika.Vet.App.business.abs;

import dev.patika.Vet.App.dto.ReportDto.ReportSaveRequest;
import dev.patika.Vet.App.entity.Report;

import java.util.List;

public interface IReportService {

    Report getByID(Long id);
    Report save(ReportSaveRequest reportSaveRequest);
    String delete(Long id);
    Report update(ReportSaveRequest reportSaveRequest,Long id);
    List<Report> findAll();
}
