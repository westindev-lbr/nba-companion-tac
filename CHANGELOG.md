# Changelog NBA Companion

## [0.4.0] - 20-01-2023
### Modifié
- HomeScreen, HomeViewModel, NbaAppNavigation
### Ajouté
- Ajout du cas d'usage GetAllTeams (récupération des équipes NBA)
- Ajout TeamRepository pour la logique de communication avec l'api
- Ajout des différents états pour la vue
- Ajout des DTO et mapper correspondant
- Ajout d'une gestion des érreurs de l'appel API à la vue
- Ajout du module d'injection de dépdences et des différents services requis avec le cas d'usage

## [0.3.0] - 15-01-2023
### Modifié
- Changement de version de compilateur et jvm (1.8 pour 17)
### Ajouté
- Ajout des dépendances pour l'injection de dépendances avec Dagger Hilt
- Ajout des dépendances pour la gestion d'API avec Retrofit
- Ajout des dépendances pour la serialization des data avec Kotlinx

## [0.2.0] - 9-09-2023
### Ajouté
- Navigation et menu de navigation
- Différents texte "en cours de construction" sur les screens géré par la navigation

## [0.1.0] - 29-11-2023
### Ajouté
- Développement initial de l'application
- Ajout TopAppBar dans l'activité principale