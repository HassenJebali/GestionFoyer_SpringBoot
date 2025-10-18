package tn.esprit.gestionfoyer.services;

import tn.esprit.gestionfoyer.entities.Universite;

import java.util.List;

public interface IUniversite {

    Universite addOrUpdateUniversite(Universite universite);
    void deleteUniversite(long IdUniversite);
    List<Universite> findAllUniversites();
    Universite findUniversiteById(long IdUniversite);
}
