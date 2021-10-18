
public class ListaPersonajes {
    private Personaje [] listaPersonajes;
    private int cantPersonajes;
    private int max;

    public ListaPersonajes(int max) {
        this.cantPersonajes = 0;
        this.max = max;
        listaPersonajes = new Personaje[max];
    }
}
