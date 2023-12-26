# Application d'Avis sur les Hôtels

La classe `HotelReviewApp` est une application Java Swing qui permet aux utilisateurs de soumettre des avis sur les hôtels avec des évaluations pour différents critères. Elle comprend des fonctionnalités d'annulation et de rétablissement des modifications, de sauvegarde des données dans un fichier CSV, de mise à jour des visualisations récapitulatives et de réinitialisation des champs de saisie.

## Structure de l'Application

### 1. Panneau d'Entrée
L'application dispose d'un panneau d'entrée, créé par la méthode `createInputPanel`, où les utilisateurs fournissent des détails tels que le nom de l'hôtel, les évaluations pour le confort, la sécurité, l'animation et la propreté à l'aide de curseurs, ainsi que des commentaires dans une zone de texte.

### 2. Panneau de Boutons
La méthode `createButtonPanel` établit le panneau de boutons avec les boutons "Soumettre" et "Annuler". Le bouton "Soumettre" déclenche le processus de soumission, enregistrant les données dans un fichier CSV, mettant à jour les visualisations et réinitialisant les champs. Le bouton "Annuler" permet aux utilisateurs d'annuler les modifications apportées dans la zone de texte des commentaires.

### 3. Fonctionnalité Annuler/Refaire
La méthode `addUndoRedoFunctionality` configure les fonctionnalités d'annulation et de rétablissement à l'aide de `UndoManager` pour la zone de texte des commentaires. Les utilisateurs peuvent utiliser des raccourcis clavier (Ctrl-Z et Ctrl-Shift-Z) pour annuler et rétablir des modifications.

### 4. Sauvegarde des Données au Format CSV
La méthode `saveDataToCSV` enregistre les données soumises, y compris la date, le nom de l'hôtel, les évaluations des critères et les commentaires, dans un fichier CSV nommé "data.csv."

### 5. Mise à Jour du Résumé
La méthode `updateSummary` est actuellement un espace réservé pour un développement futur, destiné à utiliser les données du fichier CSV pour générer des histogrammes et des courbes au fil du temps.

### 6. Réinitialisation des Champs
La méthode `resetFields` réinitialise tous les champs de saisie, y compris le nom de l'hôtel, les évaluations des critères et les commentaires, à leurs états initiaux.

### 7. Visualisation des Données

La classe `CSVDataVisualization` lit les données du fichier "data.csv" et crée un graphique à barres à l'aide de la bibliothèque JFreeChart. Le graphique visualise les évaluations d'hôtels pour le confort, la sécurité, l'animation et la propreté.

## Utilisation

- Les utilisateurs saisissent les détails de l'hôtel et les évaluations dans les champs fournis.
- En cliquant sur le bouton "Soumettre", les données sont enregistrées dans un fichier CSV, les visualisations sont mises à jour, et les champs de saisie sont réinitialisés.
- Le bouton "Annuler" permet aux utilisateurs d'annuler les modifications apportées dans la zone de texte des commentaires.

