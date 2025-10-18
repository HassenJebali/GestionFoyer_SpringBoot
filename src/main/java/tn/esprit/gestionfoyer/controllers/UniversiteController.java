package tn.esprit.gestionfoyer.controllers;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import tn.esprit.gestionfoyer.entities.Universite;
import tn.esprit.gestionfoyer.services.UniversiteService;

import java.util.List;

@RestController
@RequestMapping("/universite")
@AllArgsConstructor
public class UniversiteController{

    final UniversiteService universiteService;

    @PostMapping("/add")
    Universite addUniversite(@RequestBody Universite universite){
        return universiteService.addOrUpdateUniversite(universite);
    }

    @PutMapping("/update")
    Universite updateUniversite(@RequestBody Universite universite){
        return universiteService.addOrUpdateUniversite(universite);

    }

    @DeleteMapping("/delete/{id}")
    void deleteUniversite(@PathVariable("id") int idU){
        universiteService.deleteUniversite(idU);
    }

    @GetMapping("/get/{id}")
    Universite findUniversiteById(@PathVariable("id") int idU){
        return universiteService.findUniversiteById(idU);
    }

    @GetMapping("/get")
    List<Universite> findAllUniversite(){
        return universiteService.findAllUniversites();
    }

}
