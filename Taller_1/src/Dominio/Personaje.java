package Dominio;


import Logica.ListaSkins;


public class Personaje {
    private String nombrePersonaje;
    private String rol;
    private double recaudacion;
    private ListaSkins listaSkins;

    public Personaje(String nombrePersonaje, String rol) {
        this.nombrePersonaje = nombrePersonaje;
        this.rol = rol;
        listaSkins = new ListaSkins (250);
        
    }

    public String getNombrePersonaje() {
        return nombrePersonaje;
    }

    public void setNombrePersonaje(String nombrePersonaje) {
        this.nombrePersonaje = nombrePersonaje;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public double getRecaudacion() {
        return recaudacion;
    }

    public void setRecaudacion(double recaudacion) {
        this.recaudacion = recaudacion;
    }

    public ListaSkins getListaSkins() {
        return listaSkins;
    }
    
    
    
    
}
