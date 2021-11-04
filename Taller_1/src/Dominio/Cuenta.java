package Dominio;

import Logica.ListaPersonajes;
import Logica.ListaCuentas;
import Logica.ListaSkins;


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

    public Cuenta(String nombreCuenta, String contraseña, String nick, int nivelCuenta, int cantRP, String region) {
        this.nombreCuenta = nombreCuenta;
        this.contraseña = contraseña;
        this.nick = nick;
        this.nivelCuenta = nivelCuenta;
        this.cantRP = cantRP;
        this.region = region;
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
    
    public ListaPersonajes getListaPersojanes() {
        return listaPersonajes;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void setCantRP(int cantRP) {
        this.cantRP = cantRP;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
    
    
    
}
