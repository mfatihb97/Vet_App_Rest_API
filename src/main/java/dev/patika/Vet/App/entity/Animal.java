package dev.patika.Vet.App.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
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
@Table(name = "animals")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "species")
    private String species;

    @Column(name = "breed")
    private String breed;

    @Column(name = "gender")
    private String gender;

    @Column(name = "colour")
    private String colour;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "birthday")
    private LocalDate birthday;

    @OneToMany(mappedBy = "animal",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<AnimalVaccine> animalVaccineList;

    @OneToMany(mappedBy = "animal",cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<Appointment> appointmentList;


    @ManyToOne
    @JoinColumn(name = "customer_id",referencedColumnName = "id")
    private Customer customer;



}
