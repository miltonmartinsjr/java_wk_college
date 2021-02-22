package utilisateur;

public class Utilisateur {

    private final String identificateur;

    public Utilisateur(final String identificateur_) {

        this.identificateur = identificateur_;
    }

    public final String getIdentificateur() {

        return this.identificateur;
    }

}
