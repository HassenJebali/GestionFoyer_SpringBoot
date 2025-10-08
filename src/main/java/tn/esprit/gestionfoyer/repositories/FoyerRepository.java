package tn.esprit.gestionfoyer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.gestionfoyer.entities.Foyer;

@Repository
public interface FoyerRepository extends JpaRepository<Foyer, Long> {
}
