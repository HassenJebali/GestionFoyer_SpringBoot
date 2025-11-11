package tn.esprit.gestionfoyer.services;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.gestionfoyer.entities.Chambre;
import tn.esprit.gestionfoyer.entities.Reservation;
import tn.esprit.gestionfoyer.repositories.ChambreRepository;
import tn.esprit.gestionfoyer.repositories.ReservationRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ReservationService implements IReservation {

    final ReservationRepository reservationRepository;
    final ChambreRepository chambreRepository;

    @Override
    public Reservation addOrUpdateReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public void deleteReservation(String IdReservation) {

        reservationRepository.deleteById(IdReservation);
    }

    @Override
    public List<Reservation> findAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation findReservationById(String IdReservation) {
        return reservationRepository.findById(IdReservation).get();
    }

    @Override
    public Reservation addReservationAndChambre(Reservation reservation) {
        if (reservation.getChambre() != null) {
            Chambre chambre = reservation.getChambre();
            chambre.getReservations().add(reservation);
            chambreRepository.save(chambre);
        }
        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation affectReservationToChambre(String idReservation, Long idChambre) {
        Reservation reservation = reservationRepository.findById(idReservation).get();
        Chambre chambre = chambreRepository.findById(idChambre).get();
        reservation.setChambre(chambre);
        chambre.getReservations().add(reservation);
        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation desaffectReservationToChambre(String idReservation, Long idChambre) {
        Reservation reservation = reservationRepository.findById(idReservation).get();
        reservation.setChambre(null);
        return reservationRepository.save(reservation);
    }
}
