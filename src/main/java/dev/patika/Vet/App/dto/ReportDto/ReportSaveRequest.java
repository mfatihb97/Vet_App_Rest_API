package dev.patika.Vet.App.dto.ReportDto;

public record ReportSaveRequest(
        String title,
        String diagnosis,
        double price,

        Long appointment
) {

}
