package controller;


    @RestController
    @RequestMapping("/api/tarefas")
    public class TarefaController {

        @PostMapping public TarefaResponse criar(@RequestBody @Valid TarefaRequest req) { ... }
        @GetMapping public List<TarefaResponse> listar() { ... }
        @GetMapping("/semana") public List<TarefaResponse> listarSemana() { ... }
        @PostMapping("/{id}/arquivar") public void arquivar(@PathVariable Long id) { ... }
    }

