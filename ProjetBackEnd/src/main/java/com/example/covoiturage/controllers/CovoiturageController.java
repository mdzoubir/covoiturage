package com.example.covoiturage.controllers;


import com.example.covoiturage.Models.Covoiturage;
import com.example.covoiturage.Models.Ville;
import com.example.covoiturage.services.CovoiturageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/covoiturage")
public class CovoiturageController {
    @Autowired
    private CovoiturageService covoiturageService;

    @PostMapping
    public ResponseEntity<Covoiturage> createCovoiturage(@RequestBody Covoiturage covoiturage)
    {
        Covoiturage covoiturages=covoiturageService.createCovoiturage(covoiturage);
        return  new ResponseEntity<>(covoiturages, HttpStatus.CREATED);
    }


    @PutMapping("/{covoiId}")
    public ResponseEntity<Covoiturage> updateCovoiturage(@RequestBody Covoiturage covoiturage,@PathVariable Long CovoId)
    {
        Covoiturage covoiturages=covoiturageService.createCovoiturage(covoiturage);
        return  new ResponseEntity<>(covoiturages,HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/RemoveCovoi/{covoiId}")
    public ResponseEntity<Covoiturage> removeCovoi(@PathVariable Long covoiId)
    {
        covoiturageService.deleteCovoiturage(covoiId);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("getAllConvoi")
    public ResponseEntity<Covoiturage> getAllCovoi()
    {
        List<Covoiturage> covoiList=covoiturageService.getAllCovoiturage();
        return new ResponseEntity(covoiList,HttpStatus.OK);
    }

    @GetMapping("/getConvoi/{covoiId}")
    public ResponseEntity<Ville> getById(@PathVariable Long covoiId)
    {
       Covoiturage covoiturage=covoiturageService.getCovoiturageById(covoiId);
        return new ResponseEntity(covoiturage,HttpStatus.OK);
    }

}
