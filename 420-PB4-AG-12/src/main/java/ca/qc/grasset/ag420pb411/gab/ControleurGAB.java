package ca.qc.grasset.ag420pb411.gab;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public final class ControleurGAB {

    public ControleurGAB() {

        super();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/gab")
    GuichetAutomatiqueBancaire ajouter(
        @RequestBody final GuichetAutomatiqueBancaire guichetAutomatiqueBancaire_) {

        HibernateConfigurator hibernateConfigurator = new HibernateConfigurator();
        try (SessionFactory sessionFactory = hibernateConfigurator.invoke()) {

            try (Session session = sessionFactory.openSession()) {

                HibernateRegistreGAB hibernateRegistreGAB = new HibernateRegistreGAB(session);

                return hibernateRegistreGAB.ajouter(guichetAutomatiqueBancaire_);
            } catch (Exception exception) {
                throw new RuntimeException(exception);
            }
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/gab/{id}")
    void effacer(
        @PathVariable("id") final Long pkid_) {

        HibernateConfigurator hibernateConfigurator = new HibernateConfigurator();
        try (SessionFactory sessionFactory = hibernateConfigurator.invoke()) {

            try (Session session = sessionFactory.openSession()) {

                HibernateRegistreGAB hibernateRegistreGAB = new HibernateRegistreGAB(session);

                hibernateRegistreGAB.effacer(
                    GuichetAutomatiqueBancaire.builder()
                        .pkid(pkid_)
                        .build());
            } catch (Exception exception) {
                throw new RuntimeException(exception);
            }
        }
    }

    @GetMapping("/gab/{id}")
    GuichetAutomatiqueBancaire obtenir(
        @PathVariable("id") final Long pkid_) {

        HibernateConfigurator hibernateConfigurator = new HibernateConfigurator();
        try (SessionFactory sessionFactory = hibernateConfigurator.invoke()) {

            try (Session session = sessionFactory.openSession()) {

                HibernateRegistreGAB hibernateRegistreGAB = new HibernateRegistreGAB(session);

                GuichetAutomatiqueBancaire guichetAutomatiqueBancaire =
                    hibernateRegistreGAB.obtenir(
                        GuichetAutomatiqueBancaire.builder()
                            .pkid(pkid_)
                            .build());

                if (guichetAutomatiqueBancaire != null) {
                    return guichetAutomatiqueBancaire;
                }

                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");

            } catch (Exception exception) {
                throw new RuntimeException(exception);
            }
        }
    }
}
