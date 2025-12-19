package tarefascontextuais.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tarefascontextuais.domain.Tarefa;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
    List<Tarefa> findByArquivadaFalse();
    List<Tarefa> findByArquivadaFalseAndPrazoBetween(LocalDateTime start, LocalDateTime end);
}
