package tn.esprit.gestionfoyer.controllers;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.gestionfoyer.entities.Bloc;
import tn.esprit.gestionfoyer.services.BlocService;

import java.util.List;

@RestController
@RequestMapping("/Bloc")
@AllArgsConstructor
public class BlocController {

    final BlocService blocService;

    @PostMapping("/addBloc")
    Bloc addBloc(@RequestBody Bloc bloc) {
        return blocService.addOrUpdateBloc(bloc);
    }

    @PutMapping("/updateBloc")
    Bloc updateBloc(@RequestBody Bloc bloc) {
        return blocService.addOrUpdateBloc(bloc);
    }

    @DeleteMapping("/deleteBloc/{id}")
    void deleteBloc(@PathVariable("id") int idBloc) {
        blocService.deleteBloc(idBloc);
    }

    @GetMapping("/getAllBloc")
    List<Bloc> getAllBloc() {
        return blocService.findAllBloc();
    }

    @GetMapping("getBloc/{id}")
    Bloc getBloc(@PathVariable("id") int idBloc) {
        return blocService.findBlocById(idBloc);
    }
}
