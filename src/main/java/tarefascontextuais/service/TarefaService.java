package tarefascontextuais.service;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import org.springframework.stereotype.Service;
import tarefascontextuais.domain.Tarefa;
import tarefascontextuais.dto.TarefaRequest;
import tarefascontextuais.dto.TarefaResponse;
import tarefascontextuais.repository.TarefaRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TarefaService {
    private final TarefaRepository repo;
    private final PrioridadeContextual prioridade;
    private final ZoneId zona = ZoneId.of("America/Sao_Paulo");

    public TarefaResponse criar(TarefaRequest req) {
        Tarefa tarefa = new Tarefa();
        tarefa.setDescricao(req.getDescricao());
        tarefa.setPrazo(req.getPrazo());
        tarefa.setPrioridadeBase(req.getPrioridadeBase());
        tarefa.setArquivada(false);
        Tarefa salva = repo.save(tarefa);
        return mapToResponse(salva);
    }

    public List<TarefaResponse> listarAtivas() {
        return repo.findByArquivadaFalse().stream()
                .map(this::mapToResponse)
                .toList();
    }

    public List<TarefaResponse> listarSemanaAtual() {
        ZonedDateTime agora = ZonedDateTime.now(zona);
        ZonedDateTime fimSemana = agora.plusDays(7);
        return repo.findByArquivadaFalseAndPrazoBetween(agora.toLocalDateTime(), fimSemana.toLocalDateTime())
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    public void arquivar(Long id) {
        Tarefa tarefa = repo.findById(id).orElseThrow();
        tarefa.setArquivada(true);
        repo.save(tarefa);
    }

    private TarefaResponse mapToResponse(Tarefa tarefa) {
        int prioridadeCalculada = prioridade.calcular(tarefa, zona);
        return new TarefaResponse(
                tarefa.getId(),
                tarefa.getDescricao(),
                tarefa.getPrazo(),
                tarefa.getPrioridadeBase(),
                prioridadeCalculada
        );
    }
}
