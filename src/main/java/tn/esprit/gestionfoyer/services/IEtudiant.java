package tn.esprit.gestionfoyer.services;

import tn.esprit.gestionfoyer.entities.Etudiant;

import java.util.List;

public interface IEtudiant {

    Etudiant addOrUpdateEtudiant(Etudiant etudiant);
    void deleteEtudiant(long etudiantId);
    List<Etudiant> findAllEtudiants();
    Etudiant findEtudiantById(long etudiantId);
}
