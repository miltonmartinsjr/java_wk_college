package ca.qc.grasset.ag420pb411.gab;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public final class HibernateRegistreBanque {

    private final Session session;

    public HibernateRegistreBanque(final Session session_) {

        this.session = session_;
    }

    public Banque ajouter(
        final Banque banque_) {

        Transaction transaction = this.session.beginTransaction();
        Long pkid = (Long) this.session.save(banque_);
        transaction.commit();

        return Banque.builder()
            .pkid(pkid)
            .build();
    }

    public void effacer(
        final Banque banque_) {

        Transaction transaction = this.session.beginTransaction();
        this.session.delete(banque_);
        transaction.commit();

    }

    public List<Banque> obtenir() {

        CriteriaBuilder criteriaBuilder = this.session.getCriteriaBuilder();

        CriteriaQuery<Banque> criteriaQuery = criteriaBuilder.createQuery(Banque.class);

        Root<Banque> root = criteriaQuery.from(Banque.class);

        criteriaQuery.select(root);

        Query<Banque> query = this.session.createQuery(criteriaQuery);

        return query.getResultList();
    }

    public Banque obtenir(
        final Banque banque_) {

        return this.session.get(Banque.class, banque_.getPkid());

    }

}
