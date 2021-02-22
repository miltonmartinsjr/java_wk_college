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
@Table(name = "comptes")
@AllArgsConstructor
public final class Compte
    implements Serializable {

    private static final long serialVersionUID = 147880837499149555L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pkid")
    private Long pkid;

    @Column(name = "type")
    private String type;

    public Compte() {

        super();
    }
}
