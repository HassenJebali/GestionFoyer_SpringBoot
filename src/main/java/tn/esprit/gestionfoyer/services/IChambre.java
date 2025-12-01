package tn.esprit.gestionfoyer.services;

import org.springframework.data.repository.query.Param;
import tn.esprit.gestionfoyer.entities.Chambre;

import java.util.List;

public interface IChambre {

    Chambre addOrUpdateChambre(Chambre chambre);
    void deleteChambre(long id);
    List<Chambre> findAllChambre();
    Chambre findChambreById(long id);

    Chambre findByEtudiant(@Param("id_e") long idEtudiant);


}
