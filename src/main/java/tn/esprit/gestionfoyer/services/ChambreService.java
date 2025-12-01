package tn.esprit.gestionfoyer.services;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.gestionfoyer.entities.Bloc;
import tn.esprit.gestionfoyer.entities.Chambre;
import tn.esprit.gestionfoyer.entities.Reservation;
import tn.esprit.gestionfoyer.entities.TypeChambre;
import tn.esprit.gestionfoyer.repositories.BlocRepository;
import tn.esprit.gestionfoyer.repositories.ChambreRepository;
import tn.esprit.gestionfoyer.repositories.ReservationRepository;

import java.time.Year;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class ChambreService implements IChambre {

    final ChambreRepository chambreRepository;
    final BlocRepository blocRepository;
    final ReservationRepository reservationRepository;

    @Override
    public Chambre addOrUpdateChambre(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    @Override
    public void deleteChambre(long id) {
        chambreRepository.deleteById(id);
    }

    @Override
    public List<Chambre> findAllChambre() {
        return chambreRepository.findAll();
    }

    @Override
    public Chambre findChambreById(long id) {
        return chambreRepository.findById(id).get();
    }

    @Override
    public Chambre findByEtudiant(long idEtudiant) {
        return chambreRepository.findByEtudiant(idEtudiant);
    }

    public List<Chambre> getChambresByType(TypeChambre type) {
        return chambreRepository.findByTypeChambre(type);
    }

    public Chambre getChambreByNumero(long numero) {
        return chambreRepository.findByNumeroChambre(numero);
    }


    @Override
    public List<Chambre> findChambreParBlocs(Long idBloc) {
        List<Chambre> c = chambreRepository.findByBlocsIdBloc(idBloc);

        Bloc bloc = blocRepository.findById(idBloc).get();
        log.info("----------------------------------------------");
        if (c.isEmpty()) {
            log.info("Bloc " + idBloc + " complet");
        }else {
            log.info("Bloc => " + idBloc);
            log.info("La liste des chambre pour ce bloc :");
            c.forEach(ch ->
                    log.info("Chambre numéro {} | Type : {}",
                            ch.getNumeroChambre(),
                            ch.getTypeChambre()));
            log.info("----------------------------------------------");
        }
        return c ;
    }

    @Scheduled(fixedRate = 300000)
    @Override
    public void pourcentageChambreParTypeChambre(){
        long p = chambreRepository.count();
        log.info("----------------------------------------------");
        log.info("Nombre Totale des chambres : {} ",p);
         for(TypeChambre t : TypeChambre.values()){
             long c = chambreRepository.countByTypeChambre(t);
             double pourcentage = (c * 100.0)/p ;
             log.info("Le pourcentage des typs des chambres  {} est égale a {} ", t, pourcentage );
             log.info("----------------------------------------------");
         }
    }

    @Scheduled(fixedRate = 300000)
    @Override
    public void nbPlacesDispoParChambreEnAnneeEnCours(){
        int a = Year.now().getValue();

        List<Chambre> c = chambreRepository.findAll();
        List<Reservation> res = reservationRepository.findAll();

        for(Chambre ch : c){

            boolean re = res.stream()
                    .anyMatch((r -> r.getChambre() != null
                            && r.getChambre().getIdChambre() == ch.getIdChambre()
                            && r.isEstValide()));

            log.info("La Chambre {}  a l'id {} est  reserver : {} ",
                    ch.getTypeChambre(), ch.getIdChambre(), re);
            log.info("----------------------------------------------");

     }
    }





}
