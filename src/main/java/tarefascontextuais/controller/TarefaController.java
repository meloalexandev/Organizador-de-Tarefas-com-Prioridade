package tarefascontextuais.controller;

import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import tarefascontextuais.dto.TarefaRequest;
import tarefascontextuais.dto.TarefaResponse;
import tarefascontextuais.service.TarefaService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/tarefas")
@RequiredArgsConstructor
public class TarefaController {
    private final TarefaService service;

    @PostMapping
    public TarefaResponse criar(@RequestBody @Valid TarefaRequest req) {
        return service.criar(req);
    }

    @GetMapping
    public List<TarefaResponse> listar() {
        return service.listarAtivas();
    }

    @GetMapping("/semana")
    public List<TarefaResponse> listarSemana() {
        return service.listarSemanaAtual();
    }

    @PostMapping("/{id}/arquivar")
    public void arquivar(@PathVariable Long id) {
        service.arquivar(id);
    }
}

