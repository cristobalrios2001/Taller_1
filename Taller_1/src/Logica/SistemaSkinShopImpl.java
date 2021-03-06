
package Logica;

import Dominio.*;

public class SistemaSkinShopImpl implements SistemaSkinShop {
    private ListaCuentas listaCuentas;
    private ListaPersonajes listaPersonajes;
    private ListaSkins listaSkins;
    
    public SistemaSkinShopImpl(){
        listaCuentas = new ListaCuentas(1000);
        listaPersonajes = new ListaPersonajes(650);
        listaSkins = new ListaSkins(500);
    }
    
    
    @Override
    public boolean agregarPersonaje(String nombre, String rol)
    {
        Personaje personaje = new Personaje(nombre,rol);
        return listaPersonajes.ingresarPersonaje(personaje);
    }
    
    @Override
    public boolean agregarSkin (String nombre, String calidad)
    {
        Skin skin = new Skin(nombre,calidad);
        return listaSkins.ingresarSkin(skin);
    }
    
    @Override
    public boolean asociarPersonajeSkin(String nombrePersonaje, String rol , String nombreSkin, String calidad)
    {
        
        Personaje personaje = listaPersonajes.buscarPersonaje(nombrePersonaje);
        
        if(personaje != null){
            Skin skin = personaje.getListaSkins().buscarSkin(nombreSkin);
            if(skin == null){
                skin = new Skin (nombreSkin,calidad);
                boolean ingresado = personaje.getListaSkins().ingresarSkin(skin);
                boolean ingresarSkin = listaSkins.ingresarSkin(skin);
                if(ingresado && ingresarSkin){
                    return true;
                }else{
                    return false;
                }
            }else{
                throw new NullPointerException ("No se ha encontrado la skin : "+skin.getNombreSkin());
            }
        }else{
            throw new NullPointerException("No se ha encontrado la skin : "+personaje.getNombrePersonaje());
        }
    }
    
    @Override
    public boolean ingresarSkinPersonaje(String nombrePersonaje, String nombreSkin, String calidad){
        Personaje personaje = listaPersonajes.buscarPersonaje(nombrePersonaje);
        
        if(personaje != null){
            Skin skinBusq = listaSkins.buscarSkin(nombreSkin);
            if(skinBusq == null){
                Skin skinNew = new Skin (nombreSkin, calidad);
                personaje.getListaSkins().ingresarSkin(skinNew);
            }
        }
        return false;
    }
    
    @Override
    public boolean agregarCuenta(String nombreCuenta, String contrase??a, String nick,int nivel, int rp, String region)
    {
        boolean ingreso=false;
        Cuenta cuenta = listaCuentas.buscarCuenta(nombreCuenta);
        if(cuenta == null){
            Cuenta cuentaNueva= new Cuenta(nombreCuenta,contrase??a,nick,nivel,rp,region);
            ingreso = listaCuentas.ingresar(cuentaNueva);
        }
        return ingreso;
    }
    
    public boolean existeCuenta(String nombreCuenta){
        Cuenta cuenta = listaCuentas.buscarCuenta(nombreCuenta);
        if (cuenta != null){
            if( cuenta.getEstadoCuenta() == true){
                return true;
            }else{
                return false;
            }
                
        }
        return false;
    }
    
    @Override
    public boolean asociarPersonajeCuenta(String nickCuenta, String nombrePersonaje)
    {
        Cuenta cuenta = listaCuentas.buscarCuenta(nickCuenta);
        
        if(cuenta != null){
            Personaje personaje = listaPersonajes.buscarPersonaje(nombrePersonaje);
            if(personaje!= null){
                boolean ingresar = cuenta.getListaPersojanes().ingresarPersonaje(personaje);
                if(ingresar){
                    return true;
                }else{
                    return false;
                }
            }else{
                throw new NullPointerException("El personaje no existe");
            }
        }else{
            throw new NullPointerException("La cuenta no existe");
        }
    }
    
    @Override
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
    
    
    
