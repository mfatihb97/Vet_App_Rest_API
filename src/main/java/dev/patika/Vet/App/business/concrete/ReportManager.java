package dev.patika.Vet.App.business.concrete;

import dev.patika.Vet.App.business.abs.IReportService;
import dev.patika.Vet.App.dao.ReportRepository;
import dev.patika.Vet.App.dto.ReportDto.ReportSaveReqMapper;
import dev.patika.Vet.App.dto.ReportDto.ReportSaveRequest;
import dev.patika.Vet.App.entity.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ReportManager implements IReportService {
    @Autowired
    private ReportRepository reportRepository;

    @Autowired
    private ReportSaveReqMapper reportSaveReqMapper;

    @Override
    public Report getByID(Long id) {
        if (this.reportRepository.findById(id) == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id yok");
        } else {
            return this.reportRepository.findById(id).orElseThrow();
        }

    }

    @Override
    public Report save(ReportSaveRequest report) {
        return this.reportSaveReqMapper.apply(report);
    }

    @Override
    public String delete(Long id) {
        if (this.reportRepository.findById(id) == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            this.reportRepository.delete(this.getByID(id));
            return "deleted the record with id: " + id;
        }

    }

    @Override
    public Report update(ReportSaveRequest reportSaveRequest, Long id) {
        Report existingReport = reportRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        existingReport.setTitle(reportSaveRequest.title());
        existingReport.setPrice(reportSaveRequest.price());
        existingReport.setDiagnosis(reportSaveRequest.diagnosis());
        return reportRepository.save(existingReport);

    }

    @Override
    public List<Report> findAll() {
        return this.reportRepository.findAll();
    }
}
