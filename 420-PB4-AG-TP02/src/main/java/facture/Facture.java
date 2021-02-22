package facture;

import cours.InscriptionSemestre;
import etudiant.Etudiant;

public class Facture {

    private final Etudiant etudiant;

    private final InscriptionSemestre inscriptionSemestre;

    private final StatusFacture statusFacture;

    public Facture(
        final Etudiant etudiant_,
        final InscriptionSemestre inscriptionSemestre_,
        final StatusFacture statusFacture_) {

        super();
        this.etudiant = etudiant_;
        this.inscriptionSemestre = inscriptionSemestre_;
        this.statusFacture = statusFacture_;
    }

    public final Etudiant getEtudiant() {

        return this.etudiant;
    }

    public final InscriptionSemestre getInscriptionSemestre() {

        return this.inscriptionSemestre;
    }

    public final StatusFacture getStatusFacture() {

        return this.statusFacture;
    }

    @Override
    public final String toString() {

        return "Facture [getEtudiant()="
            + getEtudiant()
            + ", getInscriptionSemestre()="
            + getInscriptionSemestre()
            + ", getStatusFacture()="
            + getStatusFacture()
            + "]";
    }

}
