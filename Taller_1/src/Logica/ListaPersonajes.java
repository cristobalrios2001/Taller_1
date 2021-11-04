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
        if(cantPersonajes<max){
            listaPersonajes[cantPersonajes] = personaje;
            cantPersonajes++;
            return true;
        }else{
            return false;
        }
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
    
    
}
