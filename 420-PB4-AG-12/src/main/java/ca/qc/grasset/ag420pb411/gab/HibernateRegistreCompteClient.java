package ca.qc.grasset.ag420pb411.gab;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public final class HibernateRegistreCompteClient {

    private final Session session;

    public HibernateRegistreCompteClient(final Session session_) {

        this.session = session_;
    }

    public CompteClient ajouter(
        final CompteClient compteClient_) {

        Transaction transaction = this.session.beginTransaction();
        Long pkid = (Long) this.session.save(compteClient_);
        transaction.commit();

        return CompteClient.builder()
            .pkid(pkid)
            .build();
    }

    public void effacer(
        final CompteClient compteClient_) {

        Transaction transaction = this.session.beginTransaction();
        this.session.delete(compteClient_);
        transaction.commit();

    }

    public List<CompteClient> obtenir() {

        CriteriaBuilder criteriaBuilder = this.session.getCriteriaBuilder();

        CriteriaQuery<CompteClient> criteriaQuery = criteriaBuilder.createQuery(CompteClient.class);

        Root<CompteClient> root = criteriaQuery.from(CompteClient.class);

        criteriaQuery.select(root);

        Query<CompteClient> query = this.session.createQuery(criteriaQuery);

        return query.getResultList();
    }

    public CompteClient obtenir(
        final CompteClient compteClient_) {

        return this.session.get(CompteClient.class, compteClient_.getPkid());

    }

}
