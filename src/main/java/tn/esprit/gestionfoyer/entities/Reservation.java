package tn.esprit.gestionfoyer.entities;

import java.sql.Date;import jakarta.persistence.*;
import lombok.*;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Reservation {
    @Id
    String idReservation;
    Date anneeUniversitaire;
    boolean estValide;
}
