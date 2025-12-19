package tarefascontextuais.service;

import org.springframework.stereotype.Component;
import tarefascontextuais.domain.Tarefa;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.Duration;

@Component
public class PrioridadeContextual {
    
    public int calcular(Tarefa tarefa, ZoneId zona) {
        int base = tarefa.getPrioridadeBase();
        LocalDate prazo = tarefa.getPrazo();
        int p = base;
        LocalDate hoje = LocalDate.now(zona);
        long dias = Duration.between(hoje.atStartOfDay(), prazo.atStartOfDay()).toDays();

        if (dias <= 2) p -= 1;
        int hora = LocalTime.now(zona).getHour();
        if (hora >= 6 && hora < 12) p -= 1;

        return Math.max(1, Math.min(5, p));
    }
}



