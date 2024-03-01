package dev.patika.Vet.App.api;

import dev.patika.Vet.App.business.abs.IReportService;
import dev.patika.Vet.App.dto.ReportDto.ReportSaveRequest;
import dev.patika.Vet.App.entity.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reports")
public class ReportController {
    @Autowired
    private IReportService reportService;

    @GetMapping("/get")
    @ResponseStatus(HttpStatus.OK)
    public List<Report> findAll(){
        return this.reportService.findAll();
    }

    @GetMapping("/getById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Report getById(@PathVariable("id") Long id){
        return this.reportService.getByID(id);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Report save(@RequestBody ReportSaveRequest reportSaveRequest){
        return this.reportService.save(reportSaveRequest);
    }



    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Report update(
            @PathVariable("id") Long id,
            @RequestBody ReportSaveRequest reportSaveRequest){
        return reportService.update(reportSaveRequest,id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        int result = Integer.parseInt(this.reportService.delete(id));
        if (result > 0) {
            return new ResponseEntity<>("Silme işlemi başarılı", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Belirtilen ID'ye sahip rapor bulunamadı", HttpStatus.NOT_FOUND);
        }
    }



}
