package tn.esprit.gestionfoyer.services;

import tn.esprit.gestionfoyer.entities.Bloc;

import java.util.List;

public interface IBloc {
    Bloc addOrUpdateBloc(Bloc bloc);
    void deleteBloc(long id);
    List<Bloc> findAllBloc();
    Bloc findBlocById(long id);
    Bloc addBlocAndFoyer(Bloc bloc);
    Bloc affectBlocToFoyer(long idBloc, long idFoyer);
    Bloc desAffectBlocToFoyer(long idBloc);
    public Bloc desAffectBlocToFoyers(long idBloc, long idFoyer);


}
