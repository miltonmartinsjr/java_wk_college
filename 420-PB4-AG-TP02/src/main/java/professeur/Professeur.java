package professeur;

import java.util.Date;

import ecole.Departement;
import utilisateur.Utilisateur;

public class Professeur
    extends Utilisateur {

    private final Date dateDeNaissance;

    private final Departement departement;

    private final String nomProf;

    private final String numeroAssuranceSocial;

    private final String preNomProf;

    private final StatutProfesseur statutProfesseur;

    public Professeur(
        final String identificateur_,
        final String nomProf_,
        final String preNomProf_,
        final Date dateDeNaissance_,
        final String numeroAssuranceSocial_,
        final Departement departement_,
        final StatutProfesseur statutProfesseur_) {

        super(identificateur_);
        this.nomProf = nomProf_;
        this.preNomProf = preNomProf_;
        this.dateDeNaissance = dateDeNaissance_;
        this.numeroAssuranceSocial = numeroAssuranceSocial_;
        this.departement = departement_;
        this.statutProfesseur = statutProfesseur_;
    }

    public final Date getDateDeNaissance() {

        return this.dateDeNaissance;
    }

    public final Departement getDepartement() {

        return this.departement;
    }

    public final String getNom() {

        return this.nomProf;
    }

    public final String getNumeroAssuranceSocial() {

        return this.numeroAssuranceSocial;
    }

    public final String getPreNom() {

        return this.preNomProf;
    }

    public final StatutProfesseur getStatutProfesseur() {

        return this.statutProfesseur;
    }

    @Override
    public final String toString() {

        return "Professeur [getDateDeNaissance()="
            + getDateDeNaissance()
            + ", getDepartement()="
            + getDepartement()
            + ", getNom()="
            + getNom()
            + ", getNumeroAssuranceSocial()="
            + getNumeroAssuranceSocial()
            + ", getPreNom()="
            + getPreNom()
            + ", getStatutProfesseur()="
            + getStatutProfesseur()
            + "]";
    }
}
