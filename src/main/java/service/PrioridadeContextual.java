package service;



public class PrioridadeContextual {
        @Component
    public int calcular(int base, LocalDate prazo, ZoneId zona) {
        int p = base;
        LocalDate hoje = LocalDate.now(zona);
        long dias = Duration.between(hoje.atStartOfDay(), prazo.atStartOfDay()).toDays();

        if (dias <= 2) p -= 1;
        int hora = LocalTime.now(zona).getHour();
        if (hora >= 6 && hora < 12) p -= 1;

        return Math.max(1, Math.min(5, p));
    }
}
}



