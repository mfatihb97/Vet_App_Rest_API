package dev.patika.Vet.App.business.concrete;

import dev.patika.Vet.App.business.abs.IReportService;
import dev.patika.Vet.App.dao.AnimalVaccineRepository;
import dev.patika.Vet.App.dao.ReportRepository;
import dev.patika.Vet.App.dto.ReportDto.ReportSaveReqMapper;
import dev.patika.Vet.App.dto.ReportDto.ReportSaveRequest;
import dev.patika.Vet.App.entity.Animal;
import dev.patika.Vet.App.entity.AnimalVaccine;
import dev.patika.Vet.App.entity.Report;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportManager implements IReportService {

    private final ReportRepository reportRepository;

    private final ReportSaveReqMapper reportSaveReqMapper;

    private final AnimalVaccineRepository animalVaccineRepository;

    @Override
    public Report getByID(Long id) {
        if (this.reportRepository.findById(id) == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ID not found");
        } else {
            return this.reportRepository.findById(id).orElseThrow();
        }

    }

    @Override
    public Report save(ReportSaveRequest report) {
        return reportRepository.save(reportSaveReqMapper.apply(report));
    }

    @Override
    public String delete(Long id) {
         Report report = this.reportRepository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"ID not found"));

         List<AnimalVaccine> animalVaccines = report.getAnimalVaccine();
         if(animalVaccines != null && !animalVaccines.isEmpty()){
             for(AnimalVaccine animalVaccine : animalVaccines){
                 animalVaccine.setReport(null);
                 animalVaccineRepository.save(animalVaccine);
             }
         }
         this.reportRepository.deleteById(id);
         return "deleted the record with id: " + id;
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
