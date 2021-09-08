package com.example.covoiturage.repository;

import com.example.covoiturage.Models.Covoiturage;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Repository
public interface CovoiturageReposotory extends JpaRepository<Covoiturage,Long> {
   Covoiturage findByIdC(long id);
  List<Covoiturage> findAllByVilleDepartAndVilleArr(String villeDepart,String  villeArr);
  @Query("FROM Covoiturage ctg ORDER BY  ctg.idC DESC")
  List<Covoiturage> findListeCinq(Pageable pageable);
  @Query("FROM Covoiturage  ctg WHERE ctg.DateDepart >= :dateDepart")
  List<Covoiturage> findListDate(@Param("dateDepart") Date dateDepart);





}
