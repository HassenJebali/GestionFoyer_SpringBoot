package tn.esprit.gestionfoyer.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.gestionfoyer.entities.Reservation;
import tn.esprit.gestionfoyer.services.ReservationService;

import java.util.List;

@RestController
@RequestMapping("/reservation")
@AllArgsConstructor
public class ReservationController {

    final ReservationService reservationService;

    @PostMapping("/Add")
    Reservation addReservation(@RequestBody Reservation reservation) {
        return reservationService.addOrUpdateReservation(reservation);
    }

    @PutMapping("/update")
    Reservation updateReservation(@RequestBody Reservation reservation) {
        return reservationService.addOrUpdateReservation(reservation);
    }

    @DeleteMapping("/delete/{id}")
    void deleteReservation(@PathVariable("id") String idR) {
        reservationService.deleteReservation(idR);
    }

    @GetMapping("/get")
    List<Reservation> getReservations() {
        return reservationService.findAllReservations();
    }

    @GetMapping("/get/{id}")
    Reservation getReservation(@PathVariable("id") String idR) {
        return reservationService.findReservationById(idR);
    }
}
