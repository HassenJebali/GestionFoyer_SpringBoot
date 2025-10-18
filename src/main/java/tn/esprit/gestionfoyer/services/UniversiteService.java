package tn.esprit.gestionfoyer.services;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.gestionfoyer.entities.Universite;
import tn.esprit.gestionfoyer.repositories.UniversiteRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class UniversiteService implements IUniversite {

    final UniversiteRepository universiteRepository;

    @Override
    public Universite addOrUpdateUniversite(Universite universite) {
        return universiteRepository.save(universite);
    }

    @Override
    public void deleteUniversite(long IdUniversite) {
        universiteRepository.deleteById(IdUniversite);

    }

    @Override
    public List<Universite> findAllUniversites() {
        return universiteRepository.findAll();
    }

    @Override
    public Universite findUniversiteById(long IdUniversite) {
        return universiteRepository.findById(IdUniversite).get();
    }
}
