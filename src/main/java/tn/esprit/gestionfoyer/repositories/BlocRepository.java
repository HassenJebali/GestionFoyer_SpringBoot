package tn.esprit.gestionfoyer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.gestionfoyer.entities.Bloc;

import java.util.List;



@Repository
public interface BlocRepository extends JpaRepository<Bloc, Long> {
    List<Bloc> findByfoyersIsNull();
    List<Bloc> getBlocBycapaciteBlocGreaterThan(long capaciteBloc ) ;
    List<Bloc> findByNomBlocStartingWith(String N);
    List<Bloc> findByNomBlocStartingWithAndCapaciteBlocGreaterThan(String N, long x);
}
