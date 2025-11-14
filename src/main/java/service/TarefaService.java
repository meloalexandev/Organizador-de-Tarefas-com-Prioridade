package service;

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
