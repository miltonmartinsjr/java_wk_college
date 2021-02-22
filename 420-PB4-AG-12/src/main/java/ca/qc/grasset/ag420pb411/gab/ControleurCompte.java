package ca.qc.grasset.ag420pb411.gab;

import java.util.List;

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
public final class ControleurCompte {

    public ControleurCompte() {

        super();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/compte")
    Compte ajouter(
        @RequestBody final Compte compte_) {

        HibernateConfigurator hibernateConfigurator = new HibernateConfigurator();
        try (SessionFactory sessionFactory = hibernateConfigurator.invoke()) {

            try (Session session = sessionFactory.openSession()) {

                HibernateRegistreCompte hibernateRegistreCompte =
                    new HibernateRegistreCompte(session);

                return hibernateRegistreCompte.ajouter(compte_);
            } catch (Exception exception) {
                throw new RuntimeException(exception);
            }
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/compte/{id}")
    void effacer(
        @PathVariable("id") final Long pkid_) {

        HibernateConfigurator hibernateConfigurator = new HibernateConfigurator();
        try (SessionFactory sessionFactory = hibernateConfigurator.invoke()) {

            try (Session session = sessionFactory.openSession()) {

                HibernateRegistreCompte hibernateRegistreCompte =
                    new HibernateRegistreCompte(session);

                hibernateRegistreCompte.effacer(
                    Compte.builder()
                        .pkid(pkid_)
                        .build());
            } catch (Exception exception) {
                throw new RuntimeException(exception);
            }
        }
    }

    @GetMapping("/comptes")
    List<Compte> obtenir() {

        HibernateConfigurator hibernateConfigurator = new HibernateConfigurator();
        try (SessionFactory sessionFactory = hibernateConfigurator.invoke()) {

            try (Session session = sessionFactory.openSession()) {

                HibernateRegistreCompte hibernateRegistreCompte =
                    new HibernateRegistreCompte(session);

                return hibernateRegistreCompte.obtenir();
            } catch (Exception exception) {
                throw new RuntimeException(exception);
            }
        }
    }

    @GetMapping("/compte/{id}")
    Compte obtenir(
        @PathVariable("id") final Long pkid_) {

        HibernateConfigurator hibernateConfigurator = new HibernateConfigurator();
        try (SessionFactory sessionFactory = hibernateConfigurator.invoke()) {

            try (Session session = sessionFactory.openSession()) {

                HibernateRegistreCompte hibernateRegistreCompte =
                    new HibernateRegistreCompte(session);

                Compte compte =
                    hibernateRegistreCompte.obtenir(
                        Compte.builder()
                            .pkid(pkid_)
                            .build());

                if (compte != null) {
                    return compte;
                }

                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");

            } catch (Exception exception) {
                throw new RuntimeException(exception);
            }
        }
    }
}
