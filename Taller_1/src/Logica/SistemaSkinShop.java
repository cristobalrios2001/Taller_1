
package Logica;

import Dominio.Cuenta;
import Dominio.Personaje;


public interface SistemaSkinShop {
    
   /**
     * Add the entered character to the character list
     * pos:
     *      Entering the character to the system
     * @param nombre is the name of the character
     * @param rol is the rol of the character
     * @return returns a boolean to see if the character's entry into the system was successful
     */
    public boolean agregarPersonaje(String nombre, String rol);
    
    /**
     *Add the skin to the system in case it does not exist
     * pos:
     *      Entering the skin to the system
     * @param nombre name of the skin to enter
     * @param calidad quality of the skin to enter
     * @return returns a boolean to see if the skin entry into the system was successful
     */
    public boolean agregarSkin (String nombre, String calidad);
    
    /**
     * Find the character in the system and find the skin in the system, if they exist, associate them
     * pre:
     *     That the skin and the character exist
     * pos:
     *     Associate the skin with the character in the system
     * @param nombrePersonaje character's name
     * @param rol rol of the character's
     * @param nombreSkin character skin to associate
     * @param calidad character quality
     * @return returns a boolean with the result of the process
     */
    public boolean asociarPersonajeSkin(String nombrePersonaje, String rol , String nombreSkin, String calidad);
    
    /**
     * add a skin to an existing character
     * pre:
     *      that the characters exists
     * pos:
     *      add a new skin to the system
     * @param nombrePersonaje name of the character
     * @param nombreSkin skin of the character
     * @param calidad quality character's
     * @return returns a boolean with the result of the process
     */
    public boolean ingresarSkinPersonaje(String nombrePersonaje, String nombreSkin, String calidad); // agrega una skin cuando el personaje ya existe
    
   /**
     * The account is added to the system
     * pos:
     *      The account is added to the system
     * @param nombreCuenta name of the account to enter in the system
     * @param contraseña associated account password
     * @param nick nick associated with the account
     * @param nivel level associated with the account
     * @param rp rp/ balance associated with the account
     * @param region region associated with the account
     * @return returns a boolean to know if the account was successfully entered into the system
     */
    public boolean agregarCuenta(String nombreCuenta, String contraseña, String nick,int nivel, int rp, String region);
    
    /**
     * Character is added to account
     * pre:
     *      That the account and the character exist
     * pos:
     *      Login of the character to the associated account
     * @param nickCuenta Account nick
     * @param nombrePersonaje name of the character
     * @return returns a boolean to know if the account was successfully entered into the system
     */
    public boolean asociarPersonajeCuenta(String nickCuenta, String nombrePersonaje);
    
     /**
     * The account is searched for and to which character the skin is associated and is added to the account's character
     * pre:
     *      That the account exists and that the skin exists
     * pos:
     *      Associate the skin to the account
     * @param nombreSkin name of the skin to associate
     * @param nombreCuenta account to which the skin will be associated
     */
    public void agregarSkinACuenta(String nombreSkin, String nombreCuenta);
    
   /**
     * A skin associated with the account that has logged in is purchased
     * pre:
     *      That the character exists
     *      That the skin exists
     *      That the skin is no longer purchased and that it has enough balance
     * pos:
     *      The skin of a character is purchased, adding the skin to the associated account, the rp of the account is discounted, and the collection is added to the character
     * @param nombreCuenta name of the account that is logged in
     * @param nombrePersonaje name of the character to whom the skin will be bought
     * @param nombreSkin name of the skin to be purchased
     * @return returns a boolean with the result of the skin purchase process
     */
    public boolean comprarSkin (String nombreCuenta, String nombrePersonaje, String nombreSkin);
    
    /**
     * The character is purchased for the account that has logged in
     * pre:
     *      That the account exists and that it is not associated with the account
     * pos:
     *      Associate character with account
     * @param nombreCuenta name of the account from which a character will be purchased
     * @param nombrePersonaje name of the character to be bought
     * @return returns a boolean with the result of the purchase
     */
    public boolean comprarPersonaje (String nombreCuenta, String nombrePersonaje); 
    
     /**
     * All skins available for purchase are displayed, except those you already have in purchase
     * pre:
     *      That the account exists
     * pos:
     *      All skins available for purchase are shown
     * @param nombreCuenta name of the account that consults the available skins
     * @return returns a String with the skins available to buy
     */
    public String mostrarSkinsDisponibles(String nombreCuenta);
    
