# Package DTO (Data Transfer Object)

## 📋 Description
Ce package contient les objets de transfert de données (DTO). Les DTOs sont utilisés pour transférer les données entre l'API et le client. Ils permettent de :
- **Découpler** l'API des entités de base de données
- **Contrôler** les données exposées (sécurité, confidentialité)
- **Optimiser** les requêtes en transférant uniquement les données nécessaires

## 📁 Contenu

### BlocDTO
- **Champs** :
  - `nom` : Nom du bloc
  - `capacite` : Capacité du bloc
- **Utilisation** : Transfer simplifié des données de bloc sans l'ID et les relations
- **Avantages** :
  - Version allégée de l'entité `Bloc`
  - Masque les détails internes

### FoyerDTO
- **Champs** :
  - `name` : Nom du foyer
  - `capacity` : Capacité du foyer
- **Utilisation** : Transfer de données de foyer
- **Mapping** : Utilise `FoyerMapper` pour la transformation
  - `nomFoyer` (entité) → `name` (DTO)
  - `capaciteFoyer` (entité) → `capacity` (DTO)

## 🔄 Architecture du transfert de données

### Entité (Modèle de BD)
```java
public class Bloc {
    long idBloc;
    String nomBloc;
    long capaciteBloc;
    Foyer foyers;
    Set<Chambre> chambre;
}
```

### DTO (Données exposées)
```java
public class BlocDTO {
    String nom;
    long capacite;
}
```

## 💡 Avantages des DTOs
1. **Sécurité** : Ne pas exposer toutes les données sensibles
2. **Performance** : Transférer uniquement les données essentielles
3. **Flexibilité** : Pouvoir modifier l'entité sans affecter l'API
4. **Validation** : Valider les données clients avant de les persister
5. **Versioning** : Gérer différentes versions de l'API

## 📝 Convention
- Les DTOs ont des noms explicites avec le suffix DTO
- Les propriétés peuvent avoir des noms différents des entités
- Pas de relations complexes (One-To-Many, Many-To-Many)

## 📚 Technologies
- **Lombok** : `@Getter`, `@Setter`, `@AllArgsConstructor`, `@NoArgsConstructor`
- **MapStruct** : Pour la transformation automatique entité ↔ DTO

## 🔀 Flux de transfert de données
```
Client HTTP
    ↓ JSON
    ↓ Désérialisation
    ↓
Controller (reçoit BlocDTO)
    ↓
Mapper (BlocDTO → Bloc)
    ↓
Service/Repository
    ↓
BD (persiste Bloc)
    ↓ Récupère Bloc
    ↓
Mapper (Bloc → BlocDTO)
    ↓ Sérialisation
    ↓ JSON
Client HTTP
```
