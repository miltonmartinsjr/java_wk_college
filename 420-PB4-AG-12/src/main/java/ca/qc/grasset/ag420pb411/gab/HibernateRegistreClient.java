package ca.qc.grasset.ag420pb411.gab;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public final class HibernateRegistreClient {

    private final Session session;

    public HibernateRegistreClient(final Session session_) {

        this.session = session_;
    }

    public Client ajouter(
        final Client client_) {

        Transaction transaction = this.session.beginTransaction();
        Long pkid = (Long) this.session.save(client_);
        transaction.commit();

        return Client.builder()
            .pkid(pkid)
            .build();
    }

    public void effacer(
        final Client client_) {

        Transaction transaction = this.session.beginTransaction();
        this.session.delete(client_);
        transaction.commit();

    }

    public List<Client> obtenir() {

        CriteriaBuilder criteriaBuilder = this.session.getCriteriaBuilder();

        CriteriaQuery<Client> criteriaQuery = criteriaBuilder.createQuery(Client.class);

        Root<Client> root = criteriaQuery.from(Client.class);

        criteriaQuery.select(root);

        Query<Client> query = this.session.createQuery(criteriaQuery);

        return query.getResultList();
    }

    public Client obtenir(
        final Client client_) {

        return this.session.get(Client.class, client_.getPkid());

    }

}
