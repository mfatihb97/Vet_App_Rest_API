package dev.patika.Vet.App.business.concrete;

import dev.patika.Vet.App.business.abs.IReportService;
import dev.patika.Vet.App.dao.ReportRepository;
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

    @Override
    public Report getByID(int id) {
        if (this.reportRepository.findById(id) == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Id yok");
        } else {
            return this.reportRepository.findById(id);
        }

    }
    @Override
    public Report save(Report report) {
        return this.reportRepository.save(report);
    }

    @Override
    public String delete(int id) {
        if (this.reportRepository.findById(id) == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            this.reportRepository.delete(this.getByID(id));
            return "deleted the record with id: " + id;
        }

    }

    @Override
    public Report update(Report report) {
        Report existingReport = reportRepository.findById(report.getId());
        if (existingReport == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }else{
            existingReport.setTitle(report.getTitle());
            existingReport.setPrice(report.getPrice());
            existingReport.setDiagnosis(report.getDiagnosis());
            return reportRepository.save(existingReport);
        }

    }

    @Override
    public List<Report> findAll() {
        return this.reportRepository.findAll();
    }
}
