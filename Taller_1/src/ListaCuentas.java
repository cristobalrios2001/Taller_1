
public class ListaCuentas {
    private Cuenta [] listaCuentas;
    private int cantCuentas;
    private int max;

    public ListaCuentas(int max) {
        this.cantCuentas = 0;
        this.max = max;
        listaCuentas = new Cuenta [max];
    }
}
