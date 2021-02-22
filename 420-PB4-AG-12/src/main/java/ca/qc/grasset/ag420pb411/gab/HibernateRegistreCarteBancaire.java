package ca.qc.grasset.ag420pb411.gab;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public final class HibernateRegistreCarteBancaire
    implements RegistreCarteBancaire {

    private final Session session;

    public HibernateRegistreCarteBancaire(final Session session_) {

        this.session = session_;
    }

    public CarteBancaire ajouter(
        final CarteBancaire carteBancaire_) {

        Transaction transaction = this.session.beginTransaction();
        Long pkid = (Long) this.session.save(carteBancaire_);
        transaction.commit();

        return CarteBancaire.builder()
            .pkid(pkid)
            .build();
    }

    public void effacer(
        final CarteBancaire carteBancaire_) {

        Transaction transaction = this.session.beginTransaction();
        this.session.delete(carteBancaire_);
        transaction.commit();

    }

    public List<CarteBancaire> obtenir() {

        CriteriaBuilder criteriaBuilder = this.session.getCriteriaBuilder();

        CriteriaQuery<CarteBancaire> criteriaQuery =
            criteriaBuilder.createQuery(CarteBancaire.class);

        Root<CarteBancaire> root = criteriaQuery.from(CarteBancaire.class);

        criteriaQuery.select(root);

        Query<CarteBancaire> query = this.session.createQuery(criteriaQuery);

        return query.getResultList();
    }

    @Override
    public CarteBancaire obtenir(
        final CarteBancaire carteBancaire_) {

        return this.session.get(CarteBancaire.class, carteBancaire_.getPkid());

    }

}
