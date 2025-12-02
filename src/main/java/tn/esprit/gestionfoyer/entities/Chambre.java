package tn.esprit.gestionfoyer.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Chambre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idChambre;
    long numeroChambre;
    @Enumerated(EnumType.STRING)
    TypeChambre typeChambre;

    @ManyToOne()
        @JsonIgnore
        @ToString.Exclude
    private Bloc blocs;

    @OneToMany(mappedBy = "chambre", cascade = CascadeType.ALL)
            @JsonIgnore
            @ToString.Exclude
    Set<Reservation> reservations = new HashSet<Reservation>();


}
