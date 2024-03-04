package dev.patika.Vet.App.dto.ReportDto;

import java.time.LocalDate;

public record AnimalSaveRequest(
        String name,
        String species,
        String breed,
        String gender,
        String colour,
        LocalDate birthday,
        Long customer
) {
}
