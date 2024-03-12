package dev.patika.Vet.App.entity;

import com.fasterxml.jackson.annotation.*;
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

    @OneToOne
    @JoinColumn(name="appointment_id",referencedColumnName = "id")
    @JsonManagedReference
    private Appointment appointment ;

    @OneToMany(mappedBy = "report",fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
    @JsonBackReference
    private List<AnimalVaccine> animalVaccine;

}

