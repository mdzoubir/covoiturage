package com.example.covoiturage.Models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
public class Covoiturage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idC;

    @NotBlank
    @Column
    private String DateArr;

    @NotBlank
    @Column
    private String DateDepart;

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

    @ManyToOne
    @JoinColumn(name = "idUser")
    private User user;

    @OneToMany(mappedBy = "covoiturage")
    private List<Ville> villesPassage;


    public Covoiturage() {
    }


    public Long getIdC() {
        return idC;
    }

    public void setIdC(Long idC) {
        this.idC = idC;
    }

    public String getDateArr() {
        return DateArr;
    }

    public void setDateArr(String dateArr) {
        DateArr = dateArr;
    }

    public String getDateDepart() {
        return DateDepart;
    }

    public void setDateDepart(String dateDepart) {
        DateDepart = dateDepart;
    }

    public String getHeurArr() {
        return heurArr;
    }

    public void setHeurArr(String heurArr) {
        this.heurArr = heurArr;
    }

    public String getHeurDepart() {
        return heurDepart;
    }

    public void setHeurDepart(String heurDepart) {
        this.heurDepart = heurDepart;
    }

    public String getVilleDepart() {
        return villeDepart;
    }

    public void setVilleDepart(String villeDepart) {
        this.villeDepart = villeDepart;
    }

    public String getVilleArr() {
        return villeArr;
    }

    public void setVilleArr(String villeArr) {
        this.villeArr = villeArr;
    }

    public List<Ville> getVillesPassage() {
        return villesPassage;
    }

    public void setVillesPassage(List<Ville> villesPassage) {
        this.villesPassage = villesPassage;
    }

    public Float getPrix() {
        return prix;
    }

    public void setPrix(Float prix) {
        this.prix = prix;
    }
}
