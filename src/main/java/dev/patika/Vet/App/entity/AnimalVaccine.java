package dev.patika.Vet.App.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "animal_vaccines")
public class AnimalVaccine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Temporal(TemporalType.DATE)
    @Column(name = "protectionStart",nullable = false)
    private LocalDate prtStart;

    @Temporal(TemporalType.DATE)
    @Column(name = "protectionEnd",nullable = false)
    private LocalDate prtEnd;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "animal_id",referencedColumnName = "id")
    private Animal animal;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "vaccine_id",referencedColumnName = "id")
    private Vaccine vaccine;

    @OneToMany(mappedBy = "animalVaccine")
    @JsonIgnore
    private List<Report> reportList;
}
