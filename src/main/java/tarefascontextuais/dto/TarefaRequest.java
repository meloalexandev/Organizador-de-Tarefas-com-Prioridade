package tarefascontextuais.dto;

import lombok.Data;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
public class TarefaRequest {
    @NotBlank
    private String descricao;
    @FutureOrPresent
    private LocalDate prazo;
    @Min(1) @Max(5)
    private int prioridadeBase;
}