package professeur;

public class MediateurObtenirProfesseur {

    private final RegistreProfesseur registreProfesseur;

    public MediateurObtenirProfesseur(final RegistreProfesseur registreProfesseur_) {

        this.registreProfesseur = registreProfesseur_;
    }

    public final Professeur executer(
        final Professeur professeur_)
        throws ExceptionProfesseurIntrouvable {

        Professeur professeur = this.registreProfesseur.obtenir(professeur_);
        if (professeur.getNom()
            .isEmpty()) {
            throw new ExceptionProfesseurIntrouvable();
        }
        return this.registreProfesseur.obtenir(professeur_);

    }

}
