package ca.qc.grasset.ag420pb411.gab;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public final class HibernateJournalTransaction
    implements JournalTransaction {

    private final Session session;

    public HibernateJournalTransaction(final Session session_) {

        this.session = session_;
    }

    @Override
    public InfoJournalTransaction ajouter(
        final InfoJournalTransaction infoJournalTransaction_) {

        Transaction transaction = this.session.beginTransaction();
        Long pkid = (Long) this.session.save(infoJournalTransaction_);
        transaction.commit();

        return InfoJournalTransaction.builder()
            .pkid(pkid)
            .build();
    }

    public void effacer(
        final InfoJournalTransaction infoJournalTransaction_) {

        Transaction transaction = this.session.beginTransaction();
        this.session.delete(infoJournalTransaction_);
        transaction.commit();

    }

    public List<InfoJournalTransaction> obtenir() {

        CriteriaBuilder criteriaBuilder = this.session.getCriteriaBuilder();

        CriteriaQuery<InfoJournalTransaction> criteriaQuery =
            criteriaBuilder.createQuery(InfoJournalTransaction.class);

        Root<InfoJournalTransaction> root = criteriaQuery.from(InfoJournalTransaction.class);

        criteriaQuery.select(root);

        Query<InfoJournalTransaction> query = this.session.createQuery(criteriaQuery);

        return query.getResultList();
    }

    public InfoJournalTransaction obtenir(
        final InfoJournalTransaction infoJournalTransaction_) {

        return this.session.get(InfoJournalTransaction.class, infoJournalTransaction_.getPkid());

    }

}
