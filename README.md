``markdown
# 💼 Ewallet – Application de portefeuille électronique

Cette application permet de gérer des transactions financières entre utilisateurs, commerçants et agents via un système sécurisé basé sur Spring Boot.

---

## Technologies utilisées

| Technologie                       | Usage                                              |
|-----------------------------------|----------------------------------------------------|
| **Java 21**                       | Langage principal                                  |
| **Spring Boot**                   | Framework backend                                  |
| **Spring Web**                    | Création des API REST                              |
| **Spring Data JPA**               | Accès aux données via ORM                          |
| **Spring Security**               | Authentification et autorisation                   |
| **Spring Security Test**          | Tests liés à la sécurité                           |
| **Jakarta Persistence API**       | Spécification JPA standard                         |
| **Lombok**                        | Réduction du code boilerplate                      |
| **ZXing (com.google.zxing)**      | Génération de QR codes                             |
| **MySQL Connector**               | Connexion à la base de données MySQL               |
| **Maven**                         | Gestion des dépendances et du cycle de build       |

---

## Installation

### Prérequis
- Java 17+
- Maven
- MySQL

### Étapes

``bash
git clone https://github.com/Shdw-lx/NeonCred.git
cd ewallet
mvn install
``

Configure la base de données dans `application.properties`:

``properties
spring.datasource.url=jdbc:mysql://localhost:3306/coin
spring.datasource.username=admin
spring.datasource.password=admin123
``

---

*▶ Lancement*

``bash
mvn spring-boot:run
``

---

*Endpoints*

`/agent` avec la méthode GET pour recuperer la liste des agents
`/agent/{id}` avec la methode GET pour recuperer un agent
`/agent/add` avec la methode POST pour ajouter un agent
`/agent/{id}` avec la methode PUT pour update un agent
`/agent/{id}` avec la methode DELETE pour delete un agent

`/banque` avec la methode GET pour recuperer la liste des banques
`/banque/{id}` avec la methode GET pour recuperer une banque
`/banque/add` avec la methode POST pour ajouter une banque
`/banque/{id}` avec la methode PUT pour update une banque
`/banque/{id}` avec la methode DELETE pour delete une banque

`/client` avec la methode GET pour recuperer la liste des clients
`/client/{id}` avec la methode GET pour recuperer un client
`/client/add` avec la methode POST pour ajouter un client
`/client/{id}` avec la methode PUT pour update un client
`/client/{id}` avec la methode DELETE pour delete un client

`/commercant` avec la methode GET pour recuperer la liste des commercants
`/commercant/{id}` avec la methode GET pour recuperer un commercant
`/commercant/add` avec la methode POST pour ajouter un commercant
`/commercant/{id}` avec la methode PUT pour update un commercant
`/commercant/{id}` avec la methode DELETE pour delete un commercant

`/compte` GET - recuperer la liste des comptes
`/compte/{id}` GET - recuperer un compte
`/compte/add` POST - ajouter un compte
`/compte/{id}` PUT - update un compte
`/compte/{id}` DELETE - delete un compte

`/produit` GET - recuperer la liste des produits
`/produit/{id}` GET - recuperer un produit
`/produit/add` POST - ajouter un produit
`/produit/{id}` PUT - update un produit 
`/produit/{id}` DELETE - delete un produit

`/transaction` GET - recuperer la liste des transactions
`/transaction/{id}` GET - recuperer une transactions 
`/transaction/Payform` POST - faire une transaction par formulaire avec le parametre : TransactionRequest request
`/transaction/PayQr` POST - faire une transaction par scan du QR code avec le parametre : TransactionRequest request
`/transaction/GenerateQR` GET - generer le QR code pour la transaction en prenant en body les elements suivants: String commercantId, String produitId, Long montant

`/utilisateur` GET - recuperer la liste des utilisateurs
`/utilisateur/{id}` GET - recuperer un utilisateur
`/utilisateur/add` POST - ajouter un utilisateur
`/utilisateur/{id}` PUT - update un utilisateur
`/utilisateur/{id}` DELETE - delete un utilisateur

*Tests*

Les tests unitaires et d’intégration sont disponibles dans le dossier `src/test`.
Utilise Maven pour les exécuter:

``bash
mvn test
``

---

*Auteur*

Mohamadou Hamza
mohamadouhamza983@gmail.com
Dernière mise à jour: septembre 2025