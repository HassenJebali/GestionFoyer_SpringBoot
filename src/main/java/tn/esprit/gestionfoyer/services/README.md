# Package Services

## 📋 Description
Ce package contient la logique métier de l'application. Les services implémentent les interfaces et utilisent les repositories pour effectuer les opérations métier. Ils constituent la couche intermédiaire entre les contrôleurs et les repositories.

## 📁 Contenu

### BlocService
- **Interface** : `IBloc`
- **Responsabilités** :
  - `addOrUpdateBloc(Bloc bloc)` : Ajouter ou mettre à jour un bloc
  - `deleteBloc(long id)` : Supprimer un bloc
  - `findAllBloc()` : Récupérer tous les blocs
  - `findBlocById(long id)` : Récupérer un bloc par ID
  - `findBlocDTOById(long id)` : Récupérer un bloc au format DTO

### ChambreService
- **Interface** : `IChambre`
- Gère la logique métier des chambres

### EtudiantService
- **Interface** : `IEtudiant`
- Gère la logique métier des étudiants

### FoyerService
- **Interface** : `IFoyer`
- Gère la logique métier des foyers
- **Note** : Les méthodes de ce service sont aspectées (logging, performance monitoring)

### ReservationService
- **Interface** : `IReservation`
- Gère la logique métier des réservations

### UniversiteService
- **Interface** : `IUniversite`
- Gère la logique métier des universités

## 🏗️ Architecture en couches
```
Controller (REST)
      ↓
Service (Logique métier)
      ↓
Repository (Accès aux données)
      ↓
Entity (Base de données)
```

## 📊 Exemple de Service
```java
@Service
@AllArgsConstructor
public class BlocService implements IBloc {
    
    final BlocRepository blocRepository;
    
    @Override
    public Bloc addOrUpdateBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }
}
```

## 📚 Technologies
- **Spring** : `@Service` pour marquer les services
- **Lombok** : `@AllArgsConstructor` pour l'injection des dépendances
- **Interfaces** : Chaque service implémente une interface (IBloc, IChambre, etc.)

## 💡 Bonnes pratiques
- **Single Responsibility** : Chaque service gère une entité
- **Dépendance sur les interfaces** : Les contrôleurs dépendent des interfaces, pas des implémentations
- **Logs et monitoring** : Via les aspects AOP
- **Réutilisabilité** : Les services peuvent être testés indépendamment

## 🔄 Flux de traitement
1. Contrôleur reçoit la requête HTTP
2. Service applique la logique métier
3. Repository effectue l'opération en base de données
4. Réponse retournée au client
