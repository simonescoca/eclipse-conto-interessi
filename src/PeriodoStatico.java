import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class PeriodoStatico {
    private LocalDate dataInizio;
    private LocalDate dataFine;
    private long durataGG;
    private double saldoCorrente;
    private double tassoInteresse;
    private double interesseParzialeFinale;

    public PeriodoStatico (LocalDate dataInizio, LocalDate dataFine, double saldoCorrente, double tassoInteresse) {
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.durataGG = dataInizio.until(dataFine, ChronoUnit.DAYS);
        this.saldoCorrente = saldoCorrente;
        this.tassoInteresse = tassoInteresse;
        this.interesseParzialeFinale = this.saldoCorrente * (this.durataGG / 100.0) * this.tassoInteresse;
    }

    public LocalDate getDataInizio() {
        return this.dataInizio;
    }

    public LocalDate getDataFine() {
        return this.dataFine;
    }

    public long getDurataGG() {
        return this.durataGG;
    }

    public double getSaldoCorrente() {
        return this.saldoCorrente;
    }

    public double getTassoInteresse() {
        return this.tassoInteresse;
    }

    public double getInteresseParzialeFinale() {
        return this.interesseParzialeFinale;
    }

    @Override
    public String toString() {
        return "Periodo Statico dal " + this.dataInizio + " al " + this.dataFine + " -> {durata: " + this.durataGG + "gg, saldo: " + this.saldoCorrente + "€, tasso d'interesse: " + this.tassoInteresse * 100 + "%, interesse parziale finale: " + this.interesseParzialeFinale + "€}";
    }
}