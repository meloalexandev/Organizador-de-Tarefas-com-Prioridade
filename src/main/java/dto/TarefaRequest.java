package dto;

public class TarefaRequest {   @NotBlank String descricao,
    @FutureOrPresent LocalDate prazo,
    @Min(1) @Max(5) int prioridadeBase

}



@Service
public class TarefaService {
    private final TarefaRepository repo;
    private final PrioridadeContextual prioridade;
    private final ZoneId zona = ZoneId.of("America/Sao_Paulo");

    public TarefaResponse criar(TarefaRequest req) { ... }
    public List<TarefaResponse> listarAtivas() { ... }
    public List<TarefaResponse> listarSemanaAtual() { ... }
    public void arquivar(Long id) { ... }
}