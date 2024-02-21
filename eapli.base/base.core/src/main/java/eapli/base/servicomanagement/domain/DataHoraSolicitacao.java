package eapli.base.servicomanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.time.LocalDateTime;

@Embeddable
public class DataHoraSolicitacao implements ValueObject {

    private LocalDateTime dataHoraSolicitacao;

    public DataHoraSolicitacao(LocalDateTime dataHoraSolicitacao) {
        this.dataHoraSolicitacao = dataHoraSolicitacao;
    }

    public DataHoraSolicitacao() {

    }

    public LocalDateTime dataHoraSolicitacao() {
        return dataHoraSolicitacao;
    }

    @Override
    public String toString() {
        return dataHoraSolicitacao.toString();
    }
}
