package professeur;

public class MediateurCreationProfesseur {

    private final RegistreProfesseur registreProfesseur;

    public MediateurCreationProfesseur(final RegistreProfesseur registreProfesseur_) {

        this.registreProfesseur = registreProfesseur_;
    }

    public final Professeur executer(
        final Professeur professeur_) {

        return this.registreProfesseur.creer(professeur_);
    }

}
