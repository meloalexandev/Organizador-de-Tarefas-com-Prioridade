package tarefascontextuais.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class TarefaResponse {
    private Long id;
    private String descricao;
    private LocalDate prazo;
    private int prioridadeBase;
    private int prioridadeCalculada;

    public TarefaResponse(Long id, String descricao, LocalDate prazo, int prioridadeBase, int prioridadeCalculada) {
        this.id = id;
        this.descricao = descricao;
        this.prazo = prazo;
        this.prioridadeBase = prioridadeBase;
        this.prioridadeCalculada = prioridadeCalculada;
    }
}