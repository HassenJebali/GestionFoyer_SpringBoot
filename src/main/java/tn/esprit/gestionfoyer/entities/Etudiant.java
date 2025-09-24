package tn.esprit.gestionfoyer.entities;

import java.util.Date;
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
}
