package mediateurs;

import org.junit.Test;
import org.mockito.Mockito;

import utilisateur.MediateurOuvertureSessionUtilisateur;
import utilisateur.RegistreSessionUtilisateur;
import utilisateur.RegistreUtilisateur;
import utilisateur.SessionUtilisateur;
import utilisateur.Utilisateur;

public class MediateurOuvertureSessionUtilisateurIntrovableTest {

    private final RegistreSessionUtilisateur registreSessionUtilisateur =
        Mockito.mock(RegistreSessionUtilisateur.class);

    private final RegistreUtilisateur registreUtilisateur = Mockito.mock(RegistreUtilisateur.class);

    public MediateurOuvertureSessionUtilisateurIntrovableTest() {

    }

    @Test
    public void test() {

        MediateurOuvertureSessionUtilisateur mediateur =
            new MediateurOuvertureSessionUtilisateur(
                this.registreUtilisateur,
                this.registreSessionUtilisateur);
        Utilisateur utilisateur = new Utilisateur("Test");
        Utilisateur reponseObtenir = new Utilisateur("");
        SessionUtilisateur sessionUtilisateur = new SessionUtilisateur(utilisateur);

        Mockito.when(this.registreUtilisateur.obtenir(utilisateur))
            .thenReturn(reponseObtenir);
        Mockito.when(this.registreSessionUtilisateur.creer(reponseObtenir))
            .thenReturn(sessionUtilisateur);
        @SuppressWarnings("unused")
        SessionUtilisateur reponseSession = mediateur.executer(utilisateur);

    }
}
