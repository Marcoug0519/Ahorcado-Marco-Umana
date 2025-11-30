/**
 * Write a description of class Menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class Menu {
    public Menu() {
        Scanner scanner = new Scanner(System.in);
        int option = 0;
        
        while (option != 2) {
            System.out.println();
            System.out.println("=== JUEGO DEL AHORCADO ===\n1 - Jugar\n2 - Salir\nSeleccione una opcion: ");
            
            try {
                option = scanner.nextInt();
                scanner.nextLine();
                
                if (option == 1) {
                    Ahorcado juego = new Ahorcado();
                    juego.jugar();
                } else if (option == 2) {
                    System.out.println("¡Gracias por jugar! Hasta pronto.");
                } else {
                    System.out.println("Opcion invalida. Por favor, seleccione 1 o 2.");
                }
            } catch (Exception e) {
                System.out.println("Error: Debe ingresar un numero valido.");
                scanner.nextLine();
            }
        }
        
        scanner.close();
    }
}