# Application d'Avis sur les Hôtels

La classe `hotelreview` est une application Java Swing qui permet aux utilisateurs de soumettre des avis sur les hôtels avec des notes pour différents critères. L'application comprend également des fonctionnalités pour annuler et refaire des modifications, sauvegarder des données dans une base de données et visualiser les notes des critères à travers un graphique circulaire.

## Structure de l'Application

### 1. Panneau d'Entrée
La méthode `createInputPanel` définit le panneau où les utilisateurs saisissent les détails de l'hôtel et les notes pour différents critères. Il comprend des champs de texte pour le nom de l'hôtel, des curseurs pour les critères de notation et une zone de texte pour les commentaires.

### 2. Panneau de Boutons
La méthode `createButtonPanel` crée le panneau contenant les boutons "Soumettre" et "Annuler". Le bouton "Soumettre" déclenche le processus de soumission, tandis que le bouton "Annuler" permet aux utilisateurs d'annuler les modifications.

### 3. Fonctionnalité Annuler/Refaire
La méthode `addUndoRedoFunctionality` configure les fonctionnalités d'annulation et de refaire en utilisant `UndoManager` pour la zone de texte des commentaires. Les utilisateurs peuvent utiliser des raccourcis clavier (Ctrl-Z et Ctrl-Shift-Z) pour annuler et refaire des modifications.

### 4. Connexion à la Base de Données et Soumission
La méthode `saveDataToDatabase` se connecte à la base de données en utilisant la classe `Connect` et insère les données de l'avis de l'utilisateur, y compris le nom de l'hôtel, les notes des critères et les commentaires.

### 5. Écouteur du Bouton de Soumission
La classe `SubmitButtonListener` gère l'action du bouton "Soumettre", déclenchant le processus de sauvegarde des données dans la base de données, la mise à jour du résumé et la réinitialisation des champs.

### 6. Écouteur du Bouton Annuler
La classe `CancelButtonListener` gère l'action du bouton "Annuler", permettant aux utilisateurs d'annuler les modifications apportées dans la zone de texte des commentaires.

### 7. Visualisation
La méthode `createPieCharts` génère un graphique circulaire en utilisant la bibliothèque JFreeChart basé sur les notes des critères. Le graphique est affiché dans un nouveau JFrame nommé "Graphique circulaire."

### 8. Mettre à Jour le Résumé
La méthode `updateSummary` appelle la méthode `createPieCharts` pour mettre à jour la visualisation du résumé en fonction des dernières données.

## Intégration avec la Base de Données

- La méthode `saveDataToDatabase` utilise la classe `Connect` pour établir une connexion à la base de données.
- Les données de l'avis de l'utilisateur, y compris le nom de l'hôtel, les notes des critères et les commentaires, sont insérées dans la table `hotel_reviews`.

## Visualisation des Données

- La méthode `createPieCharts` utilise la bibliothèque JFreeChart pour créer un graphique circulaire représentant les notes des critères.
- Le graphique circulaire est affiché dans un JFrame séparé nommé "Graphique circulaire."

## Utilisation

- Les utilisateurs saisissent les détails de l'hôtel et les notes dans les champs fournis.
- En cliquant sur le bouton "Soumettre", les données sont sauvegardées dans la base de données et le graphique circulaire est mis à jour.
- Le bouton "Annuler" permet aux utilisateurs d'annuler les modifications apportées dans la zone de texte des commentaires.
