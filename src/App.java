import java.time.LocalDate;

public class App {
    public static void main(String[] args) {

        Conto conto = new Conto("Pippo Franchini", LocalDate.of(2021, 4, 5), 0.07);

        System.out.println("*********************");
        System.out.println();

        System.out.println(conto.toString());
        conto.operazione(350, LocalDate.of(2021, 6, 18), "versamento", "");
        conto.operazione(1130, LocalDate.of(2021, 7, 3), "prelievo", "ho prelevato contante");
        conto.operazione(7340, LocalDate.of(2021, 11, 30), "versamento", "versati i proventi delle vendite");
        System.out.println(conto.toString());

        System.out.println();
        System.out.println("*********************");
    }
}