    @Override
    public boolean comprarSkin (String nombreCuenta, String nombrePersonaje, String nombreSkin)
    {
        Cuenta cuenta = listaCuentas.buscarCuenta(nombreCuenta);
        Personaje personaje = listaPersonajes.buscarPersonaje(nombrePersonaje);
        if(personaje != null){
            int oldRp = cuenta.getCantRP();
            Skin skin = listaSkins.buscarSkin(nombreSkin);
            if(skin != null){
                String calidad = skin.getCalidad();
                
                switch (calidad) {
                case "M":                    
                    cuenta.setCantRP(oldRp-3250);                    
                    break;
                case "D":                    
                    cuenta.setCantRP(oldRp-2750);
                    break;
                case "L":
                    cuenta.setCantRP(oldRp-1820);
                    break;
                case "E":
                    cuenta.setCantRP(oldRp-1350);
                    break;
                case "N":
                    cuenta.setCantRP(oldRp-975);
                    break;                
                default:
                    break;
                }
            return true;
                
            }else{
                throw new NullPointerException("La Skin no existe");
            }
            
        }else{
            throw new NullPointerException("El personaje no exite");
        }
        
    }
    
    @Override
    public boolean comprarPersonaje (String nombreCuenta, String nombrePersonaje)
    {
        Cuenta cuenta = listaCuentas.buscarCuenta(nombreCuenta);
        
        Personaje personaje = listaPersonajes.buscarPersonaje(nombrePersonaje);
        
        if(personaje != null){
            int rpOld = cuenta.getCantRP();
            cuenta.setCantRP(rpOld-975);
            
            cuenta.getListaPersojanes().ingresarPersonaje(personaje);
            return true;
        }else{
            
            throw new NullPointerException("El personaje no existe");
            
        }
        
        
    }
    
    @Override
    public String mostrarSkinsDisponibles(String nombreCuenta)
    {
        String salida = "";
        Cuenta cuenta = listaCuentas.buscarCuenta(nombreCuenta);
        ListaSkins listaSkinsCuenta = cuenta.getListaSkins();
        salida = salida + "Las skins disponibles son: \n";
        for (int i = 0; i < listaCuentas.getCantCuentas(); i++) {
            String skinGeneral =listaSkins.getSkinI(i).getNombreSkin();
            String skinCuenta = listaSkinsCuenta.getSkinI(i).getNombreSkin();
            if(!skinGeneral.equals(skinCuenta)){
                salida = salida + "\t"+skinGeneral+"\n";
            }
        }
        return salida;
        
    }
    
    @Override
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
    public boolean recargarSaldoRP(String nombreCuenta, int newSaldoRp)
    {
        Cuenta cuenta = listaCuentas.buscarCuenta(nombreCuenta);
        if(cuenta != null)
        {
            int saldoActual = cuenta.getCantRP();
            cuenta.setCantRP(newSaldoRp+saldoActual);
            return true;
        }else
        {
            throw new NullPointerException("Cuenta no existe");
        }
        
        
    }
    
