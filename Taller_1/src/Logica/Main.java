package Logica;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {

    
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        SistemaSkinShop sistema =new SistemaSkinShopImpl();
        
        
        
        
        
    }
    
    public static boolean ingresoSisma(SistemaSkinShop sistema){
        Scanner sn = new Scanner(System.in);
        System.out.println("Has seleccionado la opción 1: Iniciar Sesión");
        System.out.println("Ingresar usuario: ");
        String nombreCuenta = sn.next();

        System.out.println("Ingresar Contraseña: ");
        String contraseña = sn.next();
        
        boolean estadoInicio = sistema.iniciarSesionComprobar(nombreCuenta, contraseña);
        return estadoInicio;
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
                        System.out.println("Ingresar usuario: ");
                        String nombreCuenta = sn.next();
                        
                        System.out.println("Ingresar Contraseña: ");
                        String contraseña=sn.nextLine();
                        sistema.iniciarSesionComprobar(nombreCuenta, contraseña);
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
    
    
    
    
    public static void menuCliente(SistemaSkinShop sistema){
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
                                                
                        break;
                    case 2:
                        System.out.println("\nHas seleccionado la opción 2: Comprar Personaje.");
                                                
                        break;
                    case 3:
                        System.out.println("\nHas seleccionado la opción 3: Skins Disponibles.");
                       
                        break;
                    case 4:
                        System.out.println("\nHas seleccionado la opción 4: Mostrar Inventario.");
                        
                        break;
                    case 5:
                        System.out.println("\nHas seleccionado la opción 5: Recargar RP.");
                        
                        break;
                    case 6:
                        System.out.println("\nHas seleccionado la opción 6: Mostrar Datos de Cuenta.");
                        
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
    /*
     * public static void menuAdmin()
    {   Scanner sc = new Scanner(System.in);
        recaudacionRol();
        recaudacionPorRegion();
        recaudacionPorPersonaje();
        cantidadDePersonajesPorRol();
        int opcion;
        do{
            System.out.println("1. Agregar personaje.");
            System.out.println("2. Agregar Skin.");
            System.out.println("3. Bloquear un jugador.");
            try
            {
                System.out.print("Escribe una de las opciones: ");
                opcion = sc.nextInt();
                switch (opcion){
                    case 1:
                        System.out.println("\nHas seleccionado la opción 1:  Agregar personaje.");
                            
                    case 2:
                        System.out.println("\nHas seleccionado la opción 2:  Agregar Skin.");
                        
                    case 3:
                        System.out.println("\nHas seleccionado la opción 3:  Bloquear un Jugador.");
                        
                    default:
                        System.out.println("\nSolo números entre 1 y 3");
               }    
    
            }catch(InputMismatchException e){
                System.out.println("Debes insertar un número");
                sc.next();
            }
        }
        while(!salir);
    }
    */

}
