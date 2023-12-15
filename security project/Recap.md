# This folder for my security project : 
## Brute Force using  Burp Suite
Demo --> 

https://github.com/wissemkarous/Learn-hub/assets/115191512/8a839d53-96a4-45f5-8772-c54030491346


# Configuration de Burp Comme Proxy pour DVWA :

## 1. Vérification du Fonctionnement de Burp avec DVWA
   - Ouvrir Burp et accéder à l'onglet Proxy pour s'assurer que l'option Intercept est activée.

## 2. Configuration du Navigateur pour DVWA :
   - Changer les paramètres proxy du navigateur pour DVWA.
   - Dans Firefox (sur Kali), accéder aux Préférences, dans Avancé, puis onglet Réseau, et enfin Paramètres.
   - Sélectionner la configuration manuelle du proxy.
   - Entrer 127.0.0.1 comme adresse pour le proxy HTTP, et 8080 comme port.
   - Cocher la case "Utiliser ce serveur proxy pour tous les protocoles".
   - Enregistrer les paramètres.

## 3. Vérification de la Configuration avec DVWA
   - S'assurer que le trafic HTTP/S de DVWA passe à travers Burp.
   - Le tab Proxy dans Burp devrait devenir orange lors de la visite de DVWA.

# Brute Force sur la Page de Connexion DVWA :

## 4. Activation de l'Interception dans Burp pour DVWA
   - S'assurer que l'interception dans Burp est activée.

## 5. Préparation des Listes d'Utilisateur et de Mot de Passe pour DVWA
   - Utiliser des listes d'utilisateurs/mots de passe existantes ou préparer une liste personnalisée.
   - Charger une liste d'utilisateurs et une liste de mots de passe dans Burp.

## 6. Lancement de l'Attaque Brute Force sur DVWA
   - Se connecter à DVWA et accéder à la page de connexion.
   - Capturer la requête dans Burp, puis envoyer à Intruder.
   - Dans l'onglet Intruder, Positions, choisir Cluster bomb comme type d'attaque.
   - Sélectionner les positions pour les paramètres d'utilisateur et de mot de passe de DVWA.
   - Charger les listes d'utilisateurs et de mots de passe dans les Payloads.
   - Lancer l'attaque en cliquant sur Start attack.

## 7. Analyse des Réponses de DVWA :
   - Vérifier les réponses pour détecter des anomalies.
   - Identifier les réponses qui indiquent une correspondance réussie.

## 8. Finalisation de l'Attaque sur DVWA
   - Utiliser les informations découvertes pour accéder à l'interface d'administration de DVWA.
