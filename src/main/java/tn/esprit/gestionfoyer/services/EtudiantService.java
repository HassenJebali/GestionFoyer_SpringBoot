package tn.esprit.gestionfoyer.services;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.gestionfoyer.entities.Etudiant;
import tn.esprit.gestionfoyer.repositories.EtudiantRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class EtudiantService implements IEtudiant {

    final EtudiantRepository etudiantRepository;

    @Override
    public Etudiant addOrUpdateEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    @Override
    public void deleteEtudiant(long etudiantId) {

        etudiantRepository.deleteById(etudiantId);
    }

    @Override
    public List<Etudiant> findAllEtudiants() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant findEtudiantById(long etudiantId) {
        return etudiantRepository.findById(etudiantId).get();
    }
}
