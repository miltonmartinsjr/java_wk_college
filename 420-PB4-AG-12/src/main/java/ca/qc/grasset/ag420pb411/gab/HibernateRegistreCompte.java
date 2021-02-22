package ca.qc.grasset.ag420pb411.gab;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public final class HibernateRegistreCompte {

    private final Session session;

    public HibernateRegistreCompte(final Session session_) {

        this.session = session_;
    }

    public Compte ajouter(
        final Compte compte_) {

        Transaction transaction = this.session.beginTransaction();
        Long pkid = (Long) this.session.save(compte_);
        transaction.commit();

        return Compte.builder()
            .pkid(pkid)
            .build();
    }

    public void effacer(
        final Compte compte_) {

        Transaction transaction = this.session.beginTransaction();
        this.session.delete(compte_);
        transaction.commit();

    }

    public List<Compte> obtenir() {

        CriteriaBuilder criteriaBuilder = this.session.getCriteriaBuilder();

        CriteriaQuery<Compte> criteriaQuery = criteriaBuilder.createQuery(Compte.class);

        Root<Compte> root = criteriaQuery.from(Compte.class);

        criteriaQuery.select(root);

        Query<Compte> query = this.session.createQuery(criteriaQuery);

        return query.getResultList();
    }

    public Compte obtenir(
        final Compte compte_) {

        return this.session.get(Compte.class, compte_.getPkid());

    }

}
