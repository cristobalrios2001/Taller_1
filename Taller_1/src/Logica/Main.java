package Logica;

import java.io.File;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.IOException;

public class Main {

    
    public static void main(String[] args) throws IOException {
       
        SistemaSkinShop sistema =new SistemaSkinShopImpl();
        
        lecturaPersonajes( sistema);        
        lecturaCuentas( sistema);
        
        
        
        sistema ( sistema);
        
        
        
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
                         inicioSesion( sistema);
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
                        System.out.println("\nHas seleccionado la opción 1:  Recaudación de ventas por rol.");
                        System.out.println(sistema.recaudacionPorRol());
                        break;   
                    case 2:
                        System.out.println("\nHas seleccionado la opción 2: Recaudación total de ventas por región.");
                        System.out.println(sistema.recaudacionPorRegion());
                        break;   
                    case 3:
                        System.out.println("\nHas seleccionado la opción 3:  Recaudación de ventas por personaje.");
                        System.out.println(sistema.recaudacionPorPersonaje());
                        break;   
                    case 4:
                        System.out.println("\nHas seleccionado la opción 4:  Cantidad de personajes por rol.");
                        System.out.println(sistema.obtenerCantPersonajesRol());
                        break;       
                    case 5:
                        System.out.println("\nHas seleccionado la opción 5:  Agregar personaje.");
                        agregarPersonaje(sistema);
                        break;    
                    case 6:
                        System.out.println("\nHas seleccionado la opción 6:  Agregar Skin.");
                        agregarSkin(sistema);
                        break;
                    case 7:
                        System.out.println("\nHas seleccionado la opción 7:  Bloquear un Jugador.");
                        bloquearJugador(sistema);
                        break;
                    case 8:
                        System.out.println("\nHas seleccionado la opción 8: Salir.");
                        salir = true;
                        break;
                    default:
                        System.out.println("\nSolo números entre 1 y 8");
               }    
    
            }catch(InputMismatchException e){
                System.out.println("Debes insertar un número");
                sc.next();
            }
        }
        while(!salir);
        
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
    
    public static void lecturaPersonajes(SistemaSkinShop system)throws IOException{
       System.out.println("Leyendo cuentas");
       Scanner s = new Scanner(new File("Personajes.txt"));
       while(s.hasNextLine()) {
           String line = s.nextLine();
           String [] partes = line.split(",");
           String nombrePersonaje = partes[0];
           String rol = partes[1];
           try {
               boolean ingreso = system.agregarPersonaje(nombrePersonaje, rol);
               if(ingreso) {
                   int cantSkins = Integer.parseInt(partes[2]);
                   int cont = 3;
                   for(int i=0;i<cantSkins;i++) {
                       String nombreSkin = partes[cont];
                       String calidadSkin = partes[cont+1];
                       cont+=2;
                       try {
                           boolean ingresoAsocia = system.asociarPersonajeSkin(nombrePersonaje, rol, nombreSkin, calidadSkin);
                           if(!ingresoAsocia) {
                               System.out.println("No se puede ingresar las skin a la cuenta por que no queda espacio");
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
    
    
    public static void lecturaCuentas(SistemaSkinShop system) throws IOException{
        System.out.println("Leyendo personajes");
        Scanner s = new Scanner(new File("Cuentas.txt"));
        while(s.hasNextLine()) {
            String line = s.nextLine();
            String [] partes = line.split(",");
            String nombreCuenta = partes[0];
            String contraseña = partes[1];
            String nick = partes[2];
            int nivelCuenta = Integer.parseInt(partes[3]);
            int rpCuenta = Integer.parseInt(partes[4]);
            try {
                boolean ingresado = system.agregarCuenta(nombreCuenta, contraseña, nick, nivelCuenta, rpCuenta, nick);
                if(ingresado) {
                    int cantPersonajes = Integer.parseInt(partes[5]);
                    int avance = 6;
                    int acumu = 8;
                    for(int i=0;i<cantPersonajes;i++) {
                        String nombrePersonaje = partes[avance];
                        int cantSkins = Integer.parseInt(partes[avance+1]);
                        for(int j=0;j<cantSkins;j++) {
                            String nombreSkin = partes[acumu];    
                            acumu++;
                        }
                        avance = acumu;
                        acumu+=2;
                        try {
                            boolean ingresoAsociar = system.asociarPersonajeCuenta(nombreCuenta, nombrePersonaje);
                            if(!ingresoAsociar) {
                                System.out.println("El personaje no se pudo ingresar a la cuenta por que no queda espacio");
                            }
                        }catch(Exception ex) {
                            System.out.println(ex.getMessage());
                        }
                    }
                    String region = partes[avance];
                    system.asignarRegion(nombreCuenta, region);
                }
            }catch(Exception ex) {
                System.out.println(ex.getMessage());
            }
            
        }
    }
    
    public static void leerEstadisticas(SistemaSkinShop system) throws IOException{
        System.out.println("Leyendo Estadisticas");
        Scanner s = new Scanner(new File("Estadisticas.txt"));
        while(s.hasNextLine()) {
            String line = s.nextLine();
            String [] partes = line.split(",");
            String nombrePersonaje = partes[0];
            double recaudacion = (Integer.parseInt(partes[1])*6.15);
            try {
                boolean ingresado = system.asociarEstadistica(nombrePersonaje, recaudacion);
                if(!ingresado) {
                    System.out.println("No se pudo ingresar la estadística por que no hay más espacio");
                }
            }catch(Exception ex) {
                System.out.println("\t"+ex.getMessage());
            }
        }
    }
    
    
    
    
    public static boolean inicioSesion(SistemaSkinShop system) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el Nombre de la Cuenta: ");String nombreCuenta=sc.nextLine();
        if(nombreCuenta.equals("ADMIN")) {
            System.out.print("Ingrese la contraseña: ");String contraseña=sc.nextLine();
            if(contraseña.equals("ADMIN")) {
                menuAdmin(system);
                return true;
            }
            else {
        System.out.println("Contraseña incorrecta...");
                return false;
            }
        }
        else {
            boolean existeElCliente = system.existeCliente(nombreCuenta);
            if(existeElCliente) {
                System.out.print("Ingrese la contraseña: ");String contraseña = sc.nextLine();
                boolean contraCorrecta= system.contraseñaCorrecta(nombreCuenta,contraseña);
                if(contraCorrecta) {
                    menuCliente(system,nombreCuenta);
                    return true;
                }
                else {
                    System.out.println("Contraseña incorrecta...");
                    return false;
                }
            }
            else {
                System.out.print("Desea registrarlo como un nuevo usuario(si-no): ");String respuesta = sc.nextLine();
                while(!respuesta.equalsIgnoreCase("si") && !respuesta.equalsIgnoreCase("no")) {
                    System.out.println("Ingrese (si) o (no) por favor...");
                    System.out.print("Desea registrarlo como un nuevo usuario(si-no): ");respuesta = sc.nextLine();
                }
                if(respuesta.equalsIgnoreCase("si")) {
                    System.out.println("Nombre Cuenta: "+nombreCuenta);
                    System.out.print("Contraseña: ");String contraseña = sc.nextLine();
                    System.out.print("Nick: ");String nick = sc.nextLine();
                    System.out.print("Region: ");String region = sc.nextLine();
                    System.out.print("Nivel y Rp iniciados en 0");
                    int nivel=0;
                    int rp = 0;
                    sc.nextLine();
                    boolean ingresado = system.agregarCuenta( nombreCuenta,  contraseña,  nick, nivel,  rp,  region);
                    if(ingresado) {
                        System.out.println("Cliente ingresado");
                    }
                    else {
                        System.out.println("Error al ingresar el cliente(No queda espacio en la lista de Clientes)");
                    }
                    return false;
                }
                else {
                    System.out.println("Este usuario no existe...");
                    return false;
                }
            }
        }
    }
}
