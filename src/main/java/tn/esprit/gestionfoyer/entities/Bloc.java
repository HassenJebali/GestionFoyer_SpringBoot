package tn.esprit.gestionfoyer.entities;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Bloc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    long idBloc;
    String nomBloc;
    long capaciteBloc;
}
