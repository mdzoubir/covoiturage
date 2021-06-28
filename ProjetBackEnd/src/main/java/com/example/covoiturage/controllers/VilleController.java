package com.example.covoiturage.controllers;


import com.example.covoiturage.Models.Ville;
import com.example.covoiturage.services.VilleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/ville")
public class VilleController {
    @Autowired
    private VilleService villeService;

    @PostMapping
    public ResponseEntity<Ville> createVille(@RequestBody Ville ville)
    {
        Ville villes=villeService.createVille(ville);
        return  new ResponseEntity<>(villes, HttpStatus.CREATED);
    }

    @PutMapping(path = "/{villeId}")
    public ResponseEntity<Ville> updateVille(@RequestBody Ville ville,@PathVariable Long villeId)
    {
        Ville villes=villeService.updateVille(villeId,ville);
        return  new ResponseEntity<>(villes,HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/RemoveVille/{villeId}")
    public ResponseEntity<Ville> removeVille(@PathVariable Long villeId)
    {
        villeService.deleteVille(villeId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT) ;
    }

    @GetMapping("getAllVilles")
    public ResponseEntity<Ville> getAllVilles(){
        List<Ville> villeList=villeService.getAllVille();
        return  new ResponseEntity(villeList,HttpStatus.OK);
    }

    @GetMapping("/getVilleById/{villeId}")
    public ResponseEntity<Ville> getById(@PathVariable Long villeId)
    {
        Ville ville=villeService.getVilleById(villeId);
        return new ResponseEntity<>(ville,HttpStatus.OK);
    }
}
