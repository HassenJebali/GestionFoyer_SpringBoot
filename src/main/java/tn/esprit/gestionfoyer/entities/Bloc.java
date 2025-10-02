package tn.esprit.gestionfoyer.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

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

    @ManyToOne()
    private Foyer foyers;

    @OneToMany(mappedBy = "blocs")
    Set<Chambre> chambre;


}
