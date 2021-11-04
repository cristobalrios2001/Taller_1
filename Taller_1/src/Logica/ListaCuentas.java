package Logica;


import Dominio.Cuenta;


public class ListaCuentas {
    private Cuenta [] listaCuentas;
    private int cantCuentas;
    private int max;

    public ListaCuentas(int max) {
        this.cantCuentas = 0;
        this.max = max;
        listaCuentas = new Cuenta [max];
    }
    
    public boolean ingresar (Cuenta cuenta){
        if(cantCuentas < max){
            listaCuentas[cantCuentas] = cuenta;
            cantCuentas++;
            return true;
        }else{
            return false;
        }
    }
    
    public Cuenta buscarCuenta (String nombreCuenta)
    {
        int i;
        for (i = 0; i < cantCuentas; i++) {
            if(listaCuentas[i].getNombreCuenta().equals(nombreCuenta)){
                break;
            }
        }
        
        if(i==cantCuentas){
            return null;
        }else{
            return listaCuentas[i];
        }
    }
}
