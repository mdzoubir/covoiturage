package com.example.covoiturage.Models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Covoiturage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idC;

    @NotBlank
    @Column
//    @Temporal(TemporalType.DATE)
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date DateArr;

    @NotBlank
    @Column
//    @Temporal(TemporalType.DATE)
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private java.sql.Date DateDepart;

    @NotBlank
    @Column
    private String heurArr;

    @NotBlank
    @Column
    private  String heurDepart;

    @NotBlank
    @Column
    private String  villeDepart;

    @NotBlank
    @Column
    private String villeArr;

    @NotBlank
    @Column
    private  Float prix;

    @NotBlank
    @Column
    private  String adresDepart;

    @NotBlank
    @Column
    private  String DatePublie;

    @NotBlank
    @Column
    private  Integer nbrPlace;

    @ManyToOne
    @JoinColumn(name = "idUser")
    private User user;

    @ManyToOne
    @JoinColumn(name = "idV")
    private Voiture voiture;

    @OneToMany(mappedBy = "covoiturage")
    private List<Ville> villesPassage;



}
