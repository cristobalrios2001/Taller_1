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
    
    public String desplegarInventario (String nombreCuenta)
    {
        String salida = "";
        Cuenta cuenta = listaCuentas.buscarCuenta(nombreCuenta);
        ListaPersonajes  lp = cuenta.getListaPersojanes();
        for (int i = 0; i < lp.getCantPersonajes(); i++) {
            salida = "\nLos personajes de la cuenta son: \n";
            Personaje personaje = lp.getPersonajeI(i);
            salida = salida + personaje.getNombrePersonaje();
            ListaSkins ls = personaje.getListaSkins();
            
            for (int j = 0; j < ls.getCantSkins(); j++) {
                Skin skin = listaSkins.getSkinI(i);
                salida = salida + "\nTienen las siguientes skins: ";
                salida = salida + "\n\tNombre Skin: "+skin.getNombreSkin();
            }
            salida = salida + "\n";
        }
        return salida;
    }
    
    @Override
    public void recargarSaldo(String nombreCuenta, int newSaldoRp)
    {
        Cuenta cuenta = listaCuentas.buscarCuenta(nombreCuenta);
        if(cuenta != null)
        {
            int saldoActual = cuenta.getCantRP();
            cuenta.setCantRP(newSaldoRp+saldoActual);
        }else
        {
            throw new NullPointerException("Cuenta no existe");
        }
        
        
    }
    
    public String mostrarDatos(String nombreCuenta)
    {
        String salida ="";
        Cuenta cuenta = listaCuentas.buscarCuenta(nombreCuenta);
        salida = salida + "Nombre: "+cuenta.getNombreCuenta();
        salida = salida +"\nNick: "+cuenta.getNick();
        
        String [] partes = cuenta.getContraseña().split("");
        salida = salida + "\nContraseña: ";
        for (int i = 0; i < partes.length; i++) {
            if(i<partes.length-3){
               salida = salida + "*";
            }else{
                salida = salida + partes[i];
            }
        }
        
        return salida;
        
    }
    
    @Override
    public void cambiarContraseña(String nombreCuenta, String contraseñaAntigua1, String contraseñaAntigua2, String nuevaContraseña)
    {
        Cuenta cuenta = listaCuentas.buscarCuenta(nombreCuenta);
        String oldPass = cuenta.getContraseña();
        
        if(contraseñaAntigua1.equals(oldPass) && contraseñaAntigua2.equals(oldPass)){
            cuenta.setContraseña(nuevaContraseña);
        }else{
            
        }
    }
    
    public String recaudacionPorRol ()
    {
        String salida = "";
        int sup = 0;
        int adc = 0;
        int top = 0;
        int mid = 0;
        int jg = 0;
        
        for (int i = 0; i < listaPersonajes.getCantPersonajes(); i++) {
            Personaje personaje = listaPersonajes.getPersonajeI(i);
            String rol =personaje.getRol();
            
            switch (rol) {
                case "SUP":
                    sup += personaje.getRecaudacion();
                    break;
                case "ADC":
                    adc += personaje.getRecaudacion();
                    break;
                case "TOP":
                    top += personaje.getRecaudacion();
                    break;
                case "MID":
                    mid += personaje.getRecaudacion();
                    break;
                case "JG":
                    jg += personaje.getRecaudacion();
                    break;
                default:
                    break;
            }
        }
        
        salida = salida + "Recaudaciones por Rol: ";
        salida = salida + "\n\tSupport: " + sup;
        salida = salida + "\n\tAtack Damage Carry: " + adc;
        salida = salida + "\n\tTop Laner: " + top;
        salida = salida + "\n\tMiddle Laner: "+ mid;
        salida = salida + "\n\tJungler: "+jg;
        return salida;
    }
    
    @Override
    public String recaudacionPorRegion ()
    {
        String salida = "";
        int las = 0;
        int lan = 0;
        int euw = 0;
        int kr = 0;
        int na = 0;
        int ru = 0;
        
        for (int i = 0; i < listaCuentas.getCantCuentas(); i++) {
            Cuenta cuenta = listaCuentas.getCuentaI(i);
            String region = cuenta.getRegion();
            
            switch (region) {
                case "LAS":
                    las += cuenta.getRecaudacionCta();
                    break;
                case "LAN":
                    lan += cuenta.getRecaudacionCta();
                    break;
                case "EUW":
                    euw += cuenta.getRecaudacionCta();
                    break;
                case "KR":
                    kr += cuenta.getRecaudacionCta();
                    break;
                case "NA":
                    na += cuenta.getRecaudacionCta();
                    break;
                case "RU":
                    ru += cuenta.getRecaudacionCta();
                    break;
                default:
                    break;
            }
        }
        
        salida = salida + "Recaudaciones por region: ";
        salida = salida + "\n\tLAS: " + las;
        salida = salida + "\n\tLAN: " + lan;
        salida = salida + "\n\tEUW: " + euw;
        salida = salida + "\n\tKR: "+ kr;
        salida = salida + "\n\tNA: "+ na;
        salida = salida + "\n\tRU: "+ru;
        return salida;
    }
    
    @Override
    public String recaudacionPorPersonaje()
    {
        String salida = "";
        for (int i = 0; i < listaPersonajes.getCantPersonajes(); i++) {
            Personaje personaje = listaPersonajes.getPersonajeI(i);
            salida = salida + "Nombre personaje: " + personaje.getNombrePersonaje()+"\n";
            salida = salida + "Recaudacion: "+ personaje.getRecaudacion();
        }
        return salida;
    }
    
    public boolean bloquearCuenta(String nick)
    {
    
    }
    
    public String desplegarCuentasNivel()
    {
    
    }
    
    public boolean ingresarPersonajesAdmin(String nombrePersonaje, String rol)
    {
    
    }

    
    
}
