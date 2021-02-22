package ca.qc.grasset.ag420pb412B.tp03.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ca.qc.grasset.ag420pb412B.tp03.domain.Departement;

@Repository
public interface DepartementRepository
    extends JpaRepository<Departement, Long> {

    // JPA Repository
}
