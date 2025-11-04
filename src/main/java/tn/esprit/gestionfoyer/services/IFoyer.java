package tn.esprit.gestionfoyer.services;

import tn.esprit.gestionfoyer.DTO.FoyerDTO;
import tn.esprit.gestionfoyer.entities.Foyer;

import java.util.List;

public interface IFoyer {

    Foyer addOrUpdateFoyer(Foyer foyer);

    void deleteFoyer(long id);

    List<Foyer> findAllFoyers();

    Foyer findFoyerById(long id);

    FoyerDTO findById(long id);

}