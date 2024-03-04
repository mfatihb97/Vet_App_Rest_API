package dev.patika.Vet.App.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "reports")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "diagnosis")
    private String diagnosis;

    @Column(name = "price")
    private double price;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="appointment_id",referencedColumnName = "id")
    @JsonManagedReference
    private Appointment appointment ;

    @ManyToOne
    @JoinColumn(name = "animal_vaccine_id",referencedColumnName = "id",nullable = false)
    @JsonManagedReference
    private AnimalVaccine animalVaccine;


}

