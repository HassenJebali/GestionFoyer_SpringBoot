package tn.esprit.gestionfoyer.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.gestionfoyer.entities.Bloc;
import tn.esprit.gestionfoyer.repositories.BlocRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class BlocService implements IBloc {

    final BlocRepository blocRepository;

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
}
