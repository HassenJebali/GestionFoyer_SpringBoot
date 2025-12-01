package tn.esprit.gestionfoyer.controllers;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.gestionfoyer.entities.Chambre;
import tn.esprit.gestionfoyer.entities.TypeChambre;
import tn.esprit.gestionfoyer.services.ChambreService;

import java.util.List;

@RestController
@RequestMapping("/Chambre")
@AllArgsConstructor
public class ChambreController {

    final ChambreService chambreService;

    @PostMapping("/addChambre")
    Chambre addChambre(@RequestBody Chambre chambre) {
        return chambreService.addOrUpdateChambre(chambre);
    }

    @PutMapping("/updateChambre")
    Chambre updateChambre(@RequestBody Chambre chambre) {
        return chambreService.addOrUpdateChambre(chambre);
    }

    @DeleteMapping("/deleteChambre/{id}")
    void deleteChambre(@PathVariable int id) {
        chambreService.deleteChambre(id);
    }

    @GetMapping("/GetAllChambre")
    List<Chambre> getAllChambre() {
        return chambreService.findAllChambre();  }

    @GetMapping("/GetChambre/{id}")
    Chambre getChambre(@PathVariable int id) {
        return chambreService.findChambreById(id);
    }

    @GetMapping("/type/{type}")
    public List<Chambre> getByType(@PathVariable TypeChambre type) {
        return chambreService.getChambresByType(type);
    }

    @GetMapping("/numero/{num}")
    public Chambre getByNumero(@PathVariable long num) {
        return chambreService.getChambreByNumero(num);
    }

    @GetMapping("/QS/{idEtudiant}")
    public Chambre findByEtudiant(@PathVariable long idEtudiant){
        return chambreService.findByEtudiant(idEtudiant);
    }

}
