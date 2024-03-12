package dev.patika.Vet.App.dto.ReportDto;

import java.time.LocalDate;

public record DoctorAvDaysRequest(

        LocalDate availableDays,

        Long doctor
) {
}
