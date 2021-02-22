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
public final class ControleurCompteCarteBancaire {

    public ControleurCompteCarteBancaire() {

        super();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/compteCarteBancaire")
    CompteCarteBancaire ajouter(
        @RequestBody final CompteCarteBancaire compteCarteBancaire_) {

        HibernateConfigurator hibernateConfigurator = new HibernateConfigurator();
        try (SessionFactory sessionFactory = hibernateConfigurator.invoke()) {

            try (Session session = sessionFactory.openSession()) {

                HibernateRegistreCompteCarteBancaire hibernateRegistreCompteCarteBancaire =
                    new HibernateRegistreCompteCarteBancaire(session);

                return hibernateRegistreCompteCarteBancaire.ajouter(compteCarteBancaire_);
            } catch (Exception exception) {
                throw new RuntimeException(exception);
            }
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/compteCarteBancaire/{id}")
    void effacer(
        @PathVariable("id") final Long pkid_) {

        HibernateConfigurator hibernateConfigurator = new HibernateConfigurator();
        try (SessionFactory sessionFactory = hibernateConfigurator.invoke()) {

            try (Session session = sessionFactory.openSession()) {

                HibernateRegistreCompteCarteBancaire hibernateRegistreCompteCarteBancaire =
                    new HibernateRegistreCompteCarteBancaire(session);

                hibernateRegistreCompteCarteBancaire.effacer(
                    CompteCarteBancaire.builder()
                        .pkid(pkid_)
                        .build());
            } catch (Exception exception) {
                throw new RuntimeException(exception);
            }
        }
    }

    @GetMapping("/compteCarteBancaire/{id}")
    CompteCarteBancaire obtenir(
        @PathVariable("id") final Long pkid_) {

        HibernateConfigurator hibernateConfigurator = new HibernateConfigurator();
        try (SessionFactory sessionFactory = hibernateConfigurator.invoke()) {

            try (Session session = sessionFactory.openSession()) {

                HibernateRegistreCompteCarteBancaire hibernateRegistreCompteCarteBancaire =
                    new HibernateRegistreCompteCarteBancaire(session);

                CompteCarteBancaire compteCarteBancaire =
                    hibernateRegistreCompteCarteBancaire.obtenir(
                        CompteCarteBancaire.builder()
                            .pkid(pkid_)
                            .build());

                if (compteCarteBancaire != null) {
                    return compteCarteBancaire;
                }

                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");

            } catch (Exception exception) {
                throw new RuntimeException(exception);
            }
        }
    }
}
