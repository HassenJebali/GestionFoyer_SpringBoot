package tn.esprit.gestionfoyer.entities;

import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    long idEtudiant;
    String nomEt;
    String prenomEt;
    long cin ;
    String ecole;
    Date dateNaissance;

    @ManyToMany(mappedBy = "etudiants")
        @JsonIgnore
        @ToString.Exclude
    Set<Reservation> reservations;
}
