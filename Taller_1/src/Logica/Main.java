package Logica;

import java.io.File;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.IOException;

public class Main {

    
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        SistemaSkinShop sistema =new SistemaSkinShopImpl();
        
        
        
        
        
    }
    
    
    
     public static void verificarRut(SistemaSkinShop sistema){
        Scanner sn = new Scanner(System.in);
        System.out.println("Ingresar usuario: ");
        String nombreCuenta = sn.next();

        System.out.println("Ingresar Contraseña: ");
        String contraseña = sn.next();
        
        
        
        if(nombreCuenta.equals("ADMIN") && contraseña.equals("ADMIN")){
            menuAdmin(sistema); // es admin
        }
        else{
            try{
                boolean verificar = false;
                verificar = sistema.iniciarSesionComprobar(nombreCuenta, contraseña);
                if (verificar == true){
                    menuCliente(sistema, nombreCuenta);
                }else{
                    System.out.println("No existe la cuenta, ¿Desea crear una cuenta? (Si / No)");
                    String opcionCrear= sn.next();
                    if(opcionCrear.equalsIgnoreCase("Si")){
                        
                    }
                }
            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }
        
    }
    
    
    
    public static void sistema (SistemaSkinShop sistema){
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; 
        do{
            System.out.println("1. Iniciar Sesión");           
            System.out.println("2. Salir - Cerrar Sistema");
            try {
                System.out.print("Escribe una de las opciones: ");
                opcion = sn.nextInt();
                switch (opcion) {
                    case 1:
                        System.out.println("Has seleccionado la opción 1: Iniciar Sesión");
                        
                        break;
                    
                    case 2:
                        System.out.println("Has seleccionado la opción 2: Cerrar programa");
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 2");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }
        while (!salir) ;
    }
    
    
    
    
    public static void menuCliente(SistemaSkinShop sistema, String nombreCuenta){
        Scanner sn = new Scanner (System.in);
        boolean salir = false;
        int opcion; 
        do{
            System.out.println("1. Comprar Skin.");      
            System.out.println("2. Comprar Personaje."); 
            System.out.println("3. Skins Disponibles."); 
            System.out.println("4. Mostrar Inventario."); 
            System.out.println("5. Recargar RP."); 
            System.out.println("6. Mostrar Datos de Cuenta.");             
            System.out.println("7. Salir");
            try {
                System.out.print("Escribe una de las opciones: ");
                opcion = sn.nextInt();
                switch (opcion) {
                    case 1:
                        System.out.println("\nHas seleccionado la opción 1:  Comprar Skin.");
                        comprarSkin(sistema, nombreCuenta);                        
                        break;
                    case 2:
                        System.out.println("\nHas seleccionado la opción 2: Comprar Personaje.");
                        comprarPersonaje(sistema, nombreCuenta);
                        break;
                    case 3:
                        System.out.println("\nHas seleccionado la opción 3: Skins Disponibles.");
                        System.out.println(sistema.mostrarSkinsDisponibles( nombreCuenta));
                        break;
                    case 4:
                        System.out.println("\nHas seleccionado la opción 4: Mostrar Inventario.");
                        System.out.println(sistema.desplegarInventario (nombreCuenta));
                        break;
                    case 5:
                        System.out.println("\nHas seleccionado la opción 5: Recargar RP.");
                        recargarRp(sistema, nombreCuenta);
                        break;
                    case 6:
                        System.out.println("\nHas seleccionado la opción 6: Mostrar Datos de Cuenta.");
                        System.out.println(sistema.mostrarDatos(nombreCuenta));
                        break;
                    case 7:
                        System.out.println("\nHas seleccionado la opción 7: Salir.");
                        salir = true;
                        break;
                    default:
                        System.out.println("\nSolo números entre 1 y 5");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }
        while (!salir) ;
    }
   
    public static void comprarSkin(SistemaSkinShop sistema, String nombreCuenta){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese nombre del personaje: ");
        String nombrePersonaje = sc.next();
        
        System.out.println(sistema.obtenerSkinsDisponiblesPersonaje( nombreCuenta,  nombrePersonaje));
        
        System.out.println("Ingrese nombre skin: ");
        String nombreSkin = sc.next();
        
        sistema.comprarSkin ( nombreCuenta,  nombrePersonaje,  nombreSkin);
    }
    
    public static void comprarPersonaje(SistemaSkinShop sistema, String nombreCuenta){
        Scanner sc = new Scanner(System.in);
        System.out.println(sistema.obtenerPersonajesDisponibles(nombreCuenta));
        System.out.println("Ingresar Nombre de personaje a comprar: ");
        String nombrePersonajeCompra = sc.next();
        boolean validacionCompra = false;
        
        try{
            sistema.comprarPersonaje ( nombreCuenta,  nombrePersonajeCompra);
            validacionCompra = true;
        }catch(NullPointerException ex){
            System.out.println(ex.getMessage());
        }
        
        if( validacionCompra = true){
            System.out.println("Compra Exitosa");
        }else{
            System.out.println("Compra no realizada");
        }
        
    }
    
    public static boolean  recargarRp(SistemaSkinShop sistema, String nombreCuenta){
        Scanner sc = new Scanner (System.in);
        System.out.println("Ingresar cantidad de rp a ingresar: ");
        int newSaldoRp = sc.nextInt();
        
        while(newSaldoRp <0 || newSaldoRp ==0){
            System.out.println("Reingrese datos, Ingresar cantidad de rp a ingresar: ");
            newSaldoRp = sc.nextInt();
        }
        
        if(sistema.recargarSaldoRP( nombreCuenta,  newSaldoRp)){
            return true;
        }
        return false;
    }
    
    public static void menuAdmin(SistemaSkinShop sistema)
    {   Scanner sc = new Scanner(System.in);
        //recaudacionRol();
        //recaudacionPorRegion();
        //recaudacionPorPersonaje();
        //cantidadDePersonajesPorRol();
        boolean salir = false;
        int opcion;
        do{
            System.out.println("1. Agregar personaje.");
            System.out.println("2. Agregar Skin.");
            System.out.println("3. Bloquear un jugador.");
            System.out.println("4. Salir");
            try
            {
                System.out.print("Escribe una de las opciones: ");
                opcion = sc.nextInt();
                switch (opcion){
                    case 1:
                        System.out.println("\nHas seleccionado la opción 1:  Agregar personaje.");
                        agregarPersonaje(sistema);
                        break;    
                    case 2:
                        System.out.println("\nHas seleccionado la opción 2:  Agregar Skin.");
                        agregarSkin(sistema);
                        break;
                    case 3:
                        System.out.println("\nHas seleccionado la opción 3:  Bloquear un Jugador.");
                        bloquearJugador(sistema);
                        break;
                    case 4:
                        System.out.println("\nHas seleccionado la opción 4: Salir.");
                        salir = true;
                        break;
                    default:
                        System.out.println("\nSolo números entre 1 y 4");
               }    
    
            }catch(InputMismatchException e){
                System.out.println("Debes insertar un número");
                sc.next();
            }
        }
        while(!salir);
        //desplegarCuentasNivel();
    }
    
    public static void agregarPersonaje(SistemaSkinShop sistema){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese Nombre de personaje a agregar: "); String nombrePersonaje = sc.next();
        System.out.println("Ingrese Rol de personaje: "); String rol = sc.next();
        
        System.out.println("Ingrese cantidad de Skins: "); int cantSkins = sc.nextInt();
        
        while (cantSkins<0) {
             System.out.println("Ingrese cantidad de Skins: ");  cantSkins = sc.nextInt();
        }
        
        System.out.println("Ingrese Nombre de Skin: "); String nombreSkin = sc.next();
        System.out.println("Ingrese Calidad de Skin: "); String calidad = sc.next();
        
        sistema.asociarPersonajeSkin( nombrePersonaje,  rol ,  nombreSkin,  calidad);
        
        if(cantSkins == 1 && cantSkins!= 0){
            sistema.asociarPersonajeSkin( nombrePersonaje,  rol ,  nombreSkin,  calidad);
            
            
        }else if(cantSkins >1){
             sistema.ingresarSkinPersonaje( nombrePersonaje,  nombreSkin,  calidad);
        }
        
        
        
        
    }
    
    public static void agregarSkin(SistemaSkinShop sistema){
        Scanner sc = new Scanner (System.in);
        System.out.println("Ingrese NOMBRE del PERSONAJE para ingresar skin correspondiente: "); String nombrePersonaje = sc.next();
        System.out.println("Ingrese NOMBRE de la SKIN: "); String nombreSkin = sc.next();
        System.out.println("Ingrese CALIDAD de la SKIN: "); String calidad = sc.next();
        
        boolean ingreso = sistema.ingresarSkinPersonaje( nombrePersonaje,  nombreSkin,  calidad); 
        
        if(ingreso == true){
            System.out.println("Skin ingresada al personaje");
        }else{
            System.out.println("No se pudo ingresar la skin");
        }
    }
    
    public static void bloquearJugador(SistemaSkinShop sistema){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresar el jugador a bloquear: "); String nombreCuenta = sc.next();
        try{
            sistema.bloquearCuenta( nombreCuenta);
        }catch (NullPointerException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public static void lecturaArchivo(SistemaSkinShop sistema)throws IOException{        
        Scanner s = new Scanner(new File("Personajes.txt"));
        while(s.hasNextLine()) {
            String line = s.nextLine();
            String [] partes = line.split(",");
            String nombrePersonaje = partes[0];
            String rol = partes[1];
            try {
                boolean ingreso = sistema.agregarPersonaje(nombrePersonaje, rol);
                if(ingreso) {
                    int cantSkins = Integer.parseInt(partes[2]);
                    int cont = 3;
                    for(int i=0;i<cantSkins;i++) {
                        String nombreSkin = partes[cont];
                        String calidad = partes[cont+1];
                        cont+=2;
                        try {
                            boolean ingresoAsocia = sistema.asociarPersonajeSkin( nombrePersonaje,  rol ,  nombreSkin,  calidad);
                            if(!ingresoAsocia) {
                                System.out.println("No se puede ingresar las skin a la cuenta por que no queda espacio disponible");
                            }
                        }catch(Exception ex) {
                            System.out.println("\t"+ex.getMessage());
                        }
                    }
                    
                }
            }catch (Exception ex) {
                System.out.println("\t"+ex.getMessage());
            }
        }
    }
    
    
    public static void lecturaCuentas(SistemaSkinShopImpl sistrema) throws IOException
    {
        Scanner sc = new Scanner (new File("Cuentas.txt"));
        while(sc.hasNextLine()){
            String [] partes = sc.nextLine().split(",");
            for (int i = 6; i < partes.length-2 ; i++) {
                String nombreCampeon = partes[i];
                
                int cantSkins = Integer.parseInt(partes[i+1]);
                for (int j = i+2; j < (i+2)+cantSkins; j++) {
                    String nombreSkin = partes[j];
                    
                }
                i += cantSkins+1;
            }
        }
    
    }
    
    
    /*
    public static void lecturaArchivo3(SistemaSkinShopImpl sistema) throws IOException
        Scanner sc = new Scanner (new File("Estadisticas.txt"))
        while(sc.hasNextLine()){
        
        }
    */
}
