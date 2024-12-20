package fr.digi.royaume.entites;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class GestionCitoyens {
    private MongoCollection<Document> collection;

    public GestionCitoyens(MongoDatabase database, String collectionName) {
        this.collection = database.getCollection(collectionName);
    }

    // Méthode pour ajouter un citoyen (additionne la quantité si le citoyen existe deja)
    public void ajouterCitoyen(String type, String role, int quantite) {
        Document citoyen = new Document("type", type).append("role", role).append("quantite", quantite);
        if (collection.countDocuments(new Document("type", type)) > 0) {
            // Si le citoyen existe, on ajoute sa quantité à la nouvelle quantité
            Document existingCitoyen = collection.find(new Document("type", type)).first();
            int existingQuantite = existingCitoyen.getInteger("quantite");
            int newQuantite = existingQuantite + quantite;
            collection.updateOne(new Document("type", type), new Document("$set", new Document("quantite", newQuantite)));
        } else {
            collection.insertOne(citoyen);
        }
        System.out.println("Le citoyen " + type + " en quantité " + quantite + " a été ajoutée");
    }

    // Methode pour afficher les citoyens
    public void getCitoyens() {
        for (Document citoyens : collection.find()) {
            System.out.println(citoyens.toJson());
        }
    }

    // Methode pour afficher un type de citoyen
    public void getCitoyenByType(String type) {
        Document citoyen = collection.find(new Document("type", type)).first();
        System.out.println(citoyen.toJson());
    }

    // Methode pour supprimer un citoyen
    public void deleteCitoyen(String type, int quantite) {
        if (collection.countDocuments(new Document("type", type)) > 0) {
            Document citoyen = collection.find(new Document("type", type)).first();
            int existingQuantite = citoyen.getInteger("quantite");
            int newQuantite = existingQuantite - quantite;
            if (newQuantite <= 0) {
                collection.deleteOne(new Document("type", type));
            } else {
                collection.updateOne(new Document("type", type), new Document("$set", new Document("quantite", newQuantite)));
            }
            System.out.println("Le citoyen " + type + " en quantité " + quantite + " a été supprimée");
        }
    }

    // Modifier la quantité d'un citoyen
    public void updateCitoyen(String type, String role, int quantite) {
        // Test s'il y a un citoyen de ce type
        if (collection.countDocuments(new Document("type", type)) <= 0) {
            System.out.println("aucun citoyen de ce type n'existe dans la base de données");
        }
        if (collection.countDocuments(new Document("type", type)) > 0) {
            collection.updateOne(new Document("type", type), new Document("$set", new Document("quantite", quantite)));
            System.out.println("La quantité du citoyen " + type + " a été modifiée à " + quantite);

        }

    }

}