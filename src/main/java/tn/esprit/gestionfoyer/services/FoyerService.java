package tn.esprit.gestionfoyer.services;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.gestionfoyer.DTO.FoyerDTO;
import tn.esprit.gestionfoyer.entities.Foyer;
import tn.esprit.gestionfoyer.mapper.FoyerMapper;
import tn.esprit.gestionfoyer.repositories.FoyerRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class FoyerService implements IFoyer {

    final FoyerRepository foyerRepository;
    private final FoyerMapper foyerMapper; //Injection du mapping automatique

    @Override
    public Foyer addOrUpdateFoyer(Foyer foyer) {
        return foyerRepository.save(foyer);
    }

    @Override
    public void deleteFoyer(long id) {
        foyerRepository.deleteById(id);}

    @Override
    public List<Foyer> findAllFoyers() {
        return foyerRepository.findAll();
    }

    public FoyerDTO findById(long id) {
        Foyer foyer = foyerRepository.findById(id).orElse(null);
        return foyerMapper.foyerToDTO(foyer);
    }

    public FoyerDTO addFoyerDTO(Foyer foyer) {
        return foyerMapper.foyerToDTO(foyerRepository.save(foyer));
    }

    @Override
    public Foyer findFoyerById(long id) {
        return foyerRepository.findById(id).get();
    }
}
