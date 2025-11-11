package tn.esprit.gestionfoyer.controllers;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.gestionfoyer.DTO.FoyerDTO;
import tn.esprit.gestionfoyer.entities.Foyer;
import tn.esprit.gestionfoyer.services.IFoyer;

import java.util.List;

@RestController
@RequestMapping("/Foyer")
@AllArgsConstructor
public class FoyerController {

    final IFoyer foyerService;

    @PostMapping("/add")
    Foyer addFoyer(@RequestBody Foyer foyer) {
        return foyerService.addOrUpdateFoyer(foyer);
    }

    @PutMapping("/update")
    Foyer updateFoyer(@RequestBody Foyer foyer) {
        return foyerService.addOrUpdateFoyer(foyer);
    }

    @DeleteMapping("/delete/{idFoyer}")
    void deleteFoyer(@PathVariable("idFoyer") int id) {
        foyerService.deleteFoyer(id);
    }

    @GetMapping("/GetAll")
    List<Foyer> getAllFoyers() {
        return foyerService.findAllFoyers();
    }

    @GetMapping("/get/{id}")
    Foyer getFoyer(@PathVariable("id") int id) {
        return foyerService.findFoyerById(id);
    }

    @GetMapping("{id}")
    public FoyerDTO findById(@PathVariable("id") long id) {
        return foyerService.findById(id);
    }

    @PostMapping("addDTO")
    FoyerDTO addFoyerDTO(@RequestBody Foyer foyer) {
        return foyerService.addFoyerDTO(foyer);
    }
}
