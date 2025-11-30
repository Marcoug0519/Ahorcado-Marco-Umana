import java.util.Scanner;
public class Ahorcado {
    private String[] palabrasAhorcado = {"lugia", "perro", "gato", "arbol", "cielo","mar", "dalaran", "fifa", "estrella", "flor","libro", "escuela", "camino", "clash", "ventana","amigo", "fuego", "tierra", "agua", "viento"};
    private String palabraSeleccionada;
    private char[] letrasAdivinadas;
    private int contadorErrores;
    private String letrasIntentadas;
    public Ahorcado() {
        int indice = (int)(Math.random() * palabrasAhorcado.length);
        palabraSeleccionada = palabrasAhorcado[indice];
        letrasAdivinadas = new char[palabraSeleccionada.length()];
        for (int i = 0; i < letrasAdivinadas.length; i++) {
            letrasAdivinadas[i] = '_';
        }
        contadorErrores = 0;
        letrasIntentadas = "";
    }
    public void jugar() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("¡Bienvenido al juego del Ahorcado!");
        
        while (contadorErrores < 6 && !palabraCompleta()) {
            mostrarEstado();
            char letra = solicitarLetra(scanner);
            
            if (letraIntentada(letra)) {
                System.out.println("No se puede repetir, ya intentaste con la letra '" + letra + "'.");
                continue;
            }
            
            letrasIntentadas = letrasIntentadas + letra + " ";
            
            if (verificarLetra(letra)) {
                System.out.println("¡Correcto! La letra '" + letra + "' esta en la palabra.");
            } else {
                contadorErrores++;
                System.out.println("La letra '" + letra + "' no esta en la palabra. Errores: " + contadorErrores + "/6");
            }
        }
        mostrarResultadoFinal();
    }
    private boolean palabraCompleta() {
        for (int i = 0; i < letrasAdivinadas.length; i++) {
            if (letrasAdivinadas[i] == '_') {
                return false;
            }
        }
        return true;
    }
    private void mostrarEstado() {
        System.out.println();
        System.out.print("Palabra: ");
        for (int i = 0; i < letrasAdivinadas.length; i++) {
            System.out.print(letrasAdivinadas[i] + " ");
        }
        System.out.println();
        System.out.println("Letras intentadas: " + letrasIntentadas);
        System.out.println("Errores: " + contadorErrores + "/6");
    }
    private char solicitarLetra(Scanner scanner) {
        char letra = ' ';
        boolean letraValida = false;
        
        while (!letraValida) {
            System.out.print("Ingrese una letra: ");
            String entrada = scanner.nextLine().toLowerCase();
            
            if (entrada.length() != 1) {
                System.out.println("Ingrese solo una letra.");
                continue;
            }
            
            letra = entrada.charAt(0);
            
            if (!Character.isLetter(letra)) {
                System.out.println("Entrada no valida, solo se aceptan letras.");
                continue;
            }
            
            letraValida = true;
        }
        
        return letra;
    }
    private boolean letraIntentada(char letra) {
        for (int i = 0; i < letrasIntentadas.length(); i++) {
            if (letrasIntentadas.charAt(i) == letra) {
                return true;
            }
        }
        return false;
    } 
    private boolean verificarLetra(char letra) {
        boolean letraEncontrada = false;
        for (int i = 0; i < palabraSeleccionada.length(); i++) {
            if (palabraSeleccionada.charAt(i) == letra) {
                letrasAdivinadas[i] = letra;
                letraEncontrada = true;
            }
        }
        return letraEncontrada;
    }    
    private void mostrarResultadoFinal() {
        if (palabraCompleta()) {
            System.out.println("¡GG! Has adivinado la palabra: " + palabraSeleccionada);
        } else {
            System.out.println("¡F! Has perdido. La palabra era: " + palabraSeleccionada);
        }
    }
}