package test;

public class ChangementService {

    public void changementAdresse(Abonne abonne, Conseiller conseiller,String canal, String nouvelleAdresse,
                                  Mouvement mouvement){
        conseiller.setCanalDeConnexion(canal);

        //Modification de l'adresse de l'abonné
        abonne.setAdressePrincipale(nouvelleAdresse);

        //Modification de l'adresse de l'abonné sur l'ensemble des contrats
        abonne.getContrats().forEach(contrat -> {
            contrat.setAdressePrincipale(abonne.getAdressePrincipale());
        });

        //Création d'un mouvement de 9changement d'adresse
        mouvement.setCreated(true);

    }
}
