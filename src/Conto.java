import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Conto {
    private String titolare;
    private LocalDate dataApertura;
    private double tassoInteresse;
    private double saldo;
    private List<Movimento> listaMovimenti;
    private List<PeriodoStatico> listaPeriodiStatici;
    private double interessiAnnoCorrente;

    public Conto (String titolare, LocalDate dataApertura, double tassoInteresse) {
        this.titolare = titolare;
        this.dataApertura = dataApertura;
        this.tassoInteresse = tassoInteresse;
        this.saldo = 0;
        this.interessiAnnoCorrente = 0;
        this.listaMovimenti = new ArrayList<>();
        this.listaPeriodiStatici = new ArrayList<>();
        this.operazione(1000, this.dataApertura, "versamento", "bonus apertura conto 1000€");
    }

    public void operazione(double importo, LocalDate dataOperazione, String tipoOperazione, String descrizioneOperazione) {
        if (importo > 0 && dataOperazione.getYear() == 2021 && dataOperazione.getDayOfYear() >= this.dataApertura.getDayOfYear() && tipoOperazione.equals("prelievo") || tipoOperazione.equals("versamento")) {
            
            if (tipoOperazione.equals("prelievo") && importo < this.saldo) {
                this.saldo -= importo;
            } else if (tipoOperazione.equals("versamento")) {
                this.saldo += importo;
            }

            Movimento movimento = new Movimento(tipoOperazione, dataOperazione, importo, this.saldo, descrizioneOperazione);
            this.listaMovimenti.add(movimento);
            System.out.println(movimento.toString());
            interessiParzialiPeriodoStatico();
        }
    }

    private void interessiParzialiPeriodoStatico() {

        if (this.listaMovimenti.size() > 1) {

            List<Integer> itemsNumeroGiorno = new ArrayList<>();

            for (Movimento item : this.listaMovimenti) {
                itemsNumeroGiorno.add(item.getData().getDayOfYear());
            }

            LocalDate dataOperazione = this.listaMovimenti.get(itemsNumeroGiorno.indexOf(Collections.max(itemsNumeroGiorno))).getData();
            
            itemsNumeroGiorno.remove(Collections.max(itemsNumeroGiorno));
            LocalDate dataOperazionePrecedente = this.listaMovimenti.get(itemsNumeroGiorno.indexOf(Collections.max(itemsNumeroGiorno))).getData();

            PeriodoStatico periodoStatico = new PeriodoStatico(dataOperazionePrecedente, dataOperazione, this.saldo, this.tassoInteresse);
            this.listaPeriodiStatici.add(periodoStatico);
            System.out.println(periodoStatico.toString());
            saldo += periodoStatico.getInteresseParzialeFinale();
        }
    }

    public String getTitolare() {
        return this.titolare;
    }

    public LocalDate getDataApertura() {
        return this.dataApertura;
    }

    public double getTassoInteresse() {
        return this.tassoInteresse;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public List<Movimento> getListaMovimenti() {
        return this.listaMovimenti;
    }

    public List<PeriodoStatico> getListaPeriodiStatici() {
        return this.listaPeriodiStatici;
    }

    public double getInteressiAnnoCorrente() {
        return this.interessiAnnoCorrente;
    }

    @Override
    public String toString() {
        return "Conto intestato a " + this.titolare + ", creato il " + this.dataApertura + ", con tasso d'interesse = " + (this.tassoInteresse * 100) + "% -> {Saldo disponibile: " + this.saldo + "€, interessi accumulati nell'anno corrente: " + this.interessiAnnoCorrente + "€}";
    }
}