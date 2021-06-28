package com.example.covoiturage.repository;

import com.example.covoiturage.Models.Ville;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VilleReposptory extends JpaRepository<Ville,Long> {
    Ville findVilleByIdVille(Long id);
}
