package tn.esprit.gestionfoyer.services;

import tn.esprit.gestionfoyer.entities.Chambre;

import java.util.List;

public interface IChambre {

    Chambre addOrUpdateChambre(Chambre chambre);
    void deleteChambre(long id);
    List<Chambre> findAllChambre();
    Chambre findChambreById(long id);
}
