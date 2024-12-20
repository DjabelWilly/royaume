package fr.digi.royaume;

import com.mongodb.client.MongoDatabase;
import fr.digi.royaume.entites.GestionCitoyens;
import fr.digi.royaume.entites.GestionRessources;
import fr.digi.royaume.utils.ConnexionMongoDB;

public class App {
    public static void main(String[] args) {

        // Création d'une instance de la classe ConnexionMongoDB
        ConnexionMongoDB connexion = new ConnexionMongoDB();

        // Obtenir la base de données
        MongoDatabase database = connexion.getDatabase();

//---------------Gestion des ressources------------------
        // Ajout de la ressource "Or" en quantité 500
        //    GestionRessources addOr = new GestionRessources(database, "Ressources");
        //   addOr.ajouterRessource("Or", 500);

        // modifier la quantité de la ressource "Or" à 700
        //  GestionRessources modifierRessource = new GestionRessources(database, "Ressources");
        //  modifierRessource.modifierRessource("Or", 700);

        // Suppression de la ressource "Or"
        //  GestionRessources supprimerRessource = new GestionRessources(database, "Ressources");
        //  supprimerRessource.supprimerRessource("Or");

        // Affiche toutes les ressources
        // GestionRessources displayRessources = new GestionRessources(database, "Ressources");
        // displayRessources.afficherRessource();

        // Affiche le total de la ressource "Or"
        //GestionRessources totalOR = new GestionRessources(database, "Ressources");
        //int orTotal = totalOR.totalRessource("Or");
        //System.out.println("quantité totale de l'or: " + orTotal);

//-------------------Gestion des citoyens------------------
        // Ajout d'un citoyen
        //GestionCitoyens addCitoyen = new GestionCitoyens(database, "Citoyens");
        //addCitoyen.ajouterCitoyen("Soldat", "protection", 1000);

        // Affiche tous les citoyens
        //GestionCitoyens citoyens = new GestionCitoyens(database, "Citoyens");
        //citoyens.getCitoyens();

        // Affiche un type de citoyen (Paysan)
        //GestionCitoyens citoyen = new GestionCitoyens(database, "Citoyens");
        //citoyen.getCitoyenByType("Paysan");

        // Suppression d'un citoyen
        //GestionCitoyens deleteCitoyen = new GestionCitoyens(database, "Citoyens");
        //deleteCitoyen.deleteCitoyen("Paysan", 200);

        // Modifier la quantité d'un citoyen
        //GestionCitoyens updateCitoyen = new GestionCitoyens(database, "Citoyens");
        //updateCitoyen.updateCitoyen("Soldat", "protection", 600);

        // Fermer la connexion
        connexion.fermerConnexion();

    }
}