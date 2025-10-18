package tn.esprit.gestionfoyer.services;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.gestionfoyer.entities.Foyer;
import tn.esprit.gestionfoyer.repositories.FoyerRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class FoyerService implements IFoyer {

    final FoyerRepository foyerRepository;

    @Override
    public Foyer addOrUpdateFoyer(Foyer foyer) {
        return foyerRepository.save(foyer);
    }

    @Override
    public void deleteFoyer(long id) {

        foyerRepository.deleteById(id);
    }

    @Override
    public List<Foyer> findAllFoyers() {
        return foyerRepository.findAll();
    }

    @Override
    public Foyer findFoyerById(long id) {
        return foyerRepository.findById(id).get();
    }
}
