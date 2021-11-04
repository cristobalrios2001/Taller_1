/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Dominio.*;

public class SistemaSkinShopImpl implements SistemaSkinShop {
    private ListaCuentas listaCuentas;
    private ListaPersonajes listaPersonajes;
    private ListaSkins listaSkins;
    
   
    @Override
    public boolean agregarPersonaje(String nombre, String rol)
    {
        Personaje personaje = new Personaje(nombre,rol);
        boolean ingreso = listaPersonajes.ingresarPersonaje(personaje);
        
        return ingreso;
    }
    
    public boolean agregarSkin (String nombre, String calidad)
    {
        Skin skin = new Skin(nombre, calidad);
        boolean ingreso = listaSkins.ingresarSkin(skin);
        
        return ingreso;
    }
    
    @Override
    public void asociarPersonajeSkin(String nombrePersonaje, String nombreSkin)
    {
        Skin skin = listaSkins.buscarSkin(nombreSkin);
        Personaje personaje = listaPersonajes.buscarPersonaje(nombrePersonaje);
        
        if(skin != null && personaje != null){
            boolean ingreso = personaje.getListaSkins().ingresarSkin(skin);
        }else{
            throw new NullPointerException("No existe personaje y/o skin");
        }
    }
    
    public boolean agregarCuenta(String nombreCuenta, String contraseña, String nick,int nivel, int rp, String region)
    {
        Cuenta cuenta = new Cuenta(nombreCuenta,contraseña,nick,nivel,rp,region);
        
        boolean ingreso = listaCuentas.ingresar(cuenta);
        return ingreso;
    }
    
    public void asociarPersonajeCuenta(String nickCuenta, String nombrePersonaje)
    {
        Cuenta cuenta = listaCuentas.buscarCuenta(nickCuenta);
        Personaje personaje = listaPersonajes.buscarPersonaje(nombrePersonaje);
        
        if(cuenta != null && personaje != null)
        {
            boolean ingreso = cuenta.getListaPersojanes().ingresarPersonaje(personaje);
        }else{
            throw new NullPointerException ("No existe Cuenta y/o personaje");
        }
    }
    
    public void agregarSkinACuenta(String nombreSkin, String nombreCuenta)
    {
        Cuenta cuenta = listaCuentas.buscarCuenta(nombreCuenta);
        Skin skin = listaSkins.buscarSkin(nombreSkin);
        
        if(cuenta != null && skin != null)
        {
            boolean ingreso = cuenta.getListaSkins().ingresarSkin(skin);
        }else{
            throw new NullPointerException ("No existe Cuenta y/o skin");
        }
    }
    
    public  iniciarSesion(String nombreCuenta, String contraseña)
    {
    
    }
    
    public  comprarSkin (String nombrePersonaje, String nombreSkin)
    {
    
    }
    
    public  comprarPersonaje (String nombrePersonaje)
    {
    
    }
    
    public  mostrarSkinsDisponibles(String nombreCuenta)
    {
    
    }
    
    public  desplegarInventario (String nombreCuenta)
    {
    
    }
    
    public  recargarSaldo(String nombreCuenta)
    {
    
    }
    
    public  mostrarDatos(String nombreCuenta)
    {
    
    }
    
    public  cambiarContraseña(String contraseñaAntigua1, String contraseñaAntigua2, String nuevaContraseña)
    {
    
    }
    
    public  recaudacionPorRol ()
    {
    
    }
    
    public  recaudacionPorRegion ()
    {
    
    }
    
    public  recaudacionPorPersonaje()
    {
    
    }
    
    public  bloquearCuenta(String nick)
    {
    
    }
    
    public  desplegarCuentasNivel()
    {
    
    }
    
    public  ingresarPersonajesAdmin(String nombrePersonaje, String rol)
    {
    
    }

    
    public void asociarPersonajeCuenta(Cuenta cuenta, Personaje personaje) {
        
    }
}
