# Package Mapper

## 📋 Description
Ce package contient les mappers (transformateurs) qui permettent de convertir les entités JPA en DTOs et vice-versa. Les mappers utilisent **MapStruct**, une bibliothèque pour la génération automatique de code de mapping.

## 📁 Contenu

### FoyerMapper
- **Rôle** : Transformer les entités `Foyer` en DTOs `FoyerDTO`
- **Implémentation** : Interface annoté avec `@Mapper`
- **Mappings** :
  ```java
  @Mapping(target = "name", source = "nomFoyer")
  @Mapping(target = "capacity", source = "capaciteFoyer")
  FoyerDTO foyerToDTO(Foyer foyer)
  ```
  - `nomFoyer` (Foyer) → `name` (FoyerDTO)
  - `capaciteFoyer` (Foyer) → `capacity` (FoyerDTO)

## 🔧 Fonctionnement de MapStruct

### Configuration
```java
@Mapper(componentModel = "spring")
public interface FoyerMapper {
    // Les méthodes de mapping
}
```
- `componentModel = "spring"` : Génère un bean Spring automatiquement

### Avantages de MapStruct
1. **Performances** : Génère du code au moment de la compilation (pas de réflexion)
2. **Type-safe** : Vérification des types à la compilation
3. **Traçabilité** : Facile à debugger (accès au code généré)
4. **Flexible** : Support des mappings personnalisés avec `@Mapping`

## 📊 Exemple d'utilisation

### Code
```java
Foyer foyer = new Foyer("Foyer1", 500);
FoyerDTO dto = foyerMapper.foyerToDTO(foyer);
// dto.name = "Foyer1"
// dto.capacity = 500
```

### Mapping automatique vs personnalisé
- **Automatique** : `id` → `id` (même nom)
- **Personnalisé** : `nomFoyer` → `name` (avec `@Mapping`)

## 📚 Technologies
- **MapStruct** : Framework de mapping
- **Spring** : Intégration avec le conteneur IoC

## 🎯 Stratégies de Mapping

### 1️⃣ Mapper simple
```java
FoyerDTO foyerToDTO(Foyer foyer);
```

### 2️⃣ Mapper réverse
```java
Foyer dtoToFoyer(FoyerDTO dto);
```

### 3️⃣ Mapper avec paramètres additionnels
```java
FoyerDTO foyerToDTO(Foyer foyer, @Context AdditionalParam param);
```

## 💡 Bonnes pratiques
1. **Une interface par couple d'entités** : BlocMapper, ChambreMapper, etc.
2. **Noms explicites** : `foyerToDTO()`, `dtoToFoyer()`
3. **Documenter les mappings non évidents**
4. **Valider après le mapping** si nécessaire

## 🔄 Intégration avec Services
Les mappers peuvent être injectés dans les services pour transformer les données avant de les retourner aux contrôleurs.

```java
@Service
public class BlocService {
    @Autowired
    private BlocMapper blocMapper;
    
    public BlocDTO getBlocDTO(long id) {
        Bloc bloc = blocRepository.findById(id).get();
        return blocMapper.blocToDTO(bloc);
    }
}
```
