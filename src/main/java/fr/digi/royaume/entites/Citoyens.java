package fr.digi.royaume.entites;

public class Citoyens {

    private String type;
    private int quantite;
    private String role;

    public Citoyens(String nom, int quantité, String role) {
        this.type = type;
        this.quantite = quantite;
        this.role = role;
    }

    public void afficherCitoyens() {
        System.out.println("Citoyen: " + type + ", quantité: " + quantite + "rôle: " + role);
    }

}
