package tn.esprit.gestionfoyer.entities;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
        @JsonIgnore
        @ToString.Exclude
    Chambre chambre;

    @ManyToMany()
        @JsonIgnore
        @ToString.Exclude
    Set<Etudiant>  etudiants = new HashSet<Etudiant>();
}
