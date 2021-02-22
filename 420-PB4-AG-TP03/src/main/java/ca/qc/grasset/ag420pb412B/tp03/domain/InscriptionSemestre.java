package ca.qc.grasset.ag420pb412B.tp03.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(builderClassName = "Builder")
@Entity
@Table(name = "inscription_semestres")
@AllArgsConstructor
public final class InscriptionSemestre
    implements Serializable {

    private static final long serialVersionUID = -5626156282910301136L;

    @OneToMany(mappedBy = "inscriptionSemestre")
    private Set<OffreDeCours> offreDeCours;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pkid")
    private Long pkid;

    @ManyToOne
    @JoinColumn(name = "semestre_pkid")
    private Semestre semestre;

    public InscriptionSemestre() {

        super();
    }

}
