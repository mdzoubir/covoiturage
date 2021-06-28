package com.example.covoiturage.repository;

import com.example.covoiturage.Models.Covoiturage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CovoiturageReposotory extends JpaRepository<Covoiturage,Long> {
   Covoiturage findByIdC(long id);
}
