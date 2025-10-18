package tn.esprit.gestionfoyer.services;

import tn.esprit.gestionfoyer.entities.Reservation;

import java.util.List;

public interface IReservation {

    Reservation addOrUpdateReservation(Reservation reservation);
    void deleteReservation(String IdReservation);
    List<Reservation> findAllReservations();
    Reservation findReservationById(String IdReservation);

}
