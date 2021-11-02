package Dominio;


import Logica.ListaSkins;


public class Personaje {
    private String nombrePersonaje;
    private String rol;
    private int recaudacion;
    private ListaSkins listaSkins;

    public Personaje(String nombrePersonaje, String rol) {
        this.nombrePersonaje = nombrePersonaje;
        this.rol = rol;
        listaSkins = new ListaSkins (250);
        
    }
    
    
    
}
