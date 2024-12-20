package fr.digi.royaume.utils;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class ConnexionMongoDB {

    private MongoClient mongoClient;
    private MongoDatabase database;

    // Constructeur qui établit la connexion
    public ConnexionMongoDB() {
        // Connexion au serveur MongoDB local
        mongoClient = MongoClients.create("mongodb+srv://djabelwilly:djabelwilly@cluster0.7fmrshj.mongodb.net/Royaume");
        // Accès à la base de données 'Royaume'
        database = mongoClient.getDatabase("Royaume");
        System.out.println("Connexion réussie à la base de données : " + database.getName());
    }

    // Méthode pour obtenir la base de données
    public MongoDatabase getDatabase() {
        return database;
    }

    // Méthode pour fermer la connexion
    public void fermerConnexion() {
        mongoClient.close();
        System.out.println("Connexion fermée.");
    }
}