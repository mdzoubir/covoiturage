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

    public String getAdresDepart() {
        return adresDepart;
    }

    public void setAdresDepart(String adresDepart) {
        this.adresDepart = adresDepart;
    }

    public String getDatePublie() {
        return DatePublie;
    }

    public void setDatePublie(String datePublie) {
        DatePublie = datePublie;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Voiture getVoiture() {
        return voiture;
    }

    public void setVoiture(Voiture voiture) {
        this.voiture = voiture;
    }

    public Integer getNbrPlace() {
        return nbrPlace;
    }

    public void setNbrPlace(Integer nbrPlace) {
        this.nbrPlace = nbrPlace;
    }
}
