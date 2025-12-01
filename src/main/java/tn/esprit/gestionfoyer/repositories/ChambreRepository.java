package tn.esprit.gestionfoyer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.gestionfoyer.entities.Chambre;
import tn.esprit.gestionfoyer.entities.TypeChambre;

import java.util.List;

@Repository
public interface ChambreRepository extends JpaRepository<Chambre, Long> {

    List<Chambre> findByTypeChambre(TypeChambre type);
    Chambre findByNumeroChambre(long numero);

    @Query("select c from Chambre c join c.reservations r " +
            "join r.etudiants e " +
            "where e.idEtudiant  =: id_e")
    Chambre findByEtudiant(@Param("id_e") long idEtudiant);

    List<Chambre> findByBlocsIdBloc(Long idBloc);

    long countByTypeChambre(TypeChambre t);





}
