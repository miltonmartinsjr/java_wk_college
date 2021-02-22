package ca.qc.grasset.ag420pb411.gab;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Test;

public final class HibernateRegistreCompteTest {

    private Compte compte;

    private HibernateRegistreCompte hibernateRegistreCompte;

    private Long pkid;

    private final String type = "CHEQUES";

    public HibernateRegistreCompteTest() {

        super();
    }

    @Test
    public void execute() {

        HibernateConfigurator hibernateConfigurator = new HibernateConfigurator();
        try (SessionFactory sessionFactory = hibernateConfigurator.invoke()) {

            try (Session session = sessionFactory.openSession()) {

                this.pkid = ajouterCompte(session).getPkid();
                this.compte =
                    this.hibernateRegistreCompte.obtenir(
                        Compte.builder()
                            .pkid(this.pkid)
                            .build());
                validerCompte();
                nettoyerDonnees();
            } catch (Exception exception) {
                throw new RuntimeException(exception);
            }
        }
    }

    Compte ajouterCompte(
        final Session session_) {

        this.hibernateRegistreCompte = new HibernateRegistreCompte(session_);

        Compte nouveauCompte =
            Compte.builder()
                .type(this.type)
                .build();

        return this.hibernateRegistreCompte.ajouter(nouveauCompte);
    }

    void nettoyerDonnees(
        final Compte compte_) {

        this.hibernateRegistreCompte.effacer(compte_);
    }

    private void nettoyerDonnees() {

        nettoyerDonnees(this.compte);
    }

    private void validerCompte() {

        Assert.assertEquals(this.pkid, this.compte.getPkid());
        Assert.assertEquals(this.type, this.compte.getType());

    }

}
