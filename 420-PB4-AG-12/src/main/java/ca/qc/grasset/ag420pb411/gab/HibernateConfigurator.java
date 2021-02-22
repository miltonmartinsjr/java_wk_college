package ca.qc.grasset.ag420pb411.gab;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public final class HibernateConfigurator {

    private ServiceRegistry serviceRegistry;

    public HibernateConfigurator() {

        super();
    }

    public SessionFactory invoke() {

        Configuration configuration = new Configuration();
        configuration.configure();
        configuration.addAnnotatedClass(Banque.class);
        configuration.addAnnotatedClass(Compte.class);
        configuration.addAnnotatedClass(Client.class);
        configuration.addAnnotatedClass(GuichetAutomatiqueBancaire.class);
        configuration.addAnnotatedClass(CompteClient.class);
        configuration.addAnnotatedClass(CarteBancaire.class);
        configuration.addAnnotatedClass(CompteCarteBancaire.class);
        configuration.addAnnotatedClass(InfoJournalTransaction.class);

        this.serviceRegistry =
            new StandardServiceRegistryBuilder().applySettings(configuration.getProperties())
                .build();

        return configuration.buildSessionFactory(this.serviceRegistry);

    }
}
