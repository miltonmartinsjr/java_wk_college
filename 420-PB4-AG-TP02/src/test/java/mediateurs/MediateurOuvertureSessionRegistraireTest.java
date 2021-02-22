package mediateurs;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import ecole.Registraire;
import utilisateur.MediateurOuvertureSessionUtilisateur;
import utilisateur.RegistreSessionUtilisateur;
import utilisateur.RegistreUtilisateur;
import utilisateur.SessionUtilisateur;

public class MediateurOuvertureSessionRegistraireTest {

    private final RegistreSessionUtilisateur registreSessionUtilisateur =
        Mockito.mock(RegistreSessionUtilisateur.class);

    private final RegistreUtilisateur registreUtilisateur = Mockito.mock(RegistreUtilisateur.class);

    public MediateurOuvertureSessionRegistraireTest() {

    }

    @Test
    public void test() {

        MediateurOuvertureSessionUtilisateur mediateur =
            new MediateurOuvertureSessionUtilisateur(

                this.registreUtilisateur,
                this.registreSessionUtilisateur);

        Registraire registraire = new Registraire("Test");
        Registraire reponseObtenir = new Registraire("Reponse");
        SessionUtilisateur sessionUtilisateur = new SessionUtilisateur(registraire);

        Mockito.when(this.registreUtilisateur.obtenir(registraire))
            .thenReturn(reponseObtenir);
        Mockito.when(this.registreSessionUtilisateur.creer(reponseObtenir))
            .thenReturn(sessionUtilisateur);
        SessionUtilisateur reponseSession = mediateur.executer(registraire);

        Assert.assertTrue(
            reponseSession.getUtilisateur()
                .getIdentificateur()
                .equalsIgnoreCase("Test"));
        Assert.assertNotNull(reponseSession);
    }

}
