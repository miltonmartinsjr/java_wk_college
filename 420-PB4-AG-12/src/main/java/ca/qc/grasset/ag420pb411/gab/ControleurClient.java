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
public final class ControleurClient {

    public ControleurClient() {

        super();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/client")
    Client ajouter(
        @RequestBody final Client client_) {

        HibernateConfigurator hibernateConfigurator = new HibernateConfigurator();
        try (SessionFactory sessionFactory = hibernateConfigurator.invoke()) {

            try (Session session = sessionFactory.openSession()) {

                HibernateRegistreClient hibernateRegistreClient =
                    new HibernateRegistreClient(session);

                return hibernateRegistreClient.ajouter(client_);
            } catch (Exception exception) {
                throw new RuntimeException(exception);
            }
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/client/{id}")
    void effacer(
        @PathVariable("id") final Long pkid_) {

        HibernateConfigurator hibernateConfigurator = new HibernateConfigurator();
        try (SessionFactory sessionFactory = hibernateConfigurator.invoke()) {

            try (Session session = sessionFactory.openSession()) {

                HibernateRegistreClient hibernateRegistreClient =
                    new HibernateRegistreClient(session);

                hibernateRegistreClient.effacer(
                    Client.builder()
                        .pkid(pkid_)
                        .build());
            } catch (Exception exception) {
                throw new RuntimeException(exception);
            }
        }
    }

    @GetMapping("/client/{id}")
    Client obtenir(
        @PathVariable("id") final Long pkid_) {

        HibernateConfigurator hibernateConfigurator = new HibernateConfigurator();
        try (SessionFactory sessionFactory = hibernateConfigurator.invoke()) {

            try (Session session = sessionFactory.openSession()) {

                HibernateRegistreClient hibernateRegistreClient =
                    new HibernateRegistreClient(session);

                Client client =
                    hibernateRegistreClient.obtenir(
                        Client.builder()
                            .pkid(pkid_)
                            .build());

                if (client != null) {
                    return client;
                }

                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");

            } catch (Exception exception) {
                throw new RuntimeException(exception);
            }
        }
    }
}
