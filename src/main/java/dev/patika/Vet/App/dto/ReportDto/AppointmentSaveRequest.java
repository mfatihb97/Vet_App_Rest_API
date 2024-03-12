package dev.patika.Vet.App.dto.ReportDto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record AppointmentSaveRequest(
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm")  LocalDateTime appointmentDate,
        Long animal,
        Long doctor

) {
}
