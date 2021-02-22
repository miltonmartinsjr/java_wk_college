package professeur;

public class MediateurModificationProfesseur {

    private final RegistreProfesseur registreProfesseur;

    public MediateurModificationProfesseur(final RegistreProfesseur registreProfesseur_) {

        super();
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
        return this.registreProfesseur.modifier(professeur_);

    }

}
