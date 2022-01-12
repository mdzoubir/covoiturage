package com.example.covoiturage.controllers;



import com.example.covoiturage.Models.Voiture;
import com.example.covoiturage.services.VoitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/voiture")
public class VoitureController {

    @Autowired
    private VoitureService voitureService;

    @PostMapping("/{userId}")
    public ResponseEntity<Voiture> createVille(@RequestBody Voiture voiture, @PathVariable Long userId)
    {
        Voiture voitures = voitureService.createVoiture(voiture, userId);
        return new ResponseEntity<>(voitures, HttpStatus.CREATED);
    }

    @PutMapping(path = "/{matricule}")
    public  ResponseEntity<Voiture> updateVille(@RequestBody Voiture voiture,@PathVariable Long id)
    {
        Voiture voitures=voitureService.updateVoiture(id,voiture);
        return  new ResponseEntity<>(voitures,HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/RemoveVoiture/{voitureId}")
    public ResponseEntity<Voiture> removeVoiture(@PathVariable Long voitureId)
    {
        voitureService.deleteVoiture(voitureId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/getVoitureBymatricule/{matricule}")
    public ResponseEntity<Voiture> getByMatricule(@PathVariable Long voitureId)
    {
        Voiture voiture=voitureService.getVoitureById(voitureId);
        return new ResponseEntity<>(voiture,HttpStatus.OK);
    }

    @GetMapping("getAllVoiture")
    public ResponseEntity<Voiture> getAllVoiture()
    {
        List<Voiture> listVoiture=voitureService.geteAllVoiture();
        return new ResponseEntity(listVoiture,HttpStatus.OK);
    }
}
