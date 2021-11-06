/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Dominio.Cuenta;
import Dominio.Personaje;

/**
 *
 * @author crist
 */
public interface SistemaSkinShop {
    
    public boolean agregarPersonaje(String nombre, String rol);
    
    public boolean agregarSkin (String nombre, String calidad);
    
    public void asociarPersonajeSkin(String nombrePersonaje, String nombreSkin);
    
    public boolean agregarCuenta(String nombreCuenta, String contraseña, String nick,int nivel, int rp, String region);
    
    public void asociarPersonajeCuenta(String nickCuenta, String nombrePersonaje);
    
    public void agregarSkinACuenta(String nombreSkin, String nombreCuenta);
    
    //public boolean iniciarSesion(String nombreCuenta, String contraseña);  // eliminar por que va en el APP
    
    public boolean comprarSkin (String nombreCuenta, String nombrePersonaje, String nombreSkin);
    
    public boolean comprarPersonaje (String nombreCuenta, String nombrePersonaje); // agregar nombreCuenta al contrato
    
    public String mostrarSkinsDisponibles(String nombreCuenta);
    
    public String desplegarInventario (String nombreCuenta);
    
    public void recargarSaldo(String nombreCuenta, int newSaldo);
    
    public String mostrarDatos(String nombreCuenta);
    
    public boolean cambiarContraseña(String nombreCuenta, String contraseñaAntigua1, String contraseñaAntigua2, String nuevaContraseña);
    
    public String recaudacionPorRol ();
    
    public String recaudacionPorRegion ();
    
    public String recaudacionPorPersonaje();
    
    public boolean bloquearCuenta(String nick);
    
    public String desplegarCuentasNivel();
    
    public boolean agregarPersonajeAdmin(String nombrePersonaje,String rol,String nombreSkin,String calidadSkin);
    
    public boolean asociarEstadistica(String nombrePersonje, double recaudacion); // contrato nuevo para archivo recaudacion
    
    public boolean iniciarSesionComprobar(String nombreCuenta, String contraseña);
    
    //public void menuAdmin(); //
}
