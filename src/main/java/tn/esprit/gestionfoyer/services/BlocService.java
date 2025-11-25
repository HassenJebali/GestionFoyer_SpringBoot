package tn.esprit.gestionfoyer.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.gestionfoyer.DTO.BlocDTO;
import tn.esprit.gestionfoyer.entities.Bloc;
import tn.esprit.gestionfoyer.entities.Foyer;
import tn.esprit.gestionfoyer.repositories.BlocRepository;
import tn.esprit.gestionfoyer.repositories.FoyerRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class BlocService implements IBloc {

    final BlocRepository blocRepository;
    final FoyerRepository foyerRepository;

    @Override
    public Bloc addOrUpdateBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public void deleteBloc(long id) {
        blocRepository.deleteById(id);
    }

    @Override
    public List<Bloc> findAllBloc() {
        return blocRepository.findAll();
    }

    @Override
    public Bloc findBlocById(long id) {
        return blocRepository.findById(id).get();
    }

    public BlocDTO findBlocDTOById(long id) {
        Bloc bloc = blocRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bloc not found"));
        return convertToDTO(bloc);
    }
    private BlocDTO convertToDTO(Bloc bloc) {
        BlocDTO dto = new BlocDTO();
        dto.setNom(bloc.getNomBloc());
        dto.setCapacite(bloc.getCapaciteBloc());
        return dto;
    }

    @Override
    public Bloc addBlocAndFoyer(Bloc bloc) {
        if(bloc.getFoyers() != null){
            Foyer foyer = bloc.getFoyers();
            foyer.getBlocs().add(bloc);
            foyerRepository.save(foyer);
        }
    return blocRepository.save(bloc);}

    @Override
    public Bloc affectBlocToFoyer(long idBloc, long idFoyer) {
        Bloc bloc = blocRepository.findById(idBloc).get();
        Foyer foyer = foyerRepository.findById(idFoyer).get();
        bloc.setFoyers(foyer);
        foyer.getBlocs().add(bloc);
        return blocRepository.save(bloc);
    }

    @Override
    public Bloc desAffectBlocToFoyer(long idBloc) {
        Bloc bloc = blocRepository.findById(idBloc).get();
        bloc.setFoyers(null);
        return blocRepository.save(bloc);
    }

    @Override
    public Bloc desAffectBlocToFoyers(long idBloc, long idFoyer){
        Bloc bloc = blocRepository.findById(idBloc).get();
        Foyer foyer = foyerRepository.findById(idFoyer).get();
        // 1. Casser la relation En mémoire
        foyer.getBlocs().remove(bloc);
        // 2. Casser la relation En base (clé étrangère)
        bloc.setFoyers(null);
        return blocRepository.save(bloc);
    }

    public List<Bloc> getBlocsNonAffectes() {
        return blocRepository.findByfoyersIsNull();
    }

    public List<Bloc> getBlocByCapaciteBlocGreaterThan30() {
        return blocRepository.getBlocBycapaciteBlocGreaterThan(30);
    }

    public List<Bloc> findByNomBlocStartingWithAndCapaciteBlocGreaterThan(String N, long x){
        return blocRepository.findByNomBlocStartingWithAndCapaciteBlocGreaterThan(N, x);
    }

    public List<Bloc> findByNomBlocStartingWith(String N){
        return blocRepository.findByNomBlocStartingWith(N);
    }


}
