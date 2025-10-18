package tn.esprit.gestionfoyer.services;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.gestionfoyer.entities.Reservation;
import tn.esprit.gestionfoyer.repositories.ReservationRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ReservationService implements IReservation {

    final ReservationRepository reservationRepository;

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
}
