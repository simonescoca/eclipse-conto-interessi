import java.time.LocalDate;

public class Movimento {
    private String tipo;
    private LocalDate data;
    private double importo;
    private double saldoPrecedente;
    private double saldoAggiornato;
    private String descrizioneOperazione;

    public Movimento (String tipo, LocalDate data, double importo, double saldoAggiornato, String descrizioneOperazione) {
        this.tipo = tipo;
        this.data = data;
        this.importo = importo;
        this.saldoAggiornato = saldoAggiornato;
        if (tipo.equals("prelievo")) {
            this.saldoPrecedente = this.saldoAggiornato + this.importo;
        } else if (tipo.equals("versamento")) {
            this.saldoPrecedente = this.saldoAggiornato - this.importo;
        }
        this.descrizioneOperazione = descrizioneOperazione;
    }

    public String getTipo() {
        return this.tipo;
    }

    public LocalDate getData() {
        return this.data;
    }

    public double getImporto() {
        return this.importo;
    }

    public double getSaldoPrecedente() {
        return this.saldoPrecedente;
    }

    public double getSaldoAggiornato() {
        return this.saldoAggiornato;
    }

    public String getDescrizioneOperazione() {
        return this.descrizioneOperazione;
    }

    @Override
    public String toString() {
        return "Movimento in data " + this.data +  ", Descrizione Operazione: " + this.descrizioneOperazione + " -> {Tipo: " + this.tipo + ", Importo: " + this.importo + "€, Saldo precedente: " + this.saldoPrecedente + "€, Saldo Aggiornato: " + this.saldoAggiornato + "€}";
    }
}