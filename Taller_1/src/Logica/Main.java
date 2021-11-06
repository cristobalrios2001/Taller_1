package Logica;

import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author crist
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        SistemaSkinShop sistema =new SistemaSkinShopImpl();
        
        System.out.println("Agregar Nuevo Personaje");
        String nombrePersonaje = sc.next();
        String rol = sc.next();
        
        sistema.ingresarPersonajesAdmin(nombrePersonaje, rol);
        
        
    }
    
}
