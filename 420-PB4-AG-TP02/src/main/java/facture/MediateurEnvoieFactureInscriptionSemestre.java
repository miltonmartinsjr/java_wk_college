package facture;

import cours.InscriptionSemestre;
import cours.OffreDeCours;
import etudiant.Etudiant;

public class MediateurEnvoieFactureInscriptionSemestre {

    private final DiffuserFacture diffuserFacture;

    private final RegistreFacture registreFacture;

    public MediateurEnvoieFactureInscriptionSemestre(
        final DiffuserFacture diffuserFacture_,
        final RegistreFacture registreFacture_) {

        super();
        this.diffuserFacture = diffuserFacture_;
        this.registreFacture = registreFacture_;
    }

    public final void executer(
        final InscriptionSemestre inscriptionSemestre_) {

        for (OffreDeCours offreDeCours : inscriptionSemestre_.getListoffreDeCours()) {
            for (Etudiant etudiant : offreDeCours.getListEtudiant()) {
                StatusFacture statusfacture = new StatusFacture(false);
                Facture creerFacture = new Facture(etudiant, inscriptionSemestre_, statusfacture);
                Facture obtenu = this.registreFacture.obtenir(creerFacture);
                obtenu = this.diffuserFacture.diffuser(obtenu);

            }

        }

    }

}
