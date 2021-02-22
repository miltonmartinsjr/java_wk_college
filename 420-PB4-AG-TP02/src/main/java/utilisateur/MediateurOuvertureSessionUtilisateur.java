package utilisateur;

public class MediateurOuvertureSessionUtilisateur {

    private final RegistreSessionUtilisateur registreSessionUtilisateur;

    private final RegistreUtilisateur registreUtilisateur;

    public MediateurOuvertureSessionUtilisateur(
        final RegistreUtilisateur registreUtilisateur_,
        final RegistreSessionUtilisateur registreSessionUtilisateur_) {

        super();
        this.registreUtilisateur = registreUtilisateur_;
        this.registreSessionUtilisateur = registreSessionUtilisateur_;
    }

    public final SessionUtilisateur executer(
        final Utilisateur utilisateur_) {

        Utilisateur utilisateur = this.registreUtilisateur.obtenir(utilisateur_);
        SessionUtilisateur sessionUtilisateur = this.registreSessionUtilisateur.creer(utilisateur);

        return sessionUtilisateur;
    }

}
