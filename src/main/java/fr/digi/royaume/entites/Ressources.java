package fr.digi.royaume.entites;

public class Ressources {
    private String type;
    private int quantite;

    public Ressources(String type, int quantite) {
        this.type = type;
        this.quantite = quantite;
    }

    public void afficherRessources() {
        System.out.println("Ressource: " + type + ", Quantité: " + quantite);
    }
}


