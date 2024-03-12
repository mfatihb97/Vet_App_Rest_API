package dev.patika.Vet.App.dto.ReportDto;

import java.time.LocalDate;

public record AnimalVaccineSaveRequest(
        LocalDate prtStart,
        LocalDate prtEnd,
        Long report,

        Long animal,
        Long vaccine

) {
}
