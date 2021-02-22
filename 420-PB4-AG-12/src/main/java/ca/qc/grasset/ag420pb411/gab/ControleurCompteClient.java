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
public final class ControleurCompteClient {

    public ControleurCompteClient() {

        super();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/compteClient")
    CompteClient ajouter(
        @RequestBody final CompteClient compteClient_) {

        HibernateConfigurator hibernateConfigurator = new HibernateConfigurator();
        try (SessionFactory sessionFactory = hibernateConfigurator.invoke()) {

            try (Session session = sessionFactory.openSession()) {

                HibernateRegistreCompteClient hibernateRegistreCompteClient =
                    new HibernateRegistreCompteClient(session);

                return hibernateRegistreCompteClient.ajouter(compteClient_);
            } catch (Exception exception) {
                throw new RuntimeException(exception);
            }
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/compteClient/{id}")
    void effacer(
        @PathVariable("id") final Long pkid_) {

        HibernateConfigurator hibernateConfigurator = new HibernateConfigurator();
        try (SessionFactory sessionFactory = hibernateConfigurator.invoke()) {

            try (Session session = sessionFactory.openSession()) {

                HibernateRegistreCompteClient hibernateRegistreCompteClient =
                    new HibernateRegistreCompteClient(session);

                hibernateRegistreCompteClient.effacer(
                    CompteClient.builder()
                        .pkid(pkid_)
                        .build());
            } catch (Exception exception) {
                throw new RuntimeException(exception);
            }
        }
    }

    @GetMapping("/compteClient/{id}")
    CompteClient obtenir(
        @PathVariable("id") final Long pkid_) {

        HibernateConfigurator hibernateConfigurator = new HibernateConfigurator();
        try (SessionFactory sessionFactory = hibernateConfigurator.invoke()) {

            try (Session session = sessionFactory.openSession()) {

                HibernateRegistreCompteClient hibernateRegistreCompteClient =
                    new HibernateRegistreCompteClient(session);

                CompteClient compteClient =
                    hibernateRegistreCompteClient.obtenir(
                        CompteClient.builder()
                            .pkid(pkid_)
                            .build());

                if (compteClient != null) {
                    return compteClient;
                }

                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");

            } catch (Exception exception) {
                throw new RuntimeException(exception);
            }
        }
    }
}
