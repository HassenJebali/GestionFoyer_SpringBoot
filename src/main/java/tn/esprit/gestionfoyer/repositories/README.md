# Package Repositories

## 📋 Description
Ce package contient les interfaces de repository qui gèrent l'accès aux données. Chaque repository hérite de `JpaRepository` et fournit des méthodes pour effectuer des opérations CRUD et des requêtes personnalisées sur la base de données.

## 📁 Contenu

### BlocRepository
- **Entité** : `Bloc`
- **Méthodes personnalisées** :
  - `findByfoyersIsNull()` : Trouver les blocs sans foyer assigné
  - `getBlocBycapaciteBlocGreaterThan(long capaciteBloc)` : Trouver les blocs avec une capacité supérieure à X
  - `findByNomBlocStartingWith(String N)` : Chercher les blocs dont le nom commence par N
  - `findByNomBlocStartingWithAndCapaciteBlocGreaterThan(String N, long x)` : Recherche combinée sur nom et capacité

### ChambreRepository
- Gère l'accès aux données des chambres
- Requêtes personnalisées pour filtrer par type, bloc, disponibilité

### EtudiantRepository
- Gère l'accès aux données des étudiants
- Requêtes pour trouver les étudiants par université, foyer

### FoyerRepository
- Gère l'accès aux données des foyers
- Requêtes pour filtrer par université, capacité

### ReservationRepository
- Gère l'accès aux données des réservations
- Requêtes pour trouver les réservations par étudiant, chambre, période

### UniversiteRepository
- Gère l'accès aux données des universités

## 🔧 Fonctionnalités automatiques héritées de JpaRepository
```java
// Créer/Mettre à jour
save(T entity)
saveAll(Iterable<T> entities)

// Lire
findById(ID id)
findAll()

// Supprimer
deleteById(ID id)
delete(T entity)
deleteAll()

// Pagination
findAll(Pageable pageable)
```

## 📚 technologies
- **Spring Data JPA** : `JpaRepository<Entity, ID>`
- **Query Methods** : Génération automatique de requêtes à partir du nom de la méthode

## 📝 Convention de nommage des requêtes personnalisées
- `findBy{Attribut}` : Rechercher par attribut
- `findBy{Attribut}GreaterThan` : Rechercher avec condition >
- `findBy{Attribut}StartingWith` : Rechercher les chaînes commençant par
- `findBy{Attr1}And{Attr2}` : Recherche avec plusieurs conditions (AND)

## 💡 Avantages
- Pas besoin d'écrire le code SQL
- Support automatique de la pagination et du tri
- Requêtes typées et sûres
