package catalogo;

public class Main {
    public static void main(String[] args) {
        Articolo pane = new Articolo("pane", 1D);
        Articolo uva = new Articolo("uva", 1.5);
        Articolo uova = new Articolo("uova", 2D);

        Catalogo<Articolo> cibo = new Catalogo<Articolo>("cibo");
        cibo.addArticolo(pane);
        cibo.addArticolo(uva);
        cibo.addArticolo(uova);

        System.out.println(cibo + "\n");
        System.out.println(cibo.getArticoliSottoPrezzo(10D));

        // --------------------------------------------------------

        Mobile sedia = new Mobile("sedia", 9.99, 30, 100, 40);
        Mobile armadio = new Mobile("armadio", 899.99, 300, 250, 50);
        Mobile tavolo = new Mobile("tavolo", 119.99, 150, 120, 150);

        Catalogo<Mobile> casa = new Catalogo<Mobile>("casa");

        casa.addArticolo(sedia);
        casa.addArticolo(armadio);
        casa.addArticolo(tavolo);

        System.out.println(casa + "\n");

        System.out.println(sedia.scegliMobiliDaCatalogo(casa));

    }
}
