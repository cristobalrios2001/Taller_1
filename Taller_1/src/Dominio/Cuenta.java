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
    private double recaudacionCta; //nueva variable
    private boolean estadoCuenta; // nueva variable
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
        this.recaudacionCta = recaudacionCta;
        estadoCuenta = true;
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

    public int getCantRP() {
        return cantRP;
    }

    public double getRecaudacionCta() {
        return recaudacionCta;
    }

    public void setRecaudacionCta(int recaudacionCta) {
        this.recaudacionCta = recaudacionCta;
    }

    public int getNivelCuenta() {
        return nivelCuenta;
    }

    public void setNivelCuenta(int nivelCuenta) {
        this.nivelCuenta = nivelCuenta;
    }

    public boolean getEstadoCuenta() {
        return estadoCuenta;
    }

    public void setEstadoCuenta(boolean estadoCuenta) {
        this.estadoCuenta = estadoCuenta;
    }
    
    

    public void setListaPersonajes(ListaPersonajes listaPersonajes) {
        this.listaPersonajes = listaPersonajes;
    }

    public void setListaCuentas(ListaCuentas listaCuentas) {
        this.listaCuentas = listaCuentas;
    }
    
    
    
}
