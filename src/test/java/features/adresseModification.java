package features;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import test.*;

import java.util.Arrays;
import java.util.List;

public class adresseModification {

    List<Contrat> contrats = Arrays.asList(new Contrat());

    Abonne abonne= new Abonne("Bouzoubaa", contrats);

    String nouvelleAdresse = "Nouvelle Adresse de l'abonné!";

    Conseiller conseiller = new Conseiller("Conseiller");

    Mouvement mouvement = new Mouvement();

    private ChangementService changementService = new ChangementService();



    @Given("^un abonné avec une adresse principale \"([^\"]*)\" en France$")
    public void unAbonnéAvecUneAdressePrincipaleEnFrance(String etat) {
        abonne.setAdressePrincipaleEtat(etat);
    }

    @When("le conseiller connecté à \"([^\"]*)\" modifie l'adresse de l'abonné")
    public void leConseillerConnectéModifieLAdresseDeLAbonné(String canal) {

        changementService.changementAdresse(abonne, conseiller, canal, nouvelleAdresse,
                mouvement);
    }

    @Then("l'adresse de l'abonné modifiée est enregistrée sur l'ensemble des contrats de l'abonné")
    public void lAdresseDeLAbonnéModifiéeEstEnregistréeSurLEnsembleDesContratsDeLAbonné() {
        abonne.getContrats().forEach(contrat -> {
            Assert.assertEquals(nouvelleAdresse, contrat.getAdressePrincipale());
        });

    }

    @And("un mouvement de modification d'adresse est créé")
    public void unMouvementDeModificationDAdresseEstCréé() {
        Assert.assertEquals(true, mouvement.isCreated());
    }
}
