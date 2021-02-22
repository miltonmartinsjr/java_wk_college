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
public final class ControleurJournalTransaction {

    public ControleurJournalTransaction() {

        super();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/journalTransaction")
    InfoJournalTransaction ajouter(
        @RequestBody final InfoJournalTransaction infoJournalTransaction_) {

        HibernateConfigurator hibernateConfigurator = new HibernateConfigurator();
        try (SessionFactory sessionFactory = hibernateConfigurator.invoke()) {

            try (Session session = sessionFactory.openSession()) {

                HibernateJournalTransaction hibernateJournalTransaction =
                    new HibernateJournalTransaction(session);

                return hibernateJournalTransaction.ajouter(infoJournalTransaction_);
            } catch (Exception exception) {
                throw new RuntimeException(exception);
            }
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/journalTransaction/{id}")
    void effacer(
        @PathVariable("id") final Long pkid_) {

        HibernateConfigurator hibernateConfigurator = new HibernateConfigurator();
        try (SessionFactory sessionFactory = hibernateConfigurator.invoke()) {

            try (Session session = sessionFactory.openSession()) {

                HibernateJournalTransaction hibernateJournalTransaction =
                    new HibernateJournalTransaction(session);

                hibernateJournalTransaction.effacer(
                    InfoJournalTransaction.builder()
                        .pkid(pkid_)
                        .build());
            } catch (Exception exception) {
                throw new RuntimeException(exception);
            }
        }
    }

    @GetMapping("/journalTransaction/{id}")
    InfoJournalTransaction obtenir(
        @PathVariable("id") final Long pkid_) {

        HibernateConfigurator hibernateConfigurator = new HibernateConfigurator();
        try (SessionFactory sessionFactory = hibernateConfigurator.invoke()) {

            try (Session session = sessionFactory.openSession()) {

                HibernateJournalTransaction hibernateJournalTransaction =
                    new HibernateJournalTransaction(session);

                InfoJournalTransaction infoJournalTransaction =
                    hibernateJournalTransaction.obtenir(
                        InfoJournalTransaction.builder()
                            .pkid(pkid_)
                            .build());

                if (infoJournalTransaction != null) {
                    return infoJournalTransaction;
                }

                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");

            } catch (Exception exception) {
                throw new RuntimeException(exception);
            }
        }
    }
}
