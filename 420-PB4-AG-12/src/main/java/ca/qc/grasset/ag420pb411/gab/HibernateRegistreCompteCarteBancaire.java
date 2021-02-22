package ca.qc.grasset.ag420pb411.gab;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public final class HibernateRegistreCompteCarteBancaire
    implements RegistreCompteCarteBancaire {

    private final Session session;

    public HibernateRegistreCompteCarteBancaire(final Session session_) {

        this.session = session_;
    }

    public CompteCarteBancaire ajouter(
        final CompteCarteBancaire compteCarteBancaire_) {

        Transaction transaction = this.session.beginTransaction();
        Long pkid = (Long) this.session.save(compteCarteBancaire_);
        transaction.commit();

        return CompteCarteBancaire.builder()
            .pkid(pkid)
            .build();
    }

    public void effacer(
        final CompteCarteBancaire compteCarteBancaire_) {

        Transaction transaction = this.session.beginTransaction();
        this.session.delete(compteCarteBancaire_);
        transaction.commit();

    }

    public List<CompteCarteBancaire> obtenir() {

        CriteriaBuilder criteriaBuilder = this.session.getCriteriaBuilder();

        CriteriaQuery<CompteCarteBancaire> criteriaQuery =
            criteriaBuilder.createQuery(CompteCarteBancaire.class);

        Root<CompteCarteBancaire> root = criteriaQuery.from(CompteCarteBancaire.class);

        criteriaQuery.select(root);

        Query<CompteCarteBancaire> query = this.session.createQuery(criteriaQuery);

        return query.getResultList();
    }

    @Override
    public List<CompteCarteBancaire> obtenir(
        final CarteBancaire carteBancaire_) {

        CriteriaBuilder criteriaBuilder = this.session.getCriteriaBuilder();

        CriteriaQuery<CompteCarteBancaire> criteriaQuery =
            criteriaBuilder.createQuery(CompteCarteBancaire.class);

        Root<CompteCarteBancaire> root = criteriaQuery.from(CompteCarteBancaire.class);

        criteriaQuery.select(root);

        Query<CompteCarteBancaire> query = this.session.createQuery(criteriaQuery);

        return query.getResultList();
    }

    public CompteCarteBancaire obtenir(
        final CompteCarteBancaire compteCarteBancaire_) {

        return this.session.get(CompteCarteBancaire.class, compteCarteBancaire_.getPkid());

    }

}
