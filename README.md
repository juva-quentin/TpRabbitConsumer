# TP Producer et API RabbitMQ

Ce projet est un TP avec Mailhog pour envoyer un email de validtaion à un user une fois son compte créer, avec un liens de validation d'email. Pour fonctioner, un consumer utiliser une liste rabbitMQ, créée par le second projet du TP.

## Prérequis

1- Clonner le projet : https://github.com/juva-quentin/TpRabbitConsumer.git
2- Clonner le projet du producer pour que le projet soit complet : https://github.com/juva-quentin/TP-AMQP.git
3- Docker et docker compose doivent être installé sur votre machine

## Configuration du réseau docker

Avant de lancer les conteneurs, un réseau docker nommé 'mon_reseau' doit être créer pour permettrela communication entre les conteneurs.
Exécutez la commande suivante pour créer le réseau :

```shell
docker network create mon_reseau
```

## Demarrage des services

Pour demarrer les services, dans la racine du projet, lancer cette commande :
```shell
docker compose up --build
```
## Utilisation de mailhog
Pour utiliser mailhog, vous pouvez aller à cette adresse, qui est l'interface utilisateur de mailhog, pour verifier les emails que vous avez reçu.
http://localhost:8025/#

