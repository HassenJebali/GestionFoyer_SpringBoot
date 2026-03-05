# Package Entities

## 📋 Description
Ce package contient toutes les entités JPA (Java Persistence API) qui représentent les tables de la base de données. Chaque classe entité est mappée à une table dans la base de données.

## 📁 Contenu

### Foyer.java
- **Table** : `foyer`
- **Rôle** : Représente une résidence/foyer d'étudiants
- **Champs principaux** :
  - `idFoyer` : Clé primaire
  - `nomFoyer` : Nom du foyer
  - `capaciteFoyer` : Capacité totale du foyer
  - Relation : Un foyer contient plusieurs blocs

### Bloc.java
- **Table** : `bloc`
- **Rôle** : Représente un bâtiment/bloc au sein d'un foyer
- **Champs principaux** :
  - `idBloc` : Clé primaire
  - `nomBloc` : Nom du bloc
  - `capaciteBloc` : Capacité du bloc
  - Relation : Plusieurs blocs appartiennent à un foyer

### Chambre.java
- **Table** : `chambre`
- **Rôle** : Représente une chambre dans un bloc
- **Relations** : Appartient à un bloc, contient des réservations

### Etudiant.java
- **Table** : `etudiant`
- **Rôle** : Représente un étudiant
- **Relations** : Peut faire des réservations de chambres

### Reservation.java
- **Table** : `reservation`
- **Rôle** : Représente la réservation d'une chambre par un étudiant
- **Relations** : Lie un étudiant à une chambre

### Universite.java
- **Table** : `universite`
- **Rôle** : Représente une université
- **Relations** : Une université peut avoir plusieurs foyers

### TypeChambre.java
- **Enumération** : Types de chambres disponibles
- **Rôle** : Énumère les différents types de chambres (simple, double, triple, etc.)

## 🏗️ Architecture
```
Universite (1) ──────> (N) Foyer
                           │
                           ├──> (N) Bloc
                                      │
                                      └──> (N) Chambre
                                                │
                                                └──> (N) Reservation <──── (N) Etudiant
```

## 📚 Technologies
- **JPA** : `@Entity`, `@Id`, `@GeneratedValue`
- **Lombok** : `@Getter`, `@Setter`, `@AllArgsConstructor`, `@NoArgsConstructor`
- **Relations** : `@OneToMany`, `@ManyToOne`, `@ManyToMany`

## 📝 Convention de nommage
- Clés primaires : `id{NomEntité}` (ex: `idBloc`, `idFoyer`)
- Champs : camelCase (ex: `nomBloc`, `capaciteBloc`)
