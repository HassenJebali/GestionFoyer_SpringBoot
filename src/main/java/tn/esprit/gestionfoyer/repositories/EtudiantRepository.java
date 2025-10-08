package tn.esprit.gestionfoyer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.gestionfoyer.entities.Etudiant;

@Repository
public interface EtudiantRepository  extends JpaRepository<Etudiant, Long> {
}
