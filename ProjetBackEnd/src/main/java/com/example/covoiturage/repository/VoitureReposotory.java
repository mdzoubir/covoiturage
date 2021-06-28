package com.example.covoiturage.repository;

import com.example.covoiturage.Models.Voiture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoitureReposotory  extends JpaRepository<Voiture,Long>{
    Voiture findVoitureByIdV(Long id);
}
