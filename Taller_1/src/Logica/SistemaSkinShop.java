
package Logica;

import Dominio.Cuenta;
import Dominio.Personaje;


public interface SistemaSkinShop {
    
    public boolean agregarPersonaje(String nombre, String rol);
    
    public boolean agregarSkin (String nombre, String calidad);
    
    public boolean asociarPersonajeSkin(String nombrePersonaje, String rol , String nombreSkin, String calidad);
    
    public boolean ingresarSkinPersonaje(String nombrePeronsje, String nombreSkin, String calidad); // agrega una skin cuando el personaje ya existe
    
    public boolean agregarCuenta(String nombreCuenta, String contraseña, String nick,int nivel, int rp, String region);
    
    public boolean asociarPersonajeCuenta(String nickCuenta, String nombrePersonaje);
    
    public void agregarSkinACuenta(String nombreSkin, String nombreCuenta);
    
    public boolean comprarSkin (String nombreCuenta, String nombrePersonaje, String nombreSkin);
    
    public boolean comprarPersonaje (String nombreCuenta, String nombrePersonaje); 
    
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
    
    public boolean asociarEstadistica(String nombrePersonje, double recaudacion); 
    
    public boolean iniciarSesionComprobar(String nombreCuenta, String contraseña);
    
    public String obtenerSkinsDisponiblesPersonaje(String nombreCuenta, String nombrePersonaje);
    
    public String obtenerPersonajesDisponibles (String nombreCuenta);
}
