package tn.esprit.gestionfoyer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.gestionfoyer.entities.Bloc;

@Repository
public interface BlocRepository extends JpaRepository<Bloc, Long> {
}
