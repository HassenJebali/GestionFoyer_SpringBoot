# Package AOP (Aspect-Oriented Programming)

## 📋 Description
Ce package contient les aspects (intercepteurs) pour la programmation orientée aspect. Il utilise Spring AOP pour implémenter des fonctionnalités transversales (cross-cutting concerns) comme le logging et le monitoring des performances.

## 📁 Contenu

### LoggingAspect.java
- **Rôle** : Intercepte les appels aux méthodes du service `FoyerService`
- **Fonctionnalités** :
  - Journalisation (logging) automatique des appels de méthode
  - Enregistrement du nom de la méthode appelée
  - Utilise l'annotation `@Before` pour logger avant l'exécution
  - Utilise SLF4J pour la journalisation

### Performance.java
- **Rôle** : Monitoring et mesure des performances
- **Fonctionnalités** :
  - Mesure du temps d'exécution des méthodes
  - Détection des performances dégradées

## 🔧 Utilisation
Les aspects sont automatiquement appliqués grâce à l'annotation `@EnableAspectJAutoProxy` dans la classe principale.

## 📚 Technologies
- **Spring AOP** : Framework d'Aspect-Oriented Programming
- **Lombok** : `@Slf4j` pour la journalisation
- **AspectJ** : Annotations pour définir les aspects (`@Aspect`, `@Before`)
