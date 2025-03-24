# CYBooks

CYBooks est un logiciel de gestion bibliothécaire développé en Java. Il permet de gérer les stocks de livres, les emprunts et d'enrichir sa base de données en récupérant des informations via l'API de la BNF.

## Fonctionnalités
- **Gestion des stocks** : Ajout, suppression et modification des livres disponibles.
- **Suivi des emprunts** : Enregistrement des prêts et retours des ouvrages.
- **Connexion à l'API BNF** : Récupération automatique des métadonnées des livres.
- **Interface utilisateur** : Développée avec JavaFX

## Technologies utilisées
- **Langage** : Java
- **Interface graphique** : JavaFX
- **Base de données** : MySQL (le projet ne crée pas la base de données automatiquement, elle doit être créée manuellement à l'aide d'un script)
- **API externe** : BNF (Bibliothèque nationale de France)

## Installation
1. **Cloner le dépôt** :
   ```bash
   git clone https://github.com/Saorex/Java-CYBooks.git
   cd Java-CYBooks
   ```
2. **Compiler et exécuter le projet** :
   ```bash
   mvn clean install
   java -jar target/CYBooks.jar
   ```
