package dev.patika.Vet.App.api;

import dev.patika.Vet.App.business.abs.IReportService;
import dev.patika.Vet.App.entity.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public Report getById(@PathVariable("id") int id){
        return this.reportService.getByID(id);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Report save(@RequestBody Report report){
        return this.reportService.save(report);
    }



    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public Report update(@RequestBody Report report){
        return reportService.save(report);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id){
        return this.reportService.delete((int) id);
    }


}
