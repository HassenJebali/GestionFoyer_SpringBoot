# Package Controllers

## 📋 Description
Ce package contient tous les contrôleurs REST qui gèrent les requêtes HTTP et exposent les endpoints de l'API. Les contrôleurs font le lien entre les requêtes HTTP et la logique métier.

## 📁 Contenu

### BlocController
- **Endpoint** : `/Bloc`
- **Fonctionnalités** :
  - `POST /addBloc` : Ajouter un bloc
  - `PUT /updateBloc` : Modifier un bloc existant
  - `DELETE /deleteBloc/{id}` : Supprimer un bloc
  - `GET /getAllBloc` : Récupérer tous les blocs
  - `GET /getBloc/{id}` : Récupérer un bloc par son ID

### ChambreController
- Gère les opérations CRUD des chambres

### EtudiantController
- Gère les opérations CRUD des étudiants

### FoyerController
- Gère les opérations CRUD des foyers (résidences)

### ReservationController
- Gère les réservations des chambres par les étudiants

### UniversiteController
- Gère les opérations CRUD des universités

## 🔧 Utilisation
```java
@RestController
@RequestMapping("/path")
@AllArgsConstructor
public class XxxController {
    // Injection des services via Lombok
}
```

## 📚 Technologies
- **Spring Web** : `@RestController`, `@RequestMapping`, `@GetMapping`, etc.
- **Lombok** : `@AllArgsConstructor` pour l'injection des dépendances
- **JSON** : Format d'échange des données

## 📝 Convention
- Les requêtes utilisent des `@RequestBody` Lombook pour les paramètres
- Les réponses retournent les entités ou listes d'entités
