package ca.qc.grasset.ag420pb412B.tp03.process;

import ca.qc.grasset.ag420pb412B.tp03.domain.OffreDeCours;
import ca.qc.grasset.ag420pb412B.tp03.repository.OffreDeCoursRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
public final class MediateurAnnulationOffreDeCours {

    @SuppressWarnings("unused")
    private OffreDeCoursRepository offreDeCoursRepository;

    public MediateurAnnulationOffreDeCours() {

        super();
    }

    public void executer(
        final OffreDeCours offreDeCours_) {

        throw new UnsupportedOperationException(offreDeCours_.toString());
    }
}
