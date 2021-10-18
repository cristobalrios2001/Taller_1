
public class Cuenta {
    private String nombreCuenta;
    private String contraseña;
    private String nick;
    private int nivelCuenta;
    private int cantRP;
    private String region;
    private ListaSkins listaSkins;
    private ListaPersonajes listaPersonajes;
    private ListaCuentas listaCuentas;

    public Cuenta(String nombreCuenta, String contraseña, String nick, int nivelCuenta, int cantRP) {
        this.nombreCuenta = nombreCuenta;
        this.contraseña = contraseña;
        this.nick = nick;
        this.nivelCuenta = nivelCuenta;
        this.cantRP = cantRP;
        listaCuentas = new ListaCuentas(250);
        listaPersonajes = new ListaPersonajes(155);
        listaSkins = new ListaSkins(250);
    }

    public String getNombreCuenta() {
        return nombreCuenta;
    }

    public String getContraseña() {
        return contraseña;
    }

    public String getNick() {
        return nick;
    }

    public ListaSkins getListaSkins() {
        return listaSkins;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void setCantRP(int cantRP) {
        this.cantRP = cantRP;
    }
    
    
    
}
