package ca.qc.grasset.ag420pb411.gab;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(builderClassName = "Builder")
@Entity
@Table(name = "banques")
@AllArgsConstructor
public final class Banque
    implements Serializable {

    private static final long serialVersionUID = -5626156282910301136L;

    @Column(name = "code")
    private String idBanque;

    @Column(name = "nom")
    private String nomBanque;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pkid")
    private Long pkid;

    public Banque() {

        super();
    }

}