    @Override
    public String mostrarDatos(String nombreCuenta)
    {
        String salida ="";
        Cuenta cuenta = listaCuentas.buscarCuenta(nombreCuenta);
        salida = salida + "Nombre: "+cuenta.getNombreCuenta();
        salida = salida +"\nNick: "+cuenta.getNick();
        
        String [] partes = cuenta.getContrase??a().split("");
        salida = salida + "\nContrase??a: ";
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
    public boolean cambiarContrase??a(String nombreCuenta, String contrase??aAntigua1, String contrase??aAntigua2, String nuevaContrase??a)
    {
        Cuenta cuenta = listaCuentas.buscarCuenta(nombreCuenta);
        String oldPass = cuenta.getContrase??a();
        
        if(cuenta != null && !cuenta.getEstadoCuenta() != false){
            if(contrase??aAntigua1.equals(oldPass) && contrase??aAntigua2.equals(oldPass)){
                cuenta.setContrase??a(nuevaContrase??a);
                return true;
            }else{
                return false;
            }          
        }else{
            throw new NullPointerException("La cuenta no existe");
        }
        
        
    }
    
    @Override
    public String recaudacionPorRol ()
    {
        String salida = "";
        double sup = 0;
        double adc = 0;
        double top = 0;
        double mid = 0;
        double jg = 0;
        
        for (int i = 0; i < listaPersonajes.getCantPersonajes(); i++) {
            Personaje personaje = listaPersonajes.getPersonajeI(i);
            String rol =personaje.getRol();
            
            switch (rol) {
                case "SUP":
                    sup += personaje.getRecaudacion()*6.15;
                    break;
                case "ADC":
                    adc += personaje.getRecaudacion()*6.15;
                    break;
                case "TOP":
                    top += personaje.getRecaudacion()*6.15;
                    break;
                case "MID":
                    mid += personaje.getRecaudacion()*6.15;
                    break;
                case "JG":
                    jg += personaje.getRecaudacion()*6.15;
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
        double las = 0;
        double lan = 0;
        double euw = 0;
        double kr = 0;
        double na = 0;
        double ru = 0;
        
        for (int i = 0; i < listaCuentas.getCantCuentas(); i++) {
            Cuenta cuenta = listaCuentas.getCuentaI(i);
            String region = cuenta.getRegion();
            
            switch (region) {
                case "LAS":
                    las += cuenta.getRecaudacionCta()*6.15;
                    break;
                case "LAN":
                    lan += cuenta.getRecaudacionCta()*6.15;
                    break;
                case "EUW":
                    euw += cuenta.getRecaudacionCta()*6.15;
                    break;
                case "KR":
                    kr += cuenta.getRecaudacionCta()*6.15;
                    break;
                case "NA":
                    na += cuenta.getRecaudacionCta()*6.15;
                    break;
                case "RU":
                    ru += cuenta.getRecaudacionCta()*6.15;
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
            salida = salida + "Recaudacion: "+ personaje.getRecaudacion()*6.15;
        }
        return salida;
    }
    
    @Override
    public String obtenerCantPersonajesRol(){
        String salida = "";
        double sup = 0;
        double adc = 0;
        double top = 0;
        double mid = 0;
        double jg = 0;
        
        for (int i = 0; i < listaPersonajes.getCantPersonajes(); i++) {
            Personaje personaje = listaPersonajes.getPersonajeI(i);
            String rol =personaje.getRol();
            
            switch (rol) {
                case "SUP":
                    sup += 1;
                    break;
                case "ADC":
                    adc += 1;
                    break;
                case "TOP":
                    top += 1;
                    break;
                case "MID":
                    mid += 1;
                    break;
                case "JG":
                    jg += 1;
                    break;
                default:
                    break;
            }
        }
        
        salida = salida + "Cantidad de personajes por Rol: ";
        salida = salida + "\n\tSupport: " + sup;
        salida = salida + "\n\tAtack Damage Carry: " + adc;
        salida = salida + "\n\tTop Laner: " + top;
        salida = salida + "\n\tMiddle Laner: "+ mid;
        salida = salida + "\n\tJungler: "+jg;
        return salida;
        
    }
    
    @Override
    public boolean bloquearCuenta(String nombreCuenta)
    {
        Cuenta cuenta = listaCuentas.buscarCuenta(nombreCuenta);
        if(cuenta != null){
            cuenta.setEstadoCuenta(false);
            return true;
        }else{
            throw new NullPointerException ("No existe la cuenta");
        }
    }
    
    @Override
    public String desplegarCuentasNivel()
    {
        String salida = "";
        String [] cuentaNombre = new String[1000];
        int [] cuentaNivel = new int [1000];
        int cantCuentas = 0;
        for (int i = 0; i < listaCuentas.getCantCuentas(); i++) {
            cuentaNombre[cantCuentas] = listaCuentas.getCuentaI(i).getNombreCuenta();
            cuentaNivel[cantCuentas] = listaCuentas.getCuentaI(i).getNivelCuenta();
            cantCuentas++;
        }
        
        for(int i = 0; i <=cantCuentas -2; i++){
            for( int j = cantCuentas -1; j >= i+1; j--) {
                if (cuentaNivel[j] > cuentaNivel[j - 1]) {
                    int AUX = cuentaNivel[j];
                    cuentaNivel[j] = cuentaNivel[j - 1];
                    cuentaNivel[j - 1] = AUX;
                    
                    String AUXs = cuentaNombre[j];
                    cuentaNombre[j] = cuentaNombre[j - 1];
                    cuentaNombre[j - 1] = AUXs;
                }
            }
        }
 
        for (int i = 0; i < cantCuentas; i++) {
            salida = salida + cuentaNombre[cantCuentas]+" "+cuentaNivel[cantCuentas];
        }
        
        return salida;
    }
    
    
    
    @Override
    public boolean agregarPersonajeAdmin(String nombrePersonaje,String rol,String nombreSkin,String calidadSkin) {
        Personaje personaje = listaPersonajes.buscarPersonaje(nombrePersonaje);
        if(personaje ==null) {
            personaje = new Personaje(nombrePersonaje, rol);
            listaPersonajes.ingresarPersonaje(personaje);
           
            Skin skin = listaSkins.buscarSkin(nombreSkin);
            if(skin == null) {
                skin = new Skin(nombreSkin, calidadSkin);
                personaje.getListaSkins().ingresarSkin(skin);
                listaSkins.ingresarSkin(skin);
                return true;
            }
            
        }
        return false;
    }

    @Override
    public boolean asociarEstadistica(String nombrePersonje, double recaudacion){
        Personaje personaje = listaPersonajes.buscarPersonaje(nombrePersonje);
        if(personaje != null){
            personaje.setRecaudacion(recaudacion);
            return true;
        }else{
            throw new NullPointerException("El personaje no existe");
        }
    }

    
    
    
    @Override
    public String obtenerSkinsDisponiblesPersonaje(String nombreCuenta, String nombrePersonaje){
        String salida = "";
        
        Cuenta cuenta = listaCuentas.buscarCuenta(nombreCuenta);
        Personaje persCuenta = cuenta.getListaPersojanes().buscarPersonaje(nombrePersonaje);
        Personaje personaje = listaPersonajes.buscarPersonaje(nombrePersonaje);
        
        if(persCuenta != null){
            ListaSkins lsCuenta = persCuenta.getListaSkins();
            ListaSkins lsGen = personaje.getListaSkins();
            for (int i = 0; i < lsGen.getCantSkins(); i++) {
                
                Skin skinCuenta = lsCuenta.getSkinI(i);
                Skin skinGen = lsGen.getSkinI(i);
                
                salida += "Skins de "+ persCuenta.getNombrePersonaje()+": \n";
                
                if(!skinCuenta.getNombreSkin().equals(skinGen.getNombreSkin())){
                    salida += "\t"+skinCuenta.getNombreSkin()+"\n";
                }
            }
            
        }else{
            throw new NullPointerException("El personaje no existe");
        }
        
        return salida;
    }
    
    @Override
    public String obtenerPersonajesDisponibles (String nombreCuenta){
        String salida = "";
        Cuenta cuenta = listaCuentas.buscarCuenta(nombreCuenta);
        
        if(cuenta!= null){
            ListaPersonajes lpc = cuenta.getListaPersojanes();
            
            for (int i = 0; i < listaPersonajes.getCantPersonajes(); i++) {
                Personaje personaje = lpc.getPersonajeI(i);
                Personaje personajeGen = listaPersonajes.getPersonajeI(i);
                if(personaje.getNombrePersonaje().equals(personajeGen.getNombrePersonaje())){
                    salida += "Nombre : "+ personaje.getNombrePersonaje();
                }
            }
        }
        return salida;
    }
    
    @Override
    public boolean existeCliente (String nombreCuenta){
        Cuenta cuenta = listaCuentas.buscarCuenta(nombreCuenta);
        
        if(cuenta == null){
            return false;
        }else{
            return true;
        }
        
    }
    
    @Override
    public boolean contrase??aCorrecta(String nombreCuenta,String contrase??a){
        Cuenta cuenta = listaCuentas.buscarCuenta(nombreCuenta);
        if(cuenta != null){
            if(cuenta.getContrase??a().equals(contrase??a)){
                return true;
            }else{
                return false;
            }
        }else{
            throw new NullPointerException("Cuanta no encontrada/ no existe");
        }
    }

    @Override
    public boolean asignarRegion (String nombreCUenta, String region){
        Cuenta cuenta = listaCuentas.buscarCuenta(nombreCUenta);
        if(cuenta!= null){
            cuenta.setRegion(region);
            return true;
        }else{
            throw new NullPointerException("Cuenta no existe");
        }
        
    }
}
