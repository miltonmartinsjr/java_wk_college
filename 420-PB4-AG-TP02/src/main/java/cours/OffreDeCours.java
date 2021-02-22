package cours;

import java.util.List;

import etudiant.Etudiant;
import professeur.Professeur;

public class OffreDeCours {

    private final Cours cours;

    private final Etudiant etudiant;

    private final List<Etudiant> listEtudiant;

    private final Professeur professeur;

    private final Semestre semestre;

    private final StatusOffreDeCours statusOffreDeCours;

    public OffreDeCours(
        final Cours cours_,
        final Etudiant etudiant_,
        final List<Etudiant> listEtudiant_,
        final Professeur professeur_,
        final Semestre semestre_,
        final StatusOffreDeCours statusOffreDeCours_) {

        super();
        this.cours = cours_;
        this.etudiant = etudiant_;
        this.listEtudiant = listEtudiant_;
        this.professeur = professeur_;
        this.semestre = semestre_;
        this.statusOffreDeCours = statusOffreDeCours_;
    }

    public final boolean estValide() {

        final int minimumDeEtudiants = 3;

        if (this.listEtudiant.size() >= minimumDeEtudiants && this.professeur != null) {
            return true;
        }

        return false;
    }

    public final Cours getCours() {

        return this.cours;
    }

    public final Etudiant getEtudiant() {

        return this.etudiant;
    }

    public final List<Etudiant> getListEtudiant() {

        return this.listEtudiant;
    }

    public final Professeur getProfesseur() {

        return this.professeur;
    }

    public final Semestre getSemestre() {

        return this.semestre;
    }

    public final StatusOffreDeCours getStatusOffreDeCours() {

        return this.statusOffreDeCours;
    }

    @Override
    public final String toString() {

        return "OffreDeCours [estValide()="
            + estValide()
            + ", getCours()="
            + getCours()
            + ", getEtudiant()="
            + getEtudiant()
            + ", getListEtudiant()="
            + getListEtudiant()
            + ", getProfesseur()="
            + getProfesseur()
            + ", getSemestre()="
            + getSemestre()
            + ", getStatusOffreDeCours()="
            + getStatusOffreDeCours()
            + "]";
    }

}
