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
public final class ControleurCarteBancaire {

    public ControleurCarteBancaire() {

        super();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/carteBancaire")
    CarteBancaire ajouter(
        @RequestBody final CarteBancaire carteBancaire_) {

        HibernateConfigurator hibernateConfigurator = new HibernateConfigurator();
        try (SessionFactory sessionFactory = hibernateConfigurator.invoke()) {

            try (Session session = sessionFactory.openSession()) {

                HibernateRegistreCarteBancaire hibernateRegistreCarteBancaire =
                    new HibernateRegistreCarteBancaire(session);

                return hibernateRegistreCarteBancaire.ajouter(carteBancaire_);
            } catch (Exception exception) {
                throw new RuntimeException(exception);
            }
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/carteBancaire/{id}")
    void effacer(
        @PathVariable("id") final Long pkid_) {

        HibernateConfigurator hibernateConfigurator = new HibernateConfigurator();
        try (SessionFactory sessionFactory = hibernateConfigurator.invoke()) {

            try (Session session = sessionFactory.openSession()) {

                HibernateRegistreCarteBancaire hibernateRegistreCarteBancaire =
                    new HibernateRegistreCarteBancaire(session);

                hibernateRegistreCarteBancaire.effacer(
                    CarteBancaire.builder()
                        .pkid(pkid_)
                        .build());
            } catch (Exception exception) {
                throw new RuntimeException(exception);
            }
        }
    }

    @GetMapping("/carteBancaire/{id}")
    CarteBancaire obtenir(
        @PathVariable("id") final Long pkid_) {

        HibernateConfigurator hibernateConfigurator = new HibernateConfigurator();
        try (SessionFactory sessionFactory = hibernateConfigurator.invoke()) {

            try (Session session = sessionFactory.openSession()) {

                HibernateRegistreCarteBancaire hibernateRegistreCarteBancaire =
                    new HibernateRegistreCarteBancaire(session);

                CarteBancaire carteBancaire =
                    hibernateRegistreCarteBancaire.obtenir(
                        CarteBancaire.builder()
                            .pkid(pkid_)
                            .build());

                if (carteBancaire != null) {
                    return carteBancaire;
                }

                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");

            } catch (Exception exception) {
                throw new RuntimeException(exception);
            }
        }
    }
}
