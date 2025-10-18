package tn.esprit.gestionfoyer.controllers;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.gestionfoyer.entities.Etudiant;
import tn.esprit.gestionfoyer.services.EtudiantService;

import java.util.List;

@RestController
@RequestMapping("/Etudiant")
@AllArgsConstructor
public class EtudiantController {

    final EtudiantService etudiantService;

    @PostMapping("/Add")
    Etudiant addEtudiant(@RequestBody Etudiant et) {
        return etudiantService.addOrUpdateEtudiant(et);
    }

    @PutMapping("/update")
    Etudiant updateEtudiant(@RequestBody Etudiant et) {
        return etudiantService.addOrUpdateEtudiant(et);
    }

    @DeleteMapping("delete/{idEtudiant}")
    void deleteEtudiant(@PathVariable("idEtudiant") int id) {
        etudiantService.deleteEtudiant(id);
    }

    @GetMapping("/GetAll")
    List<Etudiant> getAllEtudiant() {
        return etudiantService.findAllEtudiants();
    }

    @GetMapping("/get/{idEtudiant}")
    Etudiant getEtudiant(@PathVariable("idEtudiant") int id) {
        return etudiantService.findEtudiantById(id);
    }
}
