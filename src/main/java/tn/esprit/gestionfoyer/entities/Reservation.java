package tn.esprit.gestionfoyer.entities;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;
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



    @ManyToOne()
    Chambre chambre;

    @ManyToMany()
    Set<Etudiant>  etudiants = new HashSet<Etudiant>();
}
