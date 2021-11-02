package Logica;


import Dominio.Skin;


public class ListaSkins {
    private Skin [] listaSkins;
    private int cantSkins;
    private int max;

    public ListaSkins(int max) {
        this.cantSkins = 0;
        this.max = max;
        listaSkins = new Skin[max];
    }
    
    
}
