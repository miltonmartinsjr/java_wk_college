package ca.qc.grasset.ag420pb411.gab;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(builderClassName = "Builder")
@Entity
@Table(name = "clients")
@AllArgsConstructor
public final class Client
    implements Serializable {

    private static final long serialVersionUID = -8775357380947828814L;

    @ManyToOne
    @JoinColumn(name = "banque_pkid")
    private Banque banque;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pkid")
    private Long pkid;

    public Client() {

        super();
    }
}
