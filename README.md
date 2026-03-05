# 📚 GestionFoyer - Projet Académique Spring Boot

![Java](https://img.shields.io/badge/Java-17-orange?logo=java)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.5-green?logo=spring)
![Maven](https://img.shields.io/badge/Maven-3.8-blue?logo=maven)
![MySQL](https://img.shields.io/badge/MySQL-Database-blue?logo=mysql)

## 📋 Table des matières
- [À propos du projet](#-à-propos-du-projet)
- [Auteur](#-auteur)
- [Compétences acquises](#-compétences-acquises)
- [Architecture et design](#-architecture-et-design)
- [Diagramme UML](#-diagramme-uml)
- [Technologies utilisées](#-technologies-utilisées)
- [Structures des données](#-structures-des-données)
- [Guide d'utilisation](#-guide-dutilisation)
- [Tests API](#-tests-api)
- [Fonctionnalités avancées](#-fonctionnalités-avancées)
- [Améliorations futures](#-améliorations-futures)
- [Troubleshooting](#-troubleshooting)
- [FAQ](#-faq)
- [Glossaire](#-glossaire)
- [Licence](#-licence)
- [Support](#-support)

---

## 🎯 À propos du projet

**GestionFoyer** est une application de gestion de foyer universitaire développée pendant un parcours académique complet en **Spring Boot** à **Esprit**.
Cette application permet de gérer :
- Les foyers et leurs blocs
- Les chambres avec leurs types
- Les étudiants et leurs réservations
- Les universités

Le projet couvre toutes les couches d'une application REST moderne : entités JPA, services métier, contrôleurs REST, DTO, et aspects de programmation (AOP).

---

## 🏆 Compétences acquises

### 1. **Installation et Configuration IDE**
- ✅ Configuration de l'environnement Java 17
- ✅ Installation et configuration d'IntelliJ IDEA
- ✅ Gestion des variables d'environnement

### 2. **Spring Boot & Maven**
- ✅ Création d'un projet Spring Boot 3.5.5
- ✅ Gestion des dépendances avec Maven
- ✅ Configuration du pom.xml avec dépendances essentielles
- ✅ Build et packaging JAR
- ✅ Configuration des plugins Maven (compiler, spring-boot-maven-plugin)

### 3. **Entités JPA & Lombok**
- ✅ Création d'entités avec annotations JPA (`@Entity`, `@Table`, `@Id`, `@GeneratedValue`)
- ✅ Utilisation de Lombok pour réduire le boilerplate
- ✅ Annotations Lombok : `@Getter`, `@Setter`, `@AllArgsConstructor`, `@NoArgsConstructor`, `@ToString`, `@Slf4j`
- ✅ Gestion des constructeurs automatiques
- ✅ Propriétés persistantes et gestion du cycle de vie

### 4. **Associations JPA**
- ✅ Relation **One-to-One** (Foyer ↔ Universite)
- ✅ Relation **One-to-Many** (Foyer → Bloc, Bloc → Chambre)
- ✅ Relation **Many-to-Many** (Etudiant ↔ Reservation ↔ Chambre)
- ✅ Gestion de la cardinalité et des cascades
- ✅ Exclusion des champs circulaires avec `@JsonIgnore` et `@ToString.Exclude`
- ✅ Utilisation de `HashSet` pour les collections bidirectionnelles

### 5. **Services et Injection de dépendances**
- ✅ Pattern Service-Repository (couche métier)
- ✅ Interfaces de service (`IFoyer`, `IChambre`, `IEtudiant`, etc.)
- ✅ Implémentation des services avec logique métier
- ✅ Injection de dépendances avec `@Autowired` et constructeurs
- ✅ Annotation `@AllArgsConstructor` pour injecter les dépendances

### 6. **Contrôleurs REST (API REST)**
- ✅ Création d'endpoints RESTful avec `@RestController`
- ✅ Mapping des requêtes HTTP (`@PostMapping`, `@GetMapping`, `@PutMapping`, `@DeleteMapping`)
- ✅ Gestion des chemins avec `@RequestMapping`
- ✅ Paramètres de chemin avec `@PathVariable`
- ✅ Réception de requêtes JSON avec `@RequestBody`
- ✅ Retour de réponses en JSON

### 7. **DTO (Data Transfer Objects)**
- ✅ Création de DTOs pour l'abstraction et la sécurité
- ✅ Utilisation de MapStruct pour le mapping automatique
- ✅ Séparation entre modèles internes et API externes
- ✅ Configuration des mappers avec `@Mapper`

### 8. **Dérivations et Keywords JPA**
- ✅ Création de méthodes de requête avec noms explicites
- ✅ Keywords JPA : `findBy`, `findAllBy`, `deleteBy`
- ✅ Requêtes avec paramètres optionnels
- ✅ Repositories héritant de `JpaRepository<Entity, ID>`

### 9. **JPA QL & Requêtes personnalisées**
- ✅ Annotations `@Query` pour requêtes JPQL
- ✅ Requêtes natives SQL avec `@Query(nativeQuery=true)`
- ✅ Paramètres liés avec `@Param`
- ✅ Projections et agrégations

### 10. **Scheduler**
- ✅ Annotation `@EnableScheduling` pour activer le scheduling
- ✅ Méthodes planifiées avec `@Scheduled`
- ✅ Exécution de tâches périodiques
- ✅ Gestion des délais et intervalles

### 11. **AOP (Aspect-Oriented Programming)**
- ✅ Création d'aspects avec `@Aspect`
- ✅ Annotations de pointcut : `@Before`, `@After`, `@Around`
- ✅ Logging automatique des méthodes de service
- ✅ Interception de la logique métier
- ✅ Utilisation de `JoinPoint` pour accéder aux informations d'exécution
- ✅ Configuration avec `@EnableAspectJAutoProxy`

### 12. **Documentation API**
- ✅ Intégration de Swagger/API REST
- ✅ Documentation automatique des endpoints
- ✅ Interface web interactive

---

## 🏗️ Architecture et Design

### Architecture en couches

```
┌─────────────────────────────────────────┐
│          API REST / Contrôleurs         │
│     (REST Endpoints + JSON Mapping)     │
└──────────────────┬──────────────────────┘
                   │
┌──────────────────▼──────────────────────┐
│            DTO (MapStruct)              │
│     (Data Transfer Objects)             │
└──────────────────┬──────────────────────┘
                   │
┌──────────────────▼──────────────────────┐
│       Services (Couche Métier)          │
│   (Logique métier + AOP Logging)        │
└──────────────────┬──────────────────────┘
                   │
┌──────────────────▼──────────────────────┐
│       Repositories (JPA)                │
│     (Accès aux données)                 │
└──────────────────┬──────────────────────┘
                   │
┌──────────────────▼──────────────────────┐
│     Entités JPA + Associations          │
│      (Modèle de données)                │
└──────────────────┬──────────────────────┘
                   │
┌──────────────────▼──────────────────────┐
│        Base de données MySQL            │
│      (Persistance des données)          │
└─────────────────────────────────────────┘
```

### Patterns de conception utilisés

| Pattern | Utilisation | Classe Exemple |
|---------|-------------|-----------------|
| **Service Pattern** | Isoler la logique métier | `FoyerService.java` |
| **Repository Pattern** | Abstraction d'accès aux données | `FoyerRepository.java` |
| **DTO Pattern** | Transfert de données sécurisé | `FoyerDTO.java` |
| **Mapper Pattern** | Conversion Entity ↔ DTO | `FoyerMapper.java` |
| **AOP Pattern** | Cross-cutting concerns | `LoggingAspect.java` |
| **Singleton** | Instance unique des services | Spring Beans |
| **Dependency Injection** | Inversion de contrôle | `@AllArgsConstructor` |

---

## 📊 Diagramme UML

### Relations et cardinalité

```
                              ┌─────────────────┐
                              │  Universite     │
                              ├─────────────────┤
                              │ - idUniversite  │
                              │ - nomUniversite │
                              │ - adresse       │
                              └────────┬────────┘
                                       │ 1
                                       │ OneToOne
                                       │
                    ┌──────────────────┴──────────────────┐
                    │                                     │
                    │ 1                                   │
        ┌───────────▼──────────┐                 ┌───────▼─────────────┐
        │     Foyer            │                 │   Bloc              │
        ├──────────────────────┤                 ├─────────────────────┤
        │ - idFoyer            │                 │ - idBloc            │
        │ - nomFoyer           │ 1 ───────┬──── │ - nomBloc           │
        │ - capaciteFoyer      │  OneToMany     │ - capaciteBloc      │
        └──────────────────────┘          │     └────────┬────────────┘
              ▲                           │              │ 1
              │ OneToOne                  │              │ OneToMany
              │ mappedBy                  │              │
              │                           │     ┌────────▼────────────┐
              └───────────────────────────┘     │   Chambre           │
                                                ├─────────────────────┤
                                                │ - idChambre         │
                                                │ - numeroChambre     │
                                    ┌───────────┤ - typeC: TypeChambre │
                                    │ OneToMany └────────┬────────────┘
                                    │                    │ 1
                                    │        ┌───────────┴──────────┐
                         ┌──────────▼────────┴────┐                │
                         │   <<Enum>>             │                │
                         │  TypeChambre           │                │
                         ├────────────────────────┤                │
                         │ SIMPLE                 │                │
                         │ DOUBLE                 │                │
                         │ TRIPLE                 │                │
                         └────────────────────────┘       ┌────────▼──────────┐
                                                         │  Reservation       │
                                                         ├───────────────────┤
                                                         │ - idReservation    │
                                                         │ - anneeUniversite  │
                                                         │ - estValide        │
                                                         └────────┬───────────┘
                                                                  │ *
                                           ManyToMany ┌──────────┴──────────┐
                                                      │                     │
                                                  ┌───▼──────────────────┐
                                                  │   Etudiant           │
                                                  ├──────────────────────┤
                                                  │ - idEtudiant         │
                                                  │ - nomEt              │
                                                  │ - prenomEt           │
                                                  │ - cin                │
                                                  │ - ecole              │
                                                  │ - dateNaissance      │
                                                  └──────────────────────┘
```

---

## 🛠️ Technologies utilisées

### Backend
| Technologie | Version | Utilisation |
|-------------|---------|-------------|
| **Java** | 17 | Langage de programmation |
| **Spring Boot** | 3.5.5 | Framework applicatif |
| **Spring Data JPA** | Latest | ORM et persistance |
| **Hibernate** | Latest | Implémentation JPA |
| **Lombok** | 1.18.34 | Réduction du boilerplate |
| **MapStruct** | 1.5.5 | Mapping automatique DTO |
| **SpringDoc OpenAPI** | 2.1.0 | Documentation Swagger |
| **MySQL** | 8.0+ | Base de données |
| **Maven** | 3.8+ | Gestion des dépendances |

### Tools & IDE
| Outil | Utilisation |
|-------|------------|
| **IntelliJ IDEA** | IDE de développement |
| **Postman** | Test des API REST |
| **Swagger UI** | Documentation interactive |
| **MySQL Workbench** | Gestion de la base |
| **Git** | Versionning |

---

## 💾 Structures des données

📁 **Check package `entities`** pour tous les détails d'implémentation

### Entités principales

| Entité | Propriétés clés | Relations |
|--------|-----------------|----------|
| **Foyer** | idFoyer, nomFoyer, capaciteFoyer | OneToOne avec Universite, OneToMany avec Bloc |
| **Bloc** | idBloc, nomBloc, capaciteBloc | ManyToOne avec Foyer, OneToMany avec Chambre |
| **Chambre** | idChambre, numeroChambre, typeC (Enum) | ManyToOne avec Bloc, OneToMany avec Reservation |
| **Etudiant** | idEtudiant, nomEt, prenomEt, cin, ecole, dateNaissance | ManyToMany avec Reservation |
| **Reservation** | idReservation, anneeUniversitaire, estValide | ManyToOne avec Chambre, ManyToMany avec Etudiant |
| **Universite** | idUniversite, nomUniversite, adresse | OneToOne avec Foyer |
| **TypeChambre** | SIMPLE, DOUBLE, TRIPLE | Enum pour les types de chambres |

---

## 🚀 Guide d'utilisation

### Prérequis
- ✅ **Java 17+** installé
- ✅ **MySQL 8.0+** en cours d'exécution (via XAMPP)
- ✅ **Maven 3.8+** installé
- ✅ **XAMPP** (pour MySQL et phpmyadmin)
- ✅ **Postman** (optionnel - pour tester les API)
- ✅ **IntelliJ IDEA** (optionnel mais recommandé)

### Configuration

#### Configuration application.properties
```properties
spring.datasource.url=jdbc:mysql://localhost:3307/foyerDb
spring.datasource.username=root
spring.datasource.password=

server.port=8088
server.servlet.context-path=/foyer
```

⚠️ **Ports MySQL importants**:
- **3307** = Port XAMPP (par défaut dans ce projet)
- **3306** = Port MySQL standard (si vous n'utilisez pas XAMPP)

Si vous utilisez MySQL standard, changez:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/foyerDb
```

**Note**: La base de données est créée automatiquement par Hibernate (spring.jpa.hibernate.ddl-auto=update). Assurez-vous que **XAMPP** est en cours d'exécution avec MySQL activé.

### Lancement de l'application

#### Avec Maven sur VSCode
```bash
cd GestionFoyer
mvn clean install
mvn spring-boot:run
```

#### Avec IntelliJ IDEA
1. Clic droit sur `GestionFoyerApplication.java`
2. Run 'GestionFoyerApplication.main()'

L'application démarre sur : `http://localhost:8088/foyer`

---

## 🧪 Tests API

### 📌 **C'est quoi les endpoints?**

Un **endpoint** est une URL + une méthode HTTP qui permet de communiquer avec l'application. C'est comme une porte d'entrée:

| Méthode | Signification | Exemple |
|---------|---------------|----------|
| **POST** | Créer une nouvelle ressource | Ajouter un foyer |
| **GET** | Récupérer une ressource | Lister tous les foyers |
| **PUT** | Modifier une ressource existante | Mettre à jour un foyer |
| **DELETE** | Supprimer une ressource | Supprimer un foyer |

**URL d'endpoint**: `http://localhost:8088/foyer/Foyer/add`
- `http://localhost:8088` → Adresse du serveur
- `/foyer` → Context path (chemin racine de l'app)
- `/Foyer/add` → Endpoint défini dans `FoyerController.java`

---

### Swagger UI (Documentation interactive)

**URL** : `http://localhost:8088/foyer/swagger-ui/index.html`

#### Fonctionnalités
✅ Documentation automatique de tous les endpoints  
✅ Test direct des API dans l'interface  
✅ Visualisation des modèles de données  
✅ Exemples de requêtes et réponses  

---

### Tests avec Postman

#### Configuration Postman
1. **Ouvrir Postman**
2. **Créer une nouvelle requête**
3. **Choisir la méthode HTTP** (POST, GET, PUT, DELETE)
4. **Entrer l'URL complète**
5. **Ajouter le JSON body** (si c'est POST ou PUT)
6. **Cliquer "Send"** et voir la réponse

---

#### 📦 **Endpoints Foyer** (4 opérations CRUD)

##### ✅ 1️⃣ Ajouter un Foyer (CREATE)
```http
Méthode: POST
URL: http://localhost:8088/foyer/Foyer/add
Body (JSON):
{
  "nomFoyer": "Foyer El Kods",
  "capaciteFoyer": 500
}

Réponse (200 OK):
{
  "idFoyer": 1,
  "nomFoyer": "Foyer El Kods",
  "capaciteFoyer": 500
}
```
**Explication**: Crée un nouveau foyer et retourne ses données avec l'ID généré.

##### ✅ 2️⃣ Récupérer tous les foyers (READ)
```http
Méthode: GET
URL: http://localhost:8088/foyer/Foyer/getAll

Réponse (200 OK):
[
  {
    "idFoyer": 1,
    "nomFoyer": "Foyer El Kods",
    "capaciteFoyer": 500
  },
  {
    "idFoyer": 2,
    "nomFoyer": "Foyer Ennasr",
    "capaciteFoyer": 300
  }
]
```
**Explication**: Retourne la liste de tous les foyers existants.

##### ✅ 3️⃣ Mettre à jour un foyer (UPDATE)
```http
Méthode: PUT
URL: http://localhost:8088/foyer/Foyer/update
Body (JSON):
{
  "idFoyer": 1,
  "nomFoyer": "Foyer El Kods Updated",
  "capaciteFoyer": 600
}

Réponse (200 OK):
{
  "idFoyer": 1,
  "nomFoyer": "Foyer El Kods Updated",
  "capaciteFoyer": 600
}
```
**Explication**: Modifie les données d'un foyer existant (besoin d'un ID valide).

##### ✅ 4️⃣ Supprimer un foyer (DELETE)
```http
Méthode: DELETE
URL: http://localhost:8088/foyer/Foyer/delete/1

Réponse (200 OK):
"Foyer supprimé avec succès"
```
**Explication**: Supprime le foyer avec l'ID 1. Remplacer "1" par l'ID réel.

---

### 💡 **Astuce**: Importer automatiquement dans Postman
1. Lancez l'app
2. Allez sur: `http://localhost:8088/foyer/v3/api-docs`
3. Copiez tout le contenu JSON
4. Dans Postman: Import → Raw text → Coller
5. Tous les endpoints s'importent automatiquement!

### Codes de réponse HTTP

| Code | Signification |
|------|---------------|
| **200** | OK - Requête réussie |
| **201** | Created - Ressource créée |
| **400** | Bad Request - Erreur dans la requête |
| **404** | Not Found - Ressource non trouvée |
| **500** | Server Error - Erreur serveur |

---

## 🔍 Fonctionnalités avancées

### AOP - Logging automatique
L'aspect `LoggingAspect` enregistre automatiquement les appels de méthode :
```log
INFO  - In methode addOrUpdateFoyer:
INFO  - In methode getAllFoyer:
```

### Scheduler
Les tâches planifiées peuvent être ajoutées pour :
- Notification automatique
- Nettoyage de données
- Rapports périodiques

### Requêtes JPQL personnalisées
Exemples de requêtes avancées dans les repositories :
```java
@Query("SELECT c FROM Chambre c WHERE c.typeC = ?1")
List<Chambre> findByTypeC(TypeChambre typeC);

@Query(value = "SELECT * FROM chambre WHERE idBloc = :idBloc", nativeQuery = true)
List<Chambre> findChambresByBlocId(@Param("idBloc") Long idBloc);
```

### Exception Handling
Gestion centralisée des erreurs :
- Validation avec `@Valid` et `@NotNull`
- Messages d'erreur personnalisés
- Codes HTTP appropriés (400, 404, 500)

---
## 📈 Améliorations futures

### Backend
- [ ] Authentification et autorisation (Spring Security)
- [ ] Tests unitaires (JUnit 5, Mockito)
- [ ] Déploiement Docker
- [ ] CI/CD Pipeline

### Frontend
- [ ] Interface web avec **Angular**

---

## 👨‍💼 Auteur

**Jebali Hassen**

Projet académique réalisé dans le cadre de la formation `ASI II - Spring Data JPA - Associations`

**Module**: Spring Boot & JPA  
**Année**: 2023-2024  
**Établissement**: Esprit  

📧 **Contactez-moi**:
- Email Personnel: hdjebali92@gmail.com
- Email Professionnel: hassen.jebali@esprit.tn

🔗 **LinkedIn**: [Hassen Jebali](https://www.linkedin.com/in/hassen-jebali-60135b227/)  

---

## � Troubleshooting

### ❌ Problème: "Address already in use :8088"

**Cause**: Le port 8088 est déjà utilisé par une autre application.

**Solution 1**: Changer le port dans `application.properties`
```properties
server.port=8089
```
Puis accédez à: `http://localhost:8089/foyer`

**Solution 2**: Tuer le processus qui utilise le port (PowerShell)
```powershell
# Trouver le processus
netstat -ano | findstr :8088

# Tuer le processus (remplacer PID par le numéro)
taskkill /PID <PID> /F
```

---

### ❌ Problème: "Connection refused - MySQL"

**Cause**: MySQL n'est pas en cours d'exécution ou le port est incorrect.

**Solution**:
1. **Vérifier que XAMPP est démarré**
   - Ouvrir XAMPP Control Panel
   - Cliquer sur "Start" à côté de MySQL
   - Attendre que le statut passe à "Running"

2. **Vérifier la connexion MySQL**
   ```bash
   mysql -h localhost -P 3307 -u root
   ```
   Si OK, vous verrez: `mysql>`

3. **Vérifier application.properties**
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3307/foyerDb
   spring.datasource.username=root
   spring.datasource.password=
   ```

---

### ❌ Problème: "Hibernate cant create table" ou "Column not found"

**Cause**: La base de données n'existe pas ou les schémas sont incompatibles.

**Solution**:
```sql
-- Supprimer et recréer (attention: perd les données!)
DROP DATABASE IF EXISTS foyerDb;
CREATE DATABASE foyerDb;
```
Puis redémarrer l'application.

---

### ❌ Problème: "Swagger ne se charge pas"

**Cause**: URL incorrecte, app pas encore démarrée, ou timeout.

**Solution**:
1. **Vérifier l'URL exacte**:
   ```
   http://localhost:8088/foyer/swagger-ui/index.html
   ```
   *(pas /swagger-ui.html, ni /swagger-ui/ - il faut le /index.html)*

2. **Attendre 10 secondes** après le démarrage de l'app

3. **Vérifier les logs** dans IntelliJ (onglet "Run")
   - Chercher: `Started GestionFoyerApplication`
   - Si erreur: copier le message d'erreur et rechercher sur Google

4. **Rafraîchir le navigateur** (F5 ou Ctrl+R)

---

### ❌ Problème: "404 Not Found" sur un endpoint

**Cause**: L'endpoint n'existe pas, ou le chemin/paramètre est incorrect.

**Solution**:
1. Vérifier l'URL dans Swagger UI (source de vérité)
2. Vérifier les paramètres: `{idFoyer}` doit être remplacé par un numéro réel
3. Vérifier la méthode HTTP (POST vs GET, etc.)
   ```
   ❌ POST /foyer/Foyer/getAll (mauvaise méthode)
   ✅ GET /foyer/Foyer/getAll (correct)
   ```

---

### ❌ Problème: "Java 17 not installed"

**Solution**:
1. Télécharger Java 17: https://www.oracle.com/java/technologies/downloads/
2. Installer en suivant les instructions
3. Vérifier l'installation:
   ```powershell
   java -version
   ```

---
## ⚡ Quick Start (30 secondes)

Pour démarrer rapidement le projet:

1. **Cloner/Ouvrir le projet**
   ```bash
   cd GestionFoyer
   ```

2. **Démarrer XAMPP**
   - Ouvrir XAMPP Control Panel
   - Cliquer "Start" pour Apache ET MySQL

3. **Lancer l'application**
   ```bash
   mvn spring-boot:run
   ```

4. **Accéder à l'interface**
   - **Swagger UI**: http://localhost:8088/foyer/swagger-ui/index.html
   - **Postman**: Importer depuis http://localhost:8088/foyer/v3/api-docs

✅ **C'est tout!** L'application tourne maintenant.

---

## ❓ FAQ

### **Q: Où sont stockées les données?**
**A**: Dans MySQL (base de données `foyerDb` automatiquement créée par Hibernate).

### **Q: Je peux changer le port 8088?**
**A**: Oui! Modifiez `application.properties`:
```properties
server.port=8089
```
Puis accédez à: `http://localhost:8089/foyer`

### **Q: Comment exporter les données de la base?**
**A**: Via **phpmyadmin** (inclus dans XAMPP):
1. Ouvrir: http://localhost/phpmyadmin
2. Sélectionner la base `foyerDb`
3. Onglet "Export" et télécharger le fichier SQL

### **Q: Où sont les tests unitaires?**
**A**: À implémenter! C'est dans les "Améliorations futures" - c'est un bon exercice.

### **Q: Je peux utiliser PostgreSQL à la place de MySQL?**
**A**: Oui! Changez dans `pom.xml` et `application.properties`:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/foyerDb
spring.datasource.driver-class-name=org.postgresql.Driver
```

### **Q: Comment voir les logs de Hibernate?**
**A**: Ajoutez à `application.properties`:
```properties
logging.level.org.hibernate.SQL=DEBUG
logging.level.org.hibernate.type.descriptor.sql.BasicBinder=TRACE
```

### **Q: Les changements du code sont appliqués automatiquement?**
**A**: Non, vous devez **redémarrer l'application**. Pour le rechargement automatique, ajoutez:
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-devtools</artifactId>
    <scope>runtime</scope>
</dependency>
```

---

## 📚 Glossaire

### Termes Spring Boot

| Terme | Signification |
|-------|---------------|
| **@Entity** | Marque une classe comme entité JPA (stockée en BD) |
| **@Repository** | Marque une classe comme accès aux données |
| **@Service** | Marque une classe comme logique métier |
| **@Controller / @RestController** | Marque une classe pour traiter les requêtes HTTP |
| **@Autowired** | Injection automatique de dépendances |
| **@RequestMapping** | Mappe une URL à une méthode |
| **@PostMapping / @GetMapping** | Mappe POST/GET à une méthode |
| **@RequestBody** | Récupère le JSON du corps de la requête |
| **@PathVariable** | Récupère une variable de l'URL |
| **@Query** | Exécute une requête JPQL personnalisée |
| **@Scheduled** | Exécute une méthode à intervalles réguliers |
| **@Aspect** | Marque une classe comme aspect AOP |
| **@Before / @After / @Around** | Pointcuts AOP |

### Termes Base de données

| Terme | Signification |
|-------|---------------|
| **JPA** | Java Persistence API - standard ORM Java |
| **Hibernate** | Implémentation JPA (traduit Java ↔ SQL) |
| **Entity** | Classe mappée à une table de base |
| **OneToOne** | Relation 1:1 entre deux entités |
| **OneToMany** | Relation 1:N (un foyer → plusieurs blocs) |
| **ManyToMany** | Relation N:N (étudiants ↔ réservations) |
| **Primary Key (PK)** | Identifiant unique d'une ligne (idFoyer) |
| **Foreign Key (FK)** | Clé pointant vers une autre table |
| **Cascade** | Suppression automatique des éléments liés |

### Termes REST API

| Terme | Signification |
|-------|---------------|
| **Endpoint** | URL + méthode HTTP (ex: GET /foyer/getAll) |
| **CRUD** | Create, Read, Update, Delete |
| **JSON** | Format de données (ex: {"nom": "Foyer"}) |
| **HTTP Status 200** | OK - Requête réussie |
| **HTTP Status 404** | Not Found - Ressource inexistante |
| **HTTP Status 500** | Server Error - Erreur serveur |
| **Swagger UI** | Documentation interactive des API |
| **Postman** | Outil pour tester les API |

### Termes Architecture

| Terme | Signification |
|-------|---------------|
| **Couche** | Niveau d'abstraction (Controller → Service → Repository → DB) |
| **Pattern** | Solution réutilisable pour un problème récurrent |
| **DTO** | Data Transfer Object - classe pour envoyer/recevoir des données |
| **Mapper** | Convertit une Entity en DTO et vice-versa |
| **AOP** | Aspect-Oriented Programming - ajouter comportement sans modifier le code |
| **DI** | Dependency Injection - injecter les dépendances automatiquement |
| **IoC** | Inversion of Control - donner le contrôle à Spring |

---

## 🛠️ Configuration Avancée

### Variables d'environnement

Vous pouvez utiliser des variables d'environnement pour sécuriser les données sensibles:

```properties
# application.properties
spring.datasource.username=${DB_USER:root}
spring.datasource.password=${DB_PASSWORD:}
server.port=${SERVER_PORT:8088}
```

Puis définir les variables:
```powershell
# PowerShell
$env:DB_USER = "root"
$env:DB_PASSWORD = ""
$env:SERVER_PORT = "8088"
```

Ou créer un `.env` file (à la racine):
```
DB_USER=root
DB_PASSWORD=
SERVER_PORT=8088
```

### Profils Spring

Créer différentes configurations pour dev/test/prod:

**application-dev.properties** (Développement):
```properties
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
server.port=8088
```

**application-prod.properties** (Production):
```properties
spring.jpa.hibernate.ddl-auto=validate
spring.jpa.show-sql=false
server.port=8080
```

Lancer avec un profil:
```bash
mvn spring-boot:run -Dspring-boot.run.arguments="--spring.profiles.active=dev"
```

---
## 📝 Licence

Projet académique - À usage éducatif uniquement

---

## 🤝 Support

Pour toute question ou problème :
1. Vérifier la configuration MySQL
2. Consulter les logs Spring Boot
3. Vérifier les endpoints via Swagger UI
4. Tester avec Postman

**Port application** : 8088  
**Context path** : /foyer  
**URL Swagger** : http://localhost:8088/foyer/swagger-ui/index.html

---

*Dernière mise à jour : Mars 2026*