     /**
     * All characters in possession of the account are displayed with their respective purchased skins
     * pre:
     *      That the account exists
     *     
     * @param nombreCuenta name of the account that consults your inventory
     * @return returns a String with all the inventory associated with the account
     */
    public String desplegarInventario (String nombreCuenta);
    
   /**
     * An amount entered by the client is recharged to recharge the balance to the account
     * pre:
     *      That the account exists
     * pos:
     *      Top up balance to your associated rp
     * @param nombreCuenta name of the account to which the rp will be recharged
     * @param newSaldo rp to recharge to the account
     * @return returns a boolean with the result of the process
     */
    public boolean recargarSaldoRP(String nombreCuenta, int newSaldo);
    
    /**
     * All the data of the account that has logged in is displayed, account name, nick, password, and the possibility of changing the password is enabled
     * pre:
     *      That the account exists
     * pos:
     *      The account information is displayed and the option to change the password is given
     * @param nombreCuenta account name
     * @return returns a String with the last 3 characters of your password
     */
    public String mostrarDatos(String nombreCuenta);
    
    /**
     * The password of the user who must enter his old password twice is changed
     * pos:
     *      Password change to the associated account
     * @param nombreCuenta name of the account to which the password will be changed
     * @param contraseñaAntigua1 old password
     * @param contraseñaAntigua2 again the old password for verification
     * @param nuevaContraseña New Password
     * @return returns a boolean to know if the password can be changed
     */
    public boolean cambiarContraseña(String nombreCuenta, String contraseñaAntigua1, String contraseñaAntigua2, String nuevaContraseña);
    
     /**
     * The collection obtained by the character role is displayed
     * @return returns a String with the collection data for the role of the characters
     */
    public String recaudacionPorRol ();
    
    /**
     * The collection obtained by account region is displayed
     * @return returns a String with the collection data by regions
     */
    public String recaudacionPorRegion ();
    
     /**
     * The collection obtained by each character is displayed
     * @return returns a String with the collection of each character
     */
    public String recaudacionPorPersonaje();
    
    /**
     * The account is searched and its status changes to blocked
     * pre:
     *      That the account exists
     * pos:
     *      Account is locked
     * @param nick nick name to block
     * @return returns a boolean with the result of the operation
     */
    public boolean bloquearCuenta(String nick);
    
    /**
     * The accounts are displayed by level from highest to lowest
     * @return returns a String with the lists of accounts ordered from highest to lowest according to the level
     */
    public String desplegarCuentasNivel();
    
    /**
     * The character is entered into the system through the administrator menu
     * pre:
     *      That the character does not exist
     * pos:
     *      A character is added to the system
     * @param nombrePersonaje character name to add
     * @param rol rol of the character
     * @param nombreSkin character skin name
     * @param calidadSkin character skin quality
     * @return returns a boolean with the result of the operation
     */
    public boolean agregarPersonajeAdmin(String nombrePersonaje,String rol,String nombreSkin,String calidadSkin);
    
    /**
     * The character is associated with the collection obtained
     * @param nombrePersonje character's name
     * @param recaudacion collection of the character
     * @return retorna a boolean with the result of the operation
     */
    public boolean asociarEstadistica(String nombrePersonje, double recaudacion); 
    
   
    /**
     * you get the available skins of a character
     * pre:
     *      that the character exists
     * @param nombreCuenta name of the account
     * @param nombrePersonaje name of the character
     * @return return a String with the character's skins
     */
    public String obtenerSkinsDisponiblesPersonaje(String nombreCuenta, String nombrePersonaje);
    
    /**
     * you get the characters available for purchase from the associated account
     * pre:
     *      that the account exists
     * @param nombreCuenta name of the account
     * @return return a Striung with de charachters avaibles
     */
    public String obtenerPersonajesDisponibles (String nombreCuenta);
    
    
     /**
     * Get the amount of character by role
     * pre:
     *      that exist  least one character
     *
     * @return return a String with the amount of character
     */
    public String obtenerCantPersonajesRol();
    
    /**
     * Check if the account exists
     * @param nombreCuenta account name     
     * @return returns the result of the session start
     */
    public boolean existeCliente (String nombreCuenta);
    
    /**
     * Check if the account and password are correct
     * @param nombreCuenta account name
     * @param contraseña password associated with the account
     * @return returns the result of the session start
     */
    public boolean contraseñaCorrecta(String nombreCuenta,String contraseña);
    
    /**
     * A region will be assigned to the account
     * @param nombreCuenta account name
     * @param region region which will be assigned
     *  pre:
     *      the account must exist
     * @return region assigned to the account
     */
    public boolean asignarRegion (String nombreCuenta, String region);
    
}
