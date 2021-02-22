package utilisateur;

public class SessionUtilisateur {

    private final Utilisateur utilisateur;

    public SessionUtilisateur(final Utilisateur utilisateur_) {

        this.utilisateur = utilisateur_;
    }

    public final Utilisateur getUtilisateur() {

        return this.utilisateur;
    }

}
