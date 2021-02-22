package professeur;

public class MediateurSupressionProfesseur {

    private final RegistreProfesseur registreProfesseur;

    public MediateurSupressionProfesseur(final RegistreProfesseur registreProfesseur_) {

        super();
        this.registreProfesseur = registreProfesseur_;
    }

    public final void executer(
        final Professeur professeur_)
        throws ExceptionProfesseurIntrouvable {

        Professeur professeur = this.registreProfesseur.obtenir(professeur_);

        if (professeur.getNom()
            .isEmpty()
            && professeur.getNom()
                .isEmpty()) {
            throw new ExceptionProfesseurIntrouvable();
        }

        this.registreProfesseur.suprimer(professeur);
    }
}
