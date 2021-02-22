package ca.qc.grasset.ag420pb411.gab;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public final class HibernateRegistreGAB {

    private final Session session;

    public HibernateRegistreGAB(final Session session_) {

        this.session = session_;
    }

    public GuichetAutomatiqueBancaire ajouter(
        final GuichetAutomatiqueBancaire guichetAutomatiqueBancaire_) {

        Transaction transaction = this.session.beginTransaction();
        Long pkid = (Long) this.session.save(guichetAutomatiqueBancaire_);
        transaction.commit();

        return GuichetAutomatiqueBancaire.builder()
            .pkid(pkid)
            .build();
    }

    public void effacer(
        final GuichetAutomatiqueBancaire guichetAutomatiqueBancaire_) {

        Transaction transaction = this.session.beginTransaction();
        this.session.delete(guichetAutomatiqueBancaire_);
        transaction.commit();

    }

    public List<GuichetAutomatiqueBancaire> obtenir() {

        CriteriaBuilder criteriaBuilder = this.session.getCriteriaBuilder();

        CriteriaQuery<GuichetAutomatiqueBancaire> criteriaQuery =
            criteriaBuilder.createQuery(GuichetAutomatiqueBancaire.class);

        Root<GuichetAutomatiqueBancaire> root =
            criteriaQuery.from(GuichetAutomatiqueBancaire.class);

        criteriaQuery.select(root);

        Query<GuichetAutomatiqueBancaire> query = this.session.createQuery(criteriaQuery);

        return query.getResultList();
    }

    public GuichetAutomatiqueBancaire obtenir(
        final GuichetAutomatiqueBancaire guichetAutomatiqueBancaire_) {

        return this.session
            .get(GuichetAutomatiqueBancaire.class, guichetAutomatiqueBancaire_.getPkid());

    }

}
