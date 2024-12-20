package fr.digi.royaume.entites;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class GestionRessources {
    private MongoCollection<Document> collection;

    // Constructeur
    public GestionRessources(MongoDatabase database, String collectionName) {
        this.collection = database.getCollection(collectionName);
    }

    // Méthode pour ajouter une ressource
    public void ajouterRessource(String type, int quantite) {
        Document ressource = new Document("type", type).append("quantite", quantite);
        collection.insertOne(ressource);
        System.out.println("La ressource " + type + " en quantité " + quantite + " a été ajoutée");
    }

    // Méthode pour afficher une ressource
    public void afficherRessource() {
        for (Document ressource : collection.find()) {
            System.out.println(ressource.toJson());
        }
    }

    // Methode pour supprimer une ressource
    public void supprimerRessource(String type) {
        collection.deleteOne(new Document("type", type));
        System.out.println("La ressource à bien été supprimée: ");
    }

    // Methode pour modifier une ressource
    public void modifierRessource(String type, int nouvelleQuantite) {
        collection.updateOne(new Document("type", type), new Document("$set", new Document("quantite", nouvelleQuantite)));
        System.out.println("Ressource modifiée: " + type + ", nouvelle quantité: " + nouvelleQuantite);
    }

    // Methode pour afficher le totale d'une ressource
    public int totalRessource(String type) {
        int total = 0;
        for (Document ressource : collection.find()) {
            if (ressource.getString("type").equals(type)) {
                total += ressource.getInteger("quantite");
            }
        }
        return total;
    }
}
