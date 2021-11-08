package Logica;

import Dominio.Personaje;


public class ListaPersonajes {
    private Personaje [] listaPersonajes;
    private int cantPersonajes;
    private int max;

    public ListaPersonajes(int max) {
        this.cantPersonajes = 0;
        this.max = max;
        listaPersonajes = new Personaje[max];
        
    }
    
    public boolean ingresarPersonaje(Personaje personaje)
    {
        boolean existe = false;
        for (int i = 0; i < cantPersonajes; i++) {
            if(listaPersonajes[i].equals(personaje)){
                existe = true;
            }
        }
        
        if(existe == false){
            if(cantPersonajes<max){
                listaPersonajes[cantPersonajes] = personaje;
                cantPersonajes++;
            return true;
            }
        }
        return false;
    }
    
    public Personaje buscarPersonaje (String nombrePersonaje)
    {
        int i;
        for (i = 0; i < cantPersonajes; i++) {
            if(listaPersonajes[i].getNombrePersonaje().equals(nombrePersonaje)){
                break;
            }
        }
        
        if(i==cantPersonajes){
            return null;
        }else{
            return listaPersonajes[i];
        }
    }

    public int getCantPersonajes() {
        return cantPersonajes;
    }

    public void setCantPersonajes(int cantPersonajes) {
        this.cantPersonajes = cantPersonajes;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }
    
    public Personaje getPersonajeI(int i){
        if(i>=0 && i< cantPersonajes){
            return listaPersonajes[i];
        }else{
            return null;
        }
    }
}
