package com.example.covoiturage.responce;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Date;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CovoiturageResponce {
    private java.sql.Date DateDepart;
    private String heurArr;
    private Date DateArr;
    private  String heurDepart;
    private String  villeDepart;
    private String villeArr;
    private  Float prix;
    private String username;
}
