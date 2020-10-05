package test;

public class Conseiller {

    /**
     * Nom de l'abonné -- Just pour différencier
     */
    private String nom;

    /**
     * Canal de connexion
     */
    private String canalDeConnexion;


    /**
     * Setters and Getters
     */
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCanalDeConnexion() {
        return canalDeConnexion;
    }

    public void setCanalDeConnexion(String canalDeConnexion) {
        this.canalDeConnexion = canalDeConnexion;
    }

    /**
     * Constructeur
     * @param nom
     */
    public Conseiller(String nom) {
        this.nom = nom;
    }

}
