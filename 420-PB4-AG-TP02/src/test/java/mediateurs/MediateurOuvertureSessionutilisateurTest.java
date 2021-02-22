package mediateurs;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import utilisateur.MediateurOuvertureSessionUtilisateur;
import utilisateur.RegistreSessionUtilisateur;
import utilisateur.RegistreUtilisateur;
import utilisateur.SessionUtilisateur;
import utilisateur.Utilisateur;

public class MediateurOuvertureSessionutilisateurTest {

    private final RegistreSessionUtilisateur registreSessionUtilisateur =
        Mockito.mock(RegistreSessionUtilisateur.class);

    private final RegistreUtilisateur registreUtilisateur = Mockito.mock(RegistreUtilisateur.class);

    public MediateurOuvertureSessionutilisateurTest() {

    }

    @Test
    public void test() {

        MediateurOuvertureSessionUtilisateur mediateur =
            new MediateurOuvertureSessionUtilisateur(

                this.registreUtilisateur,
                this.registreSessionUtilisateur);

        Utilisateur utilisateur = new Utilisateur("Test");
        Utilisateur reponseObtenir = new Utilisateur("Reponse");
        SessionUtilisateur sessionUtilisateur = new SessionUtilisateur(utilisateur);

        Mockito.when(this.registreUtilisateur.obtenir(utilisateur))
            .thenReturn(reponseObtenir);
        Mockito.when(this.registreSessionUtilisateur.creer(reponseObtenir))
            .thenReturn(sessionUtilisateur);
        SessionUtilisateur reponseSession = mediateur.executer(utilisateur);

        Assert.assertTrue(
            reponseSession.getUtilisateur()
                .getIdentificateur()
                .equalsIgnoreCase("Test"));
        Assert.assertNotNull(reponseSession);
    }

}